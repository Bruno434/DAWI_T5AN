package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {

	public static void main(String[] args) {
		// Agregar un nuevo usuario
		Usuario u= new Usuario();
		u.setCod(11);
		u.setNom("Carla");
		u.setApe("Toroooo");
		u.setUsu("Bruno@hotmail.com");//UNIQUE
		u.setClave("aaaa");
		u.setFecna("2002/01/23");
		u.setTipo(1);
		u.setEsta(1);
		//Proceso de Registro
		EntityManagerFactory fabrica =Persistence.createEntityManagerFactory("mysql");
		EntityManager em=fabrica.createEntityManager();
		em.getTransaction().begin();
		try {
			//??? registrar
			em.persist(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.print("Erorr........ "+ e.getMessage());
			//em.getTransaction().rollback();
		}

		em.close();
		System.out.print("Terminó........");
	}

}
