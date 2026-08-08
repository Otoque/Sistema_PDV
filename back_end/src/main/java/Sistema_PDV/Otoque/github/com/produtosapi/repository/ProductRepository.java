package Sistema_PDV.Otoque.github.com.produtosapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findByNameContainingIgnoreCase(String name);
    
}
