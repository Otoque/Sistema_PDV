package Sistema_PDV.Otoque.github.com.produtosapi.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Sistema_PDV.Otoque.github.com.produtosapi.model.Client;

public interface ClientRepository extends JpaRepository<Client,String> {

    @Query(value = "SELECT * FROM client WHERE REGEXP_REPLACE(cpf, '\\D', '', 'g') = :cpfApenasNumeros", nativeQuery = true)
    List<Client> findByCpfLimpo(@Param("cpfApenasNumeros") String cpfApenasNumeros);
    
}
