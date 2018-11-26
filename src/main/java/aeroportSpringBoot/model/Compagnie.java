package aeroportSpringBoot.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "compagnie")
@SequenceGenerator(name = "seqCompagnie", sequenceName = "seq_compagnie", initialValue = 5, allocationSize = 5)
public class Compagnie {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompagnie")
	@Column(name = "id_compagnie", length = 50, nullable = false)
	private Integer idCompagnie;
	@Column(name = "nom_compagnie", length = 150)
	@JsonView(JsonViews.Common.class)
	private String nom;
	@OneToMany(mappedBy = "key.compagnie") 
	private Set<CompagnieVol> compagnieVols;
	@Version
	private int version;

	public Compagnie() {

	}

	public Integer getIdCompagnie() {
		return idCompagnie;
	}

	public void setIdCompagnie(Integer idCompagnie) {
		this.idCompagnie = idCompagnie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<CompagnieVol> getCompagnieVols() {
		return compagnieVols;
	}

	public void setCompagnieVols(Set<CompagnieVol> compagnieVols) {
		this.compagnieVols = compagnieVols;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCompagnie == null) ? 0 : idCompagnie.hashCode());
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
		Compagnie other = (Compagnie) obj;
		if (idCompagnie == null) {
			if (other.idCompagnie != null)
				return false;
		} else if (!idCompagnie.equals(other.idCompagnie))
			return false;
		return true;
	}

}
