package pe.edu.cibertec.web.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@NamedQuery(name="User.remove", query="DELETE FROM User u WHERE u.iduser = :param")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private int age;

	@Temporal(TemporalType.DATE)
	private Date created;

	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	private Date firstlogin;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer iduser;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastlogin;

	private String name;

	private String password;
	
	@OneToOne
	private Person person;

	//bi-directional many-to-one association to Person
//	@ManyToOne
//	private Person person;

	//bi-directional many-to-one association to Role
	@ManyToOne
	private Role role;
	
	public User() {
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFirstlogin() {
		return this.firstlogin;
	}

	public void setFirstlogin(Date firstlogin) {
		this.firstlogin = firstlogin;
	}

	public Integer getIduser() {
		return this.iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	public Date getLastlogin() {
		return this.lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}