package sample.hibernate;

import java.util.List;

public interface ParkingAreaDAO {
	public void addParkingArea(ParkingAreaEntity parkingArea);

	public List<ParkingAreaEntity> getAllParkingAreas();

	public void deleteParkingArea(Integer parkingAreaId);
}
