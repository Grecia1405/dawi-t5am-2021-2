package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
	public static void main(String[] args) {
		//obtener la conexion con mi bd 
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		//ACTUALIZAR 
		Usuario u = new Usuario();
		u.setCodigo(20);
		u.setNombre("Eren");
		u.setApellido("Jeager");
		u.setUsuario("eren24@gmail.com");
		u.setClave("paloma");
		u.setFnacim("2021/08/24");
		u.setTipo(1);
		u.setEstado(1);
		
		// transacciones
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		System.out.println("ACTUALIZACION OK");
		em.close();
		
	}
}
