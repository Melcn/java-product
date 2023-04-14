package model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trackNumber;
	
	@OneToMany
	List<Product> listOrder = new ArrayList<Product>();

	
	public Integer getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(Integer trackNumber) {
		this.trackNumber = trackNumber;
	}

	
	@Override
	public String toString() {
		return "Order [trackNumber=" + trackNumber + "]";
	}
	
	
	
	
}
