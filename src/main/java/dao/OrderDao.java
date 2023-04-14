package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Customer;
import model.Order;

public class OrderDao {

	// passer une commande
	public void placeOrder(Order o) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.persist(o);

		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	
	// afficher la liste des clients
	public List<Order> showListOrder() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(Order.class);

		List<Order> orderList = (List<Order>) criteria.list();
		
		transaction.commit();
		session.close();
		sessionFactory.close();

		return orderList;
	}

}
