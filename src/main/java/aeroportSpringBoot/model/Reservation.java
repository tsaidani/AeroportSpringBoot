package aeroportSpringBoot.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@SequenceGenerator(name="seqIdReservation",sequenceName="seq_id_reservation", initialValue=50,allocationSize=1)
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqIdReservation")
	@Column(name="id_reservation",length =100)
	private Integer numeroReservation;
	@Column(name="date_reservation",length =100)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateReservation;

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	@Column(name = "heure_reservation", length = 20)
	private Date heureReservation;

	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	@ManyToOne
	@JoinColumn(name="id_passager")
	private Passager passager;
	@ManyToOne
	@JoinColumn(name="id_vol")
	private Vol vol;
	@Version
	@Column(name="version",length =10)
	private int version;
	
	public Reservation() {
		
	}

	public Date getHeureReservation() {
		return heureReservation;
	}

	public void setHeureReservation(Date heureReservation) {
		this.heureReservation = heureReservation;
	}

	public Integer getNumeroReservation() {
		return numeroReservation;
	}

	public void setNumeroReservation(Integer numeroReservation) {
		this.numeroReservation = numeroReservation;
	}


	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroReservation == null) ? 0 : numeroReservation.hashCode());
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
		Reservation other = (Reservation) obj;
		if (numeroReservation == null) {
			if (other.numeroReservation != null)
				return false;
		} else if (!numeroReservation.equals(other.numeroReservation))
			return false;
		return true;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	

	
}
