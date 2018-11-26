package aeroportSpringBoot.model;

import java.util.List;
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

@Entity
@Table(name = "ville")
@SequenceGenerator(name = "seqVille", sequenceName = "seq_ville", initialValue = 1, allocationSize = 1)
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVille")
	@Column(name = "id_ville", length = 50, nullable = false)
	private Integer idVille;
	@Column(name = "nom_ville", length = 150)
	private String nom;
	@OneToMany(mappedBy = "key.ville")
	private Set<VilleAeroport> villeAeroports;
	@Version
	private int version;

	public Ville() {

	}

	public Integer getIdVille() {
		return idVille;
	}

	public void setIdVille(Integer idVille) {
		this.idVille = idVille;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<VilleAeroport> getVilleAeroports() {
		return villeAeroports;
	}

	public void setVilleAeroports(Set<VilleAeroport> villeAeroports) {
		this.villeAeroports = villeAeroports;
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
		result = prime * result + ((idVille == null) ? 0 : idVille.hashCode());
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
		Ville other = (Ville) obj;
		if (idVille == null) {
			if (other.idVille != null)
				return false;
		} else if (!idVille.equals(other.idVille))
			return false;
		return true;
	}

}
