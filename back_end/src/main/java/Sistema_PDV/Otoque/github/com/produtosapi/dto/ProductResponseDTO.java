package Sistema_PDV.Otoque.github.com.produtosapi.dto;

import Sistema_PDV.Otoque.github.com.produtosapi.entity.Product;

public record ProductResponseDTO (
    Long id,
    String name,
    Double price,
    String barcode
) {
    public ProductResponseDTO(Product product) {
        this(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getBarcode()
        );
    }
}
