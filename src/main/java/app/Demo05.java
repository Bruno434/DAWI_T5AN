package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {

	public static void main(String[] args) {
		// fabrica-- DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// Manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		// Empiezo el proceso
		em.getTransaction().begin();
		try {
			// proceso
			// forma 1. Eliminacion Logica o actualizacion de estados
			// forma 2. Eliminacion Fisica o Delete
			Usuario u = em.find(Usuario.class, 10);
			if (u == null)
				System.err.print("No existe");
			else {
				em.remove(u);// !!ojo..Nesecitas un obj con se debe devolver
				// confirmacion
				em.getTransaction().commit();
				System.out.print("Terminó........");
			}
		} catch (Exception e) {
			System.err.print("Erorr........ " + e.getMessage());
			// em.getTransaction().rollback();
		}
		// cierre
		em.close();
	}

}
