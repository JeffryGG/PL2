package pe.edu.cibertec.ef.biblioteca.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.cibertec.ef.biblioteca.bd.MySQLDataSource;
import pe.edu.cibertec.ef.biblioteca.model.Usuario;
import pe.edu.cibertec.ef.biblioteca.repository.UsuarioRepository;
import pe.edu.cibertec.ef.biblioteca.service.UsuarioServicio;




@Controller
public class UsuarioController {

	
	@Autowired
	private UsuarioRepository usuariorep;
	
	@Autowired
	private UsuarioServicio usuarioserv;
	
	@GetMapping("/login")
	public String loginView(Model model) {
		System.out.println("Mostrando login");
		model.addAttribute("usuarioLogin", new Usuario());
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute Usuario usuario, Model model) {
		System.out.println("Validando login");		
		String redirect = "login";
		Usuario u = usuarioserv.validateUserByEmailAndPassword(usuario.getCorreo(), usuario.getPassword());
		if (u != null) {
			//System.out.println("Actualizando usuario");
			Usuario updUsuario = usuarioserv.updateUserLogin(u);
			model.addAttribute("usuarioLogin", updUsuario);
			redirect = "redirect:/usuario";
		} else {
			model.addAttribute("errors", "Usuario o clave incorrectos");
			model.addAttribute("usuarioLogin", new Usuario());
		}
		
		return redirect;
	}
	
	@GetMapping("/registrar")
	public String mostrarRegistro(Model model) {

		model.addAttribute("usuario" , new Usuario());
		return "usuario_formulario";
	}
	
	@PostMapping("/registrar/guardar")
	public String guardarUsuario(Usuario usuario) {
		usuariorep.save(usuario);
		
		return "redirect:/login";
	}
	
	@GetMapping("/usuario")
	public String listarUsuario(Model model) {
		try {
			model.addAttribute("ltsUsuario", usuariorep.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listarUsuario";
	}
	
	@RequestMapping(value = "/UsuarioReport", method = RequestMethod.GET)
	public void personaReporte(HttpServletResponse response) throws JRException, IOException {
		System.out.println("Generando reporte...");
		
		InputStream is = this.getClass().getResourceAsStream("/ReporteUsuario.jasper");
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		JasperReport jasperReport = (JasperReport)JRLoader.loadObject(is);
		
		Connection con = MySQLDataSource.getMySQLConnection();
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
		
		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "inline; filename=person-report.pdf");
		
		OutputStream outputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	}
}
