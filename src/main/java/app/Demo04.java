package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {

	public static void main(String[] args) {
		//Obj== Mostrar y devolver los datos de Usuario, segun su codigo.
		
		// fabrica-- DAO
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
				// Manejador de entidades
				EntityManager em = fabrica.createEntityManager();
				// Empiezo el proceso == En Busqueda no es nesesario em.getTransaction().begin();
				
					// Select					
					Usuario u= em.find(Usuario.class,10);
					if(u==null)
						System.out.print("No existe");
					else
					System.out.print(u);
		//cierre
				em.close();
	}

}
