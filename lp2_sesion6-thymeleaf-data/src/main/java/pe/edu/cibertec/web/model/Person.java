package pe.edu.cibertec.web.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idperson;

	@Temporal(TemporalType.DATE)
	private Date datebirth;

	private String fistname;

	private String lastname;
	
	@OneToOne(mappedBy="person")
	private User user;

	//bi-directional many-to-one association to User
//	@OneToMany(mappedBy="person")
//	private List<User> users;

	public Person() {
	}

	public Integer getIdperson() {
		return this.idperson;
	}

	public void setIdperson(Integer idperson) {
		this.idperson = idperson;
	}

	public Date getDatebirth() {
		return this.datebirth;
	}

	public void setDatebirth(Date datebirth) {
		this.datebirth = datebirth;
	}

	public String getFistname() {
		return this.fistname;
	}

	public void setFistname(String fistname) {
		this.fistname = fistname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public List<User> getUsers() {
//		return this.users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}

//	public User addUser(User user) {
//		getUsers().add(user);
//		user.setPerson(this);
//
//		return user;
//	}
//
//	public User removeUser(User user) {
//		getUsers().remove(user);
//		user.setPerson(null);
//
//		return user;
//	}

}