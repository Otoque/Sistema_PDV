package Sistema_PDV.Otoque.github.com.produtosapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Sistema_PDV.Otoque.github.com.produtosapi.dto.ClientRequestDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.dto.ClientResponseDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.service.ClientService;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientResponseDTO> save(@Valid @RequestBody ClientRequestDTO clientRequest) {
        ClientResponseDTO dto = clientService.save(clientRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClientResponseDTO> searchByCpf(@PathVariable String cpf) {
        return clientService.searchByCpf(cpf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
