package Sistema_PDV.Otoque.github.com.produtosapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    private Integer cpf;
    private String name;
    

}
