package aeroportSpringBoot.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CompagnieVolKey implements Serializable {
	@ManyToOne
	@JoinColumn(name = "id_compagnie")
	private Compagnie compagnie;
	@ManyToOne
	@JoinColumn(name = "id_vol")
	private Vol vol;

	public CompagnieVolKey() {

	}

	public CompagnieVolKey(Compagnie compagnie, Vol vol) {
		this.compagnie = compagnie;
		this.vol = vol;
	}

	public Compagnie getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(Compagnie compagnie) {
		this.compagnie = compagnie;
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
		result = prime * result + ((compagnie == null) ? 0 : compagnie.hashCode());
		result = prime * result + ((vol == null) ? 0 : vol.hashCode());
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
		CompagnieVolKey other = (CompagnieVolKey) obj;
		if (compagnie == null) {
			if (other.compagnie != null)
				return false;
		} else if (!compagnie.equals(other.compagnie))
			return false;
		if (vol == null) {
			if (other.vol != null)
				return false;
		} else if (!vol.equals(other.vol))
			return false;
		return true;
	}
}
