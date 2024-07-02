

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.batch2.onlineshopping.entity.Products;

public interface ProductsRepository extends JpaRepository<Products,Integer>
 {
	public List<Products> getProductsByCategory(String category);
	
	public Products getProductsById(int id);

}
