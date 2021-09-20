package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo06 {
	public static void main(String[] args) {
	
	EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
	EntityManager em = fabrica.createEntityManager();
	System.out.println("LISTADO DE USUARIOS");
	String sql = "select u from Usuario u";
	List<Usuario> lstUsuarios = em.createQuery(sql, Usuario.class).getResultList();
	System.out.println("CANTIDAD DE USUARIOS" + lstUsuarios.size());
	for (Usuario u : lstUsuarios) {
		System.out.println(">>>"+ u);
	}
	
	System.out.println("LISTADO DE USUARIOS x tipo");
	String sql2 = "select u from Usuario u where u.tipo = :xtipo";
	TypedQuery<Usuario> query = em.createQuery(sql2, Usuario.class);
	query.setParameter("xtipo", 1);
	List<Usuario> lstUsuarios2 = query.getResultList();
	System.out.println("CANTIDAD DE USUARIOS" + lstUsuarios2.size());
	for (Usuario u : lstUsuarios2) {
		System.out.println(">>>"+ u);
	}
	em.close();
	
	}
}
