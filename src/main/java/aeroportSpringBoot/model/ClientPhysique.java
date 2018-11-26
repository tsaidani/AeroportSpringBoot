package aeroportSpringBoot.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("P")
public class ClientPhysique extends Client {

	@Column
	private String prenom;
	public ClientPhysique() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String string) {
		prenom = string;
	}

	
}
