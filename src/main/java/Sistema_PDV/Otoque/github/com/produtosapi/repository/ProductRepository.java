package Sistema_PDV.Otoque.github.com.produtosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Sistema_PDV.Otoque.github.com.produtosapi.model.Product;

public interface ProductRepository extends  JpaRepository<Product, String>{
    
}
