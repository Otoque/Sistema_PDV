package Sistema_PDV.Otoque.github.com.produtosapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employes")
public class Employe {

    @Id
    private Integer registration;
    private String position;
    private String name;
    private String cpf;
        

    public Integer getRegistration() {
        return registration;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setRegistration(Integer registration) {
        this.registration = registration;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    
}
