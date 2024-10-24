package pe.edu.cibertec.ef.biblioteca.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 60, nullable = false)
	private String nombre;
	
	@Column(length = 60, nullable = false)
	private String apellido;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechanac;
	
	@Column(nullable = false , unique = true)
	private String correo;
	
	@Column(nullable = false)
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechanac() {
		return fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Usuario() {
		super();
	}

	public Usuario(int id, String nombre, String apellido, Date fechanac, String correo, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanac = fechanac;
		this.correo = correo;
		this.password = password;
	}

	public Usuario(int id) {
		super();
		this.id = id;
	}

	public Usuario(String nombre, String apellido, Date fechanac, String correo, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanac = fechanac;
		this.correo = correo;
		this.password = password;
	}
	
	
}
