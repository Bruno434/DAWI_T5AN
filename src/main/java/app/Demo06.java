package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.Usuario;


public class Demo06 {
	public static void main(String[] args) {
		// Listaod de todos los Usuarios
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// fabrica == DAO
		EntityManager em = fabrica.createEntityManager();
		// Empiezo el proceso == En Listado no es nesesario em.getTransaction().begin();
		//Select * from tb_usuarios ---> Select u.* from tb_usuarios u
		TypedQuery<Usuario> consulta = em.createQuery("select u from Usuario u",Usuario.class);
		//establecer parametros
		List<Usuario> list= consulta.getResultList();
		 
		 for(Usuario u: list) {
			 System.out.print(u);
		 }
		// cierre
		em.close();
	}
}
