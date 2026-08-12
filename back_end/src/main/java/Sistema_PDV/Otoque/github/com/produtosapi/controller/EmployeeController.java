package Sistema_PDV.Otoque.github.com.produtosapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Sistema_PDV.Otoque.github.com.produtosapi.entity.Employee;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.EmployeeRepository;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository; 
    }
    
    @PostMapping
    public Employee save(@RequestBody Employee employee){
        System.out.println("Employe received " + employee);
        employeeRepository.save(employee);
        return employee;
    }
}
