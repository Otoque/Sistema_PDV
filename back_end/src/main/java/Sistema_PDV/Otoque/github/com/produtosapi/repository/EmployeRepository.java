package Sistema_PDV.Otoque.github.com.produtosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Employe;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
    
    List<Employe> findByRegistration(Integer registration);

}
