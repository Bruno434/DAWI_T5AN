package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo07 {

	public static void main(String[] args) {
		// lista los usuarios segun el tipo con parametros
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		// fabrica == DAO
		EntityManager em = fabrica.createEntityManager();
		// Empiezo el proceso == En Listado no es nesesario em.getTransaction().begin();
		// Select * from tb_usuarios where idtipo=? 
		TypedQuery<Usuario> consulta = em.createQuery("select u from Usuario u where tipo = :xtipo", Usuario.class);
		consulta.setParameter("xtipo", 2);
		// establecer parametros
		List<Usuario> list = consulta.getResultList();

		for (Usuario u : list) {
			System.out.print(u);
		}
		// cierre
		em.close();
	}
}
