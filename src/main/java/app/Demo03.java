package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	public static void main(String[] args) {
		//obtener la conexion con mi bd 
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		//ELIMINAR 
		Usuario u = new Usuario();
		u.setCodigo(20);
		
		
		// transacciones
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		System.out.println("ELIMINACION OK");
		em.close();
		
	}

}
