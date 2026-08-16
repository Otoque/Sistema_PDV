package Sistema_PDV.Otoque.github.com.produtosapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderItemRequestDTO(

    @NotNull(message = "O ID do produto é Obrigatório.")
    Long productId,

    @NotNull(message = "A quantidade é Obrigatória.")
    @Positive(message = "A quantidade deve ser maior que zero.")
    Integer quantity

) {}
