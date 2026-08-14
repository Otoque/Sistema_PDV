package Sistema_PDV.Otoque.github.com.produtosapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Sistema_PDV.Otoque.github.com.produtosapi.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE REPLACE(REPLACE(c.cpf, '.', ''), '-', '') = :cpfApenasNumeros")
    List<Client> findByCpfLimpo(@Param("cpfApenasNumeros") String cpfApenasNumeros);

}
