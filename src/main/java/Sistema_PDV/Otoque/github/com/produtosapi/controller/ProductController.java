package Sistema_PDV.Otoque.github.com.produtosapi.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Sistema_PDV.Otoque.github.com.produtosapi.model.Product;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.ProductRepository;


@RestController
@RequestMapping("products")
public class ProductController {
    
    private ProductRepository productRepository;
    
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @PostMapping
    public Product save(@RequestBody Product product){
        System.out.println("Product received" + product);
        var id = UUID.randomUUID().toString();
        product.setId(id);
        productRepository.save(product);
        return product;
    }
}
