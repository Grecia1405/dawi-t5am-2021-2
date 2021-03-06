package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;


public class ProdDemo01 {
	public static void main(String[] args){
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		Producto p = new Producto();
		p.setIdprod("P0050");
		p.setDescripcion("Prueba");
		p.setStock(10);
		p.setIdcategoria(1);
		p.setPrecio(0.99);
		
		// transacciones
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("REGISTRO OK");
		em.close();
		
	}

}
