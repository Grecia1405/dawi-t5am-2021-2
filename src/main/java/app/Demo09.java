package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Usuario;

public class Demo09 {
	public static void main(String[] args) {
		//obtener la conexion con mi bd 
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		//VALIDAR UN USUARIO SEGUN SU USUARIO Y SU CLAVE ->usar procedimientos almacenados

		//String sql2 = "{call usp_validaAcceso (:xusr, :xcla)}";
		String sql2 = "{call usp_validaAcceso (?, ?)}";
		//TypedQuery<Usuario> query = em.createQuery(sql2, Usuario.class); JPA
		Query query = em.createNativeQuery(sql2, Usuario.class); //OBJECT
		//query.setParameter("xusr", "U002@gmail.com");
		//query.setParameter("xcla", "10002");
		query.setParameter(1, "U002@gmail.com");
		query.setParameter(2, "10002");
		
		Usuario u= null;
		try {
			u = (Usuario) query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (u == null) {
			System.out.println("CODIGO NO EXISTE");
		} else {
			System.out.println("Bienvenido...:" + u.getNombre());
			System.out.println(u);
		}
		em.close();
		
	}
}
