package Sistema_PDV.Otoque.github.com.produtosapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Sistema_PDV.Otoque.github.com.produtosapi.dto.ClientDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.model.Client;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.ClientRepository;

@RestController
@RequestMapping("client")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    public ResponseEntity<ClientDTO> save(@RequestBody Client client){
        System.out.printf("Client Saved %s%n", client);
        Client savedClient = clientRepository.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ClientDTO(savedClient));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClientDTO> searchByCpf(@PathVariable String cpf){
        return clientRepository.findById(cpf)
        .map(client -> ResponseEntity.ok(new ClientDTO(client)))
        .orElse(ResponseEntity.notFound().build());
    }

}
