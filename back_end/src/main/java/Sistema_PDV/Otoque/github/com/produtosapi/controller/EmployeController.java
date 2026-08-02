package Sistema_PDV.Otoque.github.com.produtosapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Sistema_PDV.Otoque.github.com.produtosapi.model.Employe;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.EmployeRepository;

@RestController
@RequestMapping("employe")
public class EmployeController {

    private EmployeRepository employeRepository;

    public EmployeController(EmployeRepository employeRepository){
        this.employeRepository = employeRepository; 
    }
    
    @PostMapping
    public Employe save(@RequestBody Employe employe){
        System.out.println("Employe received " + employe);
        employeRepository.save(employe);
        return employe;
    }
}
