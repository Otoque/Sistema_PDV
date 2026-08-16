package Sistema_PDV.Otoque.github.com.produtosapi.dto;

import java.time.LocalDateTime;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Client;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Employee;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Order;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.OrderStatus;

public record OrderResponseDTO(
    Employee employee,
    Client client,
    LocalDateTime dataCreated,
    OrderStatus status,
    Double totalValue
    
) {
    public OrderResponseDTO(Order order){
        this(
            order.getEmployee(),
            order.getClient(),
            order.getDateCreated(),
            order.getStatus(),
            order.getTotalValue()
        );
    }
}
