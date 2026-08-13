package Sistema_PDV.Otoque.github.com.produtosapi.dto;

import Sistema_PDV.Otoque.github.com.produtosapi.entity.Employee;

public record EmployeeResponseDTO(
    Long id,
    String name,
    String cpf,
    String position,
    Integer registration
) {
    public EmployeeResponseDTO(Employee employee){
        this(
            employee.getId(),
            employee.getName(),
            employee.getCpf(),
            employee.getPosition(),
            employee.getRegistration()
        );
    }
}
