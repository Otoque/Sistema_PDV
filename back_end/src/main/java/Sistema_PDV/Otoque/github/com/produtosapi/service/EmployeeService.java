package Sistema_PDV.Otoque.github.com.produtosapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sistema_PDV.Otoque.github.com.produtosapi.dto.EmployeeResponseDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Employee;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.EmployeeRepository;

@Service
public class EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeResponseDTO save(Employee employee){
        System.out.printf("Employee saved %s%n", employee);
        Employee savedEmployee = employeeRepository.save(employee);
        return new EmployeeResponseDTO(savedEmployee);
    }

}
