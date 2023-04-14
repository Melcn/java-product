package dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Produit;

public class ProduitDao {
	
	public void ajouterProduit(Produit p) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.persist(p);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	public List<Produit> afficherTousProduits() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Produit.class);
		List<Produit> produits = (List<Produit>) criteria.list();

		transaction.commit();
		session.close();
		sessionFactory.close();

		return produits;
	}

	public Produit rechercherProduit(Integer id) {

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Produit produit = session.get(Produit.class, id);
		System.out.println(produit);
		transaction.commit();
		session.close();
		sessionFactory.close();

		return produit;

	}

	public void modifierProduit(Integer id, String nom, String prix) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Produit produit = session.get(Produit.class, id);
		
		produit.setNom(nom);
		produit.setPrix(prix);
		
		session.flush();
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	public void supprimerProduit(Integer id) {
		
		Configuration configuration = new Configuration().configure();
				SessionFactory sessionFactory = configuration.buildSessionFactory();
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				Produit utilisateur = session.get(Produit.class, id);
				session.delete(utilisateur);
				transaction.commit();
				session.close();
				sessionFactory.close();
	}

}
