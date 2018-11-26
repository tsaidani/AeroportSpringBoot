package aeroportSpringBoot.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("El")
public class ClientEl extends Client {
	@Column
	@JsonView(JsonViews.Common.class)
	private String prenom;

	public ClientEl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
