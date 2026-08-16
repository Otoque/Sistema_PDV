package Sistema_PDV.Otoque.github.com.produtosapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Sistema_PDV.Otoque.github.com.produtosapi.dto.EmployeeRequestDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.dto.EmployeeResponseDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Employee;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.EmployeeRepository;

@Service
public class EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public EmployeeResponseDTO save(EmployeeRequestDTO employee){
        
        Employee entity = new Employee();
        entity.setName(employee.name());
        entity.setCpf(employee.cpf());
        entity.setPosition(employee.position());
        entity.setRegistration(employee.registration());

        Employee savedEmployee = employeeRepository.save(entity);

        return new EmployeeResponseDTO(savedEmployee);
    }

}
