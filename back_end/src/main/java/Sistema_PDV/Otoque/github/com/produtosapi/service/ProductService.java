package Sistema_PDV.Otoque.github.com.produtosapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sistema_PDV.Otoque.github.com.produtosapi.repository.ProductRepository;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Product;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    public Product save(Product product){
        System.out.printf("Product saved",product);
        return productRepository.save(product);
    }

    public Optional<Product> getById(Long id){
        return productRepository.findById(id);
    }

    public boolean delete(Long id){
        if(!productRepository.existsById(id)){
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

    public Optional<Product> update(Long id, Product product){
        if(!productRepository.existsById(id)){
            return Optional.empty();
        }
        product.setId(id);
        return Optional.of(productRepository.save(product));
    }

    public List<Product> search(String name){
        if(name != null && !name.isBlank()){
            return productRepository.findByNameContainingIgnoreCase(name);
        }
        return productRepository.findAll();
    }    
}
