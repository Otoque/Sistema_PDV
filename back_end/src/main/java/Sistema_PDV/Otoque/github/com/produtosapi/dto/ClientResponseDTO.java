package Sistema_PDV.Otoque.github.com.produtosapi.dto;

import Sistema_PDV.Otoque.github.com.produtosapi.entity.Client;

public record ClientResponseDTO(
    Long id,
    String name,
    String cpf,
    String phone,
    String email
) {
    // Método estático para converter a Entidade Client no DTO de resposta
    public static ClientResponseDTO fromEntity(Client client) {
        return new ClientResponseDTO(
            client.getId(),
            client.getName(),
            client.getCpf(),
            client.getPhone(),
            client.getEmail()
        );
    }
}
