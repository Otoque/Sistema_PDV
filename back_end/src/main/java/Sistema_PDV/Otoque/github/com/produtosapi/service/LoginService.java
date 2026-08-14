package Sistema_PDV.Otoque.github.com.produtosapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sistema_PDV.Otoque.github.com.produtosapi.dto.LoginRequestDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.dto.LoginResponseDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Employee;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.EmployeeRepository;

@Service
public class LoginService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<LoginResponseDTO> checkAcess(LoginRequestDTO requestDTO){
        if(requestDTO == null || requestDTO.matricula() == null || requestDTO.matricula().isBlank()){
            return Optional.empty();
        }

        try {
            Integer matriculaInt = Integer.parseInt(requestDTO.matricula());
            List<Employee> listEmployees = employeeRepository.findByRegistration(matriculaInt);

            return listEmployees.stream()
                .findFirst()
                .map(emp -> new LoginResponseDTO(true, emp.getName()));
        } catch (NumberFormatException e){
            return Optional.empty();
        }
    }
}
