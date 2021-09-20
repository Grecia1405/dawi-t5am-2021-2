package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	public static void main(String[] args) {
		//obtener la conexion -> según la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//crear los DAO usando fabrica
		EntityManager em= fabrica.createEntityManager();
		
		//proceso : Eliminar nuevo usuario
		
		Usuario u= em.find(Usuario.class, 20);//devuelde el obj usuario según la PK(primary key)
		
		if(u== null) {
				System.out.println("Codigo no existe");
				
		}else{
			em.getTransaction().begin();	
			em.remove(u);
			em.getTransaction().commit();	
			System.out.println("Eliminado Ok" );	
		}
		em.close();
	}
}


