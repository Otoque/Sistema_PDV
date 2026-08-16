package Sistema_PDV.Otoque.github.com.produtosapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Sistema_PDV.Otoque.github.com.produtosapi.dto.ClientResponseDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.dto.ClientRequestDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.ClientRepository;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Client;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
   
    @Transactional
    public ClientResponseDTO save (ClientRequestDTO client){
        
        Client entity = new Client();
        entity.setName(client.name());
        entity.setCpf(client.cpf());
        entity.setPhone(client.phone());
        entity.setEmail(client.email());

        Client savedClient = clientRepository.save(entity);
        return new ClientResponseDTO(savedClient);
    }

    public Optional<ClientResponseDTO> searchByCpf(String cpf){
        List<Client> clients = clientRepository.findByCpfLimpo(cpf);
        return clients.stream()
            .findFirst()
            .map(ClientResponseDTO::new);
    }
}
