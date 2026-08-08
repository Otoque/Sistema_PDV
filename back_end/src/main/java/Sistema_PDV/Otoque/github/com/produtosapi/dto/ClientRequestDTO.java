package Sistema_PDV.Otoque.github.com.produtosapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClientRequestDTO(

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    String name,

    @Pattern(regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})$", message = "CPF em formato inválido.")
    String cpf,

    @Size(max = 20, message = "O telefone não pode exceder 20 caracteres.")
    String phone,

    @Email(message = "E-mail inválido.")
    @Size(max = 100, message = "O e-mail não pode exceder 100 caracteres.")
    String email

) {}

