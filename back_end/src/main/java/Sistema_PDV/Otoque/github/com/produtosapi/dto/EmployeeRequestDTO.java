package Sistema_PDV.Otoque.github.com.produtosapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

record EmployeeRequestDTO(
    
    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    String name,

    @NotBlank(message = "O cpf é obrigatório.")
    String cpf,

    @NotBlank(message = "O cargo é obrigatório.")
    String position,
    
    @NotNull(message = "A matricula é obrigatória.")
    @Size(max = 10 , message = "A matricula não pode exceder 10 caracteres.")
    Integer registration
) {}
