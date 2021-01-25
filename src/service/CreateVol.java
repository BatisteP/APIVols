package service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import model.Vol;

import javax.persistence.EntityManager;
@PersistenceUnit(unitName = "Airport")
public class CreateVol {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("APITest");
		EntityManager entitymanager = emfactory.createEntityManager( );
	      entitymanager.getTransaction( ).begin( );
	    Vol vol = new Vol();
	    vol.setNumVol("1234");
	    vol.setVilleArrivee("Macon");
	    vol.setVilleDepart("Shangai");
	    vol.setHeureDepart(0016);
	    entitymanager.persist(vol);
	    entitymanager.getTransaction().commit();
	    entitymanager.close();
	    emfactory.close();
	      

	}

}
