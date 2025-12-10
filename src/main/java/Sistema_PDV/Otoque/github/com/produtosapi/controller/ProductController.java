package Sistema_PDV.Otoque.github.com.produtosapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Sistema_PDV.Otoque.github.com.produtosapi.model.Product;


@RestController
@RequestMapping("products")
public class ProductController {
    
    @PostMapping
    public void save(Product product){
        System.out.println("Product received" + product);
    }
}
