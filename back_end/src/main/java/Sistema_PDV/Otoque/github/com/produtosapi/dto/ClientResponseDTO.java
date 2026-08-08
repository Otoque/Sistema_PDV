package Sistema_PDV.Otoque.github.com.produtosapi.dto;

import Sistema_PDV.Otoque.github.com.produtosapi.entity.Client;

public record ClientResponseDTO(
    Long id,
    String name,
    String cpf,
    String phone,
    String email
) {
    public ClientResponseDTO(Client client) {
        this(
            client.getId(),
            client.getName(),
            client.getCpf(),
            client.getPhone(),
            client.getEmail()
        );
    }
}
