package sample.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Arpan_Ladani
 */
@Entity
@Table(name = "PARKING_AREA")
public class ParkingAreaEntity implements Serializable {

	/**
	 * auto-generated.
	 */
	private static final long serialVersionUID = 114589386408800637L;

	private Integer parkingAreaId;
	private String parkingAreaName;
	private Integer noOfSlots;

	public ParkingAreaEntity() {

	}

	public ParkingAreaEntity(String parkingAreaName, Integer noOfSlots) {
		this.setParkingAreaName(parkingAreaName);
		this.setNoOfSlots(noOfSlots);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PARKING_AREA_ID")
	public Integer getParkingAreaId() {
		return parkingAreaId;
	}

	public void setParkingAreaId(Integer parkingAreaId) {
		this.parkingAreaId = parkingAreaId;
	}

	@Column(name = "PARKING_AREA_NAME")
	public String getParkingAreaName() {
		return parkingAreaName;
	}

	public void setParkingAreaName(String parkingAreaName) {
		this.parkingAreaName = parkingAreaName;
	}

	@Column(name = "NO_OF_SLOTS")
	public Integer getNoOfSlots() {
		return noOfSlots;
	}

	public void setNoOfSlots(Integer noOfSlots) {
		this.noOfSlots = noOfSlots;
	}

	@Override
	public String toString() {
		return "<ParkingAreaId : " + getParkingAreaId() + ", parkingAreaName : " + getParkingAreaName() + ", NumberOfSlots : " + getNoOfSlots() + ">";
	}
}
