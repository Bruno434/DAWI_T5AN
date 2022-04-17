package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {

	public static void main(String[] args) {
		// Actualizar usuario nuevo
		Usuario u= new Usuario();
		u.setCod(10);
		u.setNom("Bruno");
		u.setApe("Riossss");
		u.setUsu("Bruno22@hotmail.com");//UNIQUE
		u.setClave("aaaa");
		u.setFecna("2002/01/23");
		u.setTipo(2);
		u.setEsta(1);
		//Proceso de actualizacion o registro si no existe
		EntityManagerFactory fabrica =Persistence.createEntityManagerFactory("mysql");
		EntityManager em=fabrica.createEntityManager();
		em.getTransaction().begin();
		try {		
			//??? actualizar
			em.merge(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.print("Erorr........ "+ e.getMessage());
			//em.getTransaction().rollback();
		}

		em.close();
		System.out.print("Terminó........");
	}

}
