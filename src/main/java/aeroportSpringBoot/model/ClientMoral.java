package aeroportSpringBoot.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("M")
public class ClientMoral extends Client{


	@Column
	@JsonView(JsonViews.Common.class)
	private String siret;
	public ClientMoral() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getSiret() {
		return siret;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}

}
