package app;





import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo08 {
	public static void main(String[] args) {
		//obtener la conexion con mi bd 
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		//VALIDAR UN USUARIO SEGUN SU USUARIO Y SU CLAVE 

		String sql2 = "select u from Usuario u where u.usuario = :xusr and u.clave= :xcla";
		
		TypedQuery<Usuario> query = em.createQuery(sql2, Usuario.class);
		query.setParameter("xusr", "U002@gmail.com");
		query.setParameter("xcla", "10002");
		
		Usuario u= null;
		try {
			u = query.getSingleResult();
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
