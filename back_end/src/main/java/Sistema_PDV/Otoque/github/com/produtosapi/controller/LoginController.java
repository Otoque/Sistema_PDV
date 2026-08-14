package Sistema_PDV.Otoque.github.com.produtosapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Sistema_PDV.Otoque.github.com.produtosapi.dto.LoginRequestDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.dto.LoginResponseDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.service.LoginService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") 
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> checkAcess(@RequestBody LoginRequestDTO payload) {
        return loginService.checkAcess(payload)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
