package Sistema_PDV.Otoque.github.com.produtosapi.dto;

import Sistema_PDV.Otoque.github.com.produtosapi.entity.OrderItem;

public record OrderItemResponseDTO(
    Long productId,
    String productName,
    Integer quantity,
    Double unitPrice,
    Double subTotal
) {
    public OrderItemResponseDTO(OrderItem item){
        this(
            item.getProduct().getId(),
            item.getProduct().getName(),
            item.getQuantity(),
            item.getUnitPrice(),
            item.getSubTotal()
        );
    }
}
