package pe.edu.cibertec.ef.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.cibertec.ef.biblioteca.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query("SELECT u FROM Usuario u WHERE u.correo = ?1 AND u.password = ?2")
	Usuario findByEmailAndPassword(String emailAddress, String password);
	
	
}
