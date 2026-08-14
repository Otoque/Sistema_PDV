package Sistema_PDV.Otoque.github.com.produtosapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sistema_PDV.Otoque.github.com.produtosapi.dto.ClientResponseDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.ClientRepository;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Client;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public ClientResponseDTO save (Client client){
        System.out.printf("Client saved %s%n",client);
        Client savedClient = clientRepository.save(client);
        return new ClientResponseDTO(savedClient);
    }

    public Optional<ClientResponseDTO> searchByCpf(String cpf){
        List<Client> clients = clientRepository.findByCpfLimpo(cpf);
        return clients.stream()
            .findFirst()
            .map(ClientResponseDTO::new);
    }
}
