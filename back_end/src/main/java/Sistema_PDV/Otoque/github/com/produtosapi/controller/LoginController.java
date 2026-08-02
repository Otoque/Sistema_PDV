package Sistema_PDV.Otoque.github.com.produtosapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Sistema_PDV.Otoque.github.com.produtosapi.model.Employe;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.EmployeRepository;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") 
public class LoginController {

    private EmployeRepository repository;

    public LoginController(EmployeRepository repository){
        this.repository = repository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> verificarAcesso(@RequestBody Map<String, String> payload) {
        try {
            
            String matriculaStr = payload.get("matricula");
            Integer matriculaInt = Integer.parseInt(matriculaStr);

            List<Employe> listaFuncionarios = repository.findByRegistration(matriculaInt);

            if (!listaFuncionarios.isEmpty()) {
                Employe funcionario = listaFuncionarios.get(0); 
                
                Map<String, Object> resposta = new HashMap<>();
                resposta.put("permitido", true);
                resposta.put("funcionario", funcionario.getName()); 
                
                return ResponseEntity.ok(resposta);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Matrícula não encontrada no sistema.");
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("A matrícula deve ser apenas números.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro no servidor.");
        }
    }
}