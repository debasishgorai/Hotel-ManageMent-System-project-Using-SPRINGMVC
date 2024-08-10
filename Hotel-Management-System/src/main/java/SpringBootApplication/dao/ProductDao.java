package SpringBootApplication.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import SpringBootApplication.entities.*;

@Repository
public class ProductDao {
	@Autowired
	EntityManagerFactory emf;

	@Autowired
	EntityManager em;

	@Autowired
	EntityTransaction et;
	
	public void saveProduct(Product product) {
		et.begin();
		em.persist(product);
		et.commit();
	}
	
	public void updateProduct(Product product) {
		et.begin();
		em.merge(product);
		et.commit();
	}
	
	public void deleteById(int id) {
		et.begin();
		em.remove(em.find(Product.class, id));
		et.commit();
	}
	
	public Product findById(int id) {
		return em.find(Product.class, id);
	}
	
	public List<Product> findAllProducts() {
		Query query = em.createQuery("select p from Product p");
		List<Product> product = query.getResultList();
		return product;
	}


}
