package Sistema_PDV.Otoque.github.com.produtosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    List<Employee> findByRegistration(Integer registration);

}
