package main;

import java.net.UnknownHostException;

import org.apache.logging.log4j.core.Logger;
import org.hibernate.Session;

import model.BME280;
import util.HibernateUtil;
import util.Static;

public class Application {
	private static Logger log;
	public static void main(String[] args) throws UnknownHostException {
		//***********
		
		System.out.println(System.getProperty("user.dir"));
		Static.getLog().info("hello");
		//***********
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		//Add new Employee object
		BME280 sensor = new BME280(25,15,11);
		session.save(sensor);

		session.getTransaction().commit();
		HibernateUtil.shutdown();
		//***********
	}
}
