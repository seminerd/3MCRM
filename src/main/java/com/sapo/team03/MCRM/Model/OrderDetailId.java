package com.sapo.team03.MCRM.Model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrderDetailId implements Serializable {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDonhang == null) ? 0 : idDonhang.hashCode());
		result = prime * result + ((idHanghoa == null) ? 0 : idHanghoa.hashCode());
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
		OrderDetailId other = (OrderDetailId) obj;
		if (idDonhang == null) {
			if (other.idDonhang != null)
				return false;
		} else if (!idDonhang.equals(other.idDonhang))
			return false;
		if (idHanghoa == null) {
			if (other.idHanghoa != null)
				return false;
		} else if (!idHanghoa.equals(other.idHanghoa))
			return false;
		return true;
	}
	private Long idDonhang;
	private Long idHanghoa;
}
