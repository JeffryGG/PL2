package pe.edu.cibertec.ef.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.ef.biblioteca.model.Usuario;
import pe.edu.cibertec.ef.biblioteca.repository.UsuarioRepository;

@Service
public class UsuarioServicio {
	
	@Autowired
	private UsuarioRepository usuariorep;
	
	public Usuario validateUserByEmailAndPassword(String email, String password) {
		Usuario u = usuariorep.findByEmailAndPassword(email, password);
		return u;
	}
	
	public Usuario updateUserLogin(Usuario usuario) {
		return usuariorep.save(usuario);
	}

	
}
