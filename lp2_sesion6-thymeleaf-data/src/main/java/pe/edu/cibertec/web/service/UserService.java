package pe.edu.cibertec.web.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.web.model.User;
import pe.edu.cibertec.web.repository.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	public User validateUserByNameAndPassword(String name, String password) {
		
		User u = userRepository.findByNameAndPassword(name, password);
		
		return u;
	}
	
	public User updateUserLogin(User user) {
//		User u = userRepository.getReferenceById(user.getIduser());
//		u.setLastlogin(new Date());
//		return userRepository.save(u);
		return userRepository.save(user);
	}
}
