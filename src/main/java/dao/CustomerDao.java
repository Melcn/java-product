package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Customer;

public class CustomerDao {
	
	//ajouter un client
		public void addCustomer(Customer c) {
			Configuration configuration = new Configuration().configure();
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			session.persist(c);
			
			transaction.commit();
			session.close();
			sessionFactory.close();
		}

		//afficher la liste des clients
		public List<Customer> showCustomerList() {
			Configuration configuration = new Configuration().configure();
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Customer.class);
			
			List<Customer> CustomerList = (List<Customer>) criteria.list();

			transaction.commit();
			session.close();
			sessionFactory.close();

			return CustomerList;
		}
		
		//rechercher un client
		public Customer trackCustomer (Integer id) {

			Configuration configuration = new Configuration().configure();
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Customer customer = session.get(Customer.class, id);
			System.out.println(customer);
			
			transaction.commit();
			session.close();
			sessionFactory.close();

			return customer;

		}

		//modifier une fiche customer
		public void editCustomer(Integer id, String mail, String adress) {
			Configuration configuration = new Configuration().configure();
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Customer customer = session.get(Customer.class, id);

			customer.setMail(mail);
			customer.setAdress(adress);
			

			session.flush();
			transaction.commit();
			session.close();
			sessionFactory.close();
		}

		//supprimer un client
		public void removeProduct(Integer id) {

			Configuration configuration = new Configuration().configure();
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Customer customer = session.get(Customer.class, id);
			
			session.delete(customer);
			
			transaction.commit();
			session.close();
			sessionFactory.close();
		}


}
