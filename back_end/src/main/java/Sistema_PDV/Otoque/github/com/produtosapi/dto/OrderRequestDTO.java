package Sistema_PDV.Otoque.github.com.produtosapi.dto;

import java.util.List;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.OrderStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record OrderRequestDTO(
    
    @NotNull(message = "O ID do funcionário é obrigatório.")
    Long employee_id,
    Long client_id,
    OrderStatus status,

    @NotEmpty(message = "O pedido deve ter pelo menos um item.")
    @Valid
    List<OrderItemRequestDTO> items

) {}
