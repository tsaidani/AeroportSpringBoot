package aeroportSpringBoot.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@SequenceGenerator(name="seq__login",sequenceName="seq_login",initialValue=10,allocationSize = 1)
@Table(name="login")

public class Login {
	@Id
	@GeneratedValue(generator="seq__login",strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="identifiant")
	private String login;
	@Column(name="mot_de_passe")
	private String motDePasse;
	@Column(name="droit_administrateur")
	private Boolean admin_id;
	@Version
	private int version;
	@OneToOne(mappedBy="login")
	private Client client;
	@OneToMany(mappedBy = "login")
	private Set<LoginRole> roles;
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Login(String login, String motDePasse) {
		super();
		this.login = login;
		this.motDePasse = motDePasse;
	}



	public Integer getId() {
		return id;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public Boolean getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Boolean admin_id) {
		this.admin_id = admin_id;
	}
	public int getVersion() {
		return version;
	}

	

	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public Set<LoginRole> getRoles() {
		return roles;
	}



	public void setRoles(Set<LoginRole> roles) {
		this.roles = roles;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

