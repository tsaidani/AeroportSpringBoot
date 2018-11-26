package aeroportSpringBoot.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@SequenceGenerator(name = "seqIdvol", sequenceName = "seq_id_vol", initialValue = 50, allocationSize = 1)
public class Vol {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqIdvol")
	@Column(name = "id_vol", length = 20)
	@JsonView(JsonViews.Common.class)
	private Integer idVol;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "date_depart", length = 20)
	@JsonView(JsonViews.Common.class)
	private Date dateDepart;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "date_arrivee", length = 20)
	@JsonView(JsonViews.Common.class)
	private Date dateArrivee;

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	@Column(name = "heure_depart", length = 20)
	@JsonView(JsonViews.Common.class)
	private Date heureDepart;

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	@JsonView(JsonViews.Common.class)
	@Column(name = "heure_arrivee", length = 20)
	private Date heureArrivee;

	@OneToMany(mappedBy = "key.vol")
	@Column(name = "compagnie", length = 20) 
	private List<CompagnieVol> compagniesVol;

	@OneToMany(mappedBy = "vol")
	@Column(name = "vol_id", length = 100)
	@JsonView(JsonViews.VolWithReservation.class)
	private List<Reservation> reservations = new ArrayList<>();;

	@ManyToOne
	@JsonView(JsonViews.Common.class)
	@JoinColumn(name = "id_aeroport_depart")
	private Aeroport aeroportDepart;
	@ManyToOne
	@JoinColumn(name = "id_aeroport_arrivee")
	@JsonView(JsonViews.Common.class)
	private Aeroport aeroportArrivee;
	@Version
	@Column(name = "version", length = 10)
	private int version;

	public Vol() {

	}

	public Integer getIdVol() {
		return idVol;
	}

	public void setIdVol(Integer idVol) {
		this.idVol = idVol;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Date getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public List<CompagnieVol> getCompagniesVol() {
		return compagniesVol;
	}

	public void setCompagniesVol(List<CompagnieVol> compagniesVol) {
		this.compagniesVol = compagniesVol;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}

	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
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
		result = prime * result + ((idVol == null) ? 0 : idVol.hashCode());
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
		Vol other = (Vol) obj;
		if (idVol == null) {
			if (other.idVol != null)
				return false;
		} else if (!idVol.equals(other.idVol))
			return false;
		return true;
	}

}
