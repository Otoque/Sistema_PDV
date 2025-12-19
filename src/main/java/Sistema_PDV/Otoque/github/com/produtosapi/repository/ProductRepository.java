package Sistema_PDV.Otoque.github.com.produtosapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Sistema_PDV.Otoque.github.com.produtosapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

    List<Product> findByName(String name);
}
