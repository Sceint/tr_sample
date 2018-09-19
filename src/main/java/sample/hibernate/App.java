package sample.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("bean-config.xml");

		ParkingAreaDAOImpl obj = appContext.getBean("parkingAreaDAOImpl", ParkingAreaDAOImpl.class);

		obj.addParkingArea(new ParkingAreaEntity("Sample", 10));
		System.out.println("After adding an Entity : \n" + obj.getAllParkingAreas());

		obj.deleteParkingArea(4);
		
		System.out.println("Before deleting an Entity : \n" + obj.getAllParkingAreas());
	}
}
