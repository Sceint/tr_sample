package sample.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class ParkingAreaDAOImpl implements ParkingAreaDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addParkingArea(ParkingAreaEntity parkingArea) {
		Session session = getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.save(parkingArea);
		trans.commit();
	}

	@SuppressWarnings("unchecked")
	public List<ParkingAreaEntity> getAllParkingAreas() {
		Session session = getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		List<ParkingAreaEntity> parkingAreas = this.sessionFactory.getCurrentSession().createQuery("from ParkingAreaEntity").list();
		trans.commit();
		return parkingAreas;
	}

	public void deleteParkingArea(Integer parkingAreaId) {
		Session session = getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		ParkingAreaEntity employee = (ParkingAreaEntity) sessionFactory.getCurrentSession()
		        .load(ParkingAreaEntity.class, parkingAreaId);
		if (null != employee) {
			this.sessionFactory.getCurrentSession().delete(employee);
		}
		trans.commit();
	}
}