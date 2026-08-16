package Sistema_PDV.Otoque.github.com.produtosapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Sistema_PDV.Otoque.github.com.produtosapi.repository.ProductRepository;
import Sistema_PDV.Otoque.github.com.produtosapi.dto.ProductResponseDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.dto.ProductRequestDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Product;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Transactional
    public ProductResponseDTO save(ProductRequestDTO product){
        Product entity = new Product();
        updateProductFromDto(entity, product);

        Product savedProduct = productRepository.save(entity);
        return new ProductResponseDTO(savedProduct);
    }
    
    @Transactional(readOnly = true)
    public Optional<ProductResponseDTO> getById(Long id){
        return productRepository.findById(id)
            .map(ProductResponseDTO::new);
    }

    @Transactional
    public boolean delete(Long id){
        if(!productRepository.existsById(id)){
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

    @Transactional
    public Optional<ProductResponseDTO> update(Long id, ProductRequestDTO product){
        return productRepository.findById(id)
            .map(existingProduct -> {
                updateProductFromDto(existingProduct, product);
                Product updatedProduct = productRepository.save(existingProduct);
                return new ProductResponseDTO(updatedProduct);
            });
    }

    @Transactional(readOnly = true)
    public List<ProductResponseDTO> search(String name){
        List<Product> products;
        if (name != null && !name.isBlank()) {
            products = productRepository.findByNameContainingIgnoreCase(name);
        }
        else {
            products = productRepository.findAll();
        }

        return products.stream()
            .map(ProductResponseDTO::new)
            .toList();
    }

    private void updateProductFromDto(Product product, ProductRequestDTO dto){
        product.setName(dto.name());
        product.setPrice(dto.price());
        product.setBarcode(dto.barcode());
    }

}
