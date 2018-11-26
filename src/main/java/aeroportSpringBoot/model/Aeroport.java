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
@Table(name = "aeroport")
@SequenceGenerator(name = "seqAeroport", sequenceName = "seq_aeroport", initialValue = 10, allocationSize = 10)
public class Aeroport {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAeroport")
	@Column(name = "id_aeroport", length = 5, nullable = false)
	private Integer idAeroport;
	@Column(name = "nom_aeroport", length = 150)
	private String nom;
	@OneToMany(mappedBy = "key.aeroport")
	private Set<VilleAeroport> villesAeroport;
	@OneToMany(mappedBy = "key.aeroport")
	@Column(name = "vol", length = 100)
	private Set<Escale> escales;
	@Version
	private int version;

	public Aeroport() {

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getIdAeroport() {
		return idAeroport;
	}

	public void setIdAeroport(Integer idAeroport) {
		this.idAeroport = idAeroport;
	}

	public Set<VilleAeroport> getVillesAeroport() {
		return villesAeroport;
	}

	public void setVillesAeroport(Set<VilleAeroport> villesAeroport) {
		this.villesAeroport = villesAeroport;
	}

	public Set<Escale> getEscales() {
		return escales;
	}

	public void setEscales(Set<Escale> escales) {
		this.escales = escales;
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
		result = prime * result + ((idAeroport == null) ? 0 : idAeroport.hashCode());
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
		Aeroport other = (Aeroport) obj;
		if (idAeroport == null) {
			if (other.idAeroport != null)
				return false;
		} else if (!idAeroport.equals(other.idAeroport))
			return false;
		return true;
	}

}
