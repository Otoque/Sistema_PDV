package Sistema_PDV.Otoque.github.com.produtosapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

record ProductRequestDTO(
    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 50, message = "O nome deve ter no maximo 50 caracteres.")
    String name,

    @NotNull(message = "O preço é obrigatório.")
    Double price,

    @NotBlank(message = "É obrigatório o codigo de barras")
    @Size(min = 13, max = 13, message = "O codigo de barras deve ter 13 caracteres.")
    String barcode
    
) {}
