package Sistema_PDV.Otoque.github.com.produtosapi.dto;

import Sistema_PDV.Otoque.github.com.produtosapi.entity.OrderStatus;
import jakarta.validation.constraints.NotNull;

public record OrderRequestDTO(
    
    @NotNull(message = "O ID do funcionário é obrigatório.")
    Long employee_id,
    Long client_id,
    OrderStatus status

) {}
