package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Product;

public class ProductDao {

	//ajouter un produit
	public void addProduct(Product p) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.persist(p);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	//afficher la liste des produits
	public List<Product> showList() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Product.class);
		
		List<Product> pList = (List<Product>) criteria.list();

		transaction.commit();
		session.close();
		sessionFactory.close();

		return pList;
	}

	
	//rechercher un produit
	public Product trackProduct(Integer id) {

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Product product = session.get(Product.class, id);
		System.out.println(product);
		
		transaction.commit();
		session.close();
		sessionFactory.close();

		return product;

	}

	//modifier une fiche produit
	public void editProduct(Integer id, String nom, String prix) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Product product = session.get(Product.class, id);

		product.setName(nom);
		product.setPrice(prix);

		session.flush();
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	//supprimer un produit
	public void removeProduct(Integer id) {

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Product product = session.get(Product.class, id);
		
		session.delete(product);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
