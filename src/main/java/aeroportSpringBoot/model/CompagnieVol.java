package aeroportSpringBoot.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class CompagnieVol {
	@EmbeddedId
	private CompagnieVolKey key;

	public CompagnieVol() {

	}

	public CompagnieVolKey getKey() {
		return key;
	}

	public void setKey(CompagnieVolKey key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		CompagnieVol other = (CompagnieVol) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
}
