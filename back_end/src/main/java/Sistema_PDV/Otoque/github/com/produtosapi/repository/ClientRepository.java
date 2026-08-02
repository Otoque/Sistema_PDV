package Sistema_PDV.Otoque.github.com.produtosapi.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import Sistema_PDV.Otoque.github.com.produtosapi.model.Client;

public interface ClientRepository extends JpaRepository<Client,String> {

    List<Client> findByCpf(String cpf);
    
}
