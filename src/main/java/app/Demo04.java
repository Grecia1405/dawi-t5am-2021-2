package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {

	public static void main(String[] args) {
		//obtener la conexion con mi bd 
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		//ELIMINAR
		Usuario u = em.find(Usuario.class, 20);
		if (u == null) {
			System.out.println("CODIGO NO EXISTE");
		} else {
			System.out.println("Bienvenido...:" + u.getNombre());
			System.out.println(u);
		}
		em.close();
		
	}
}
