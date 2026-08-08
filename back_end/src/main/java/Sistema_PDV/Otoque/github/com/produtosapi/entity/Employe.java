package Sistema_PDV.Otoque.github.com.produtosapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employes")
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(unique = true, length = 14)
    private String cpf;

    @Column(length = 50)
    private String position;

    @Column(unique = true)
    private Integer registration;
        
    public Employe(){}

    public Employe(String name, String cpf, String position, Integer registration){
        this.name = name;
        this.cpf = cpf;
        this.position = position;
        this.registration = registration;
    }
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
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

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getRegistration() {
        return registration;
    }

    public void setRegistration(Integer registration) {
        this.registration = registration;
    }
    
    @Override
    public String toString(){
        return String.format("Employe [name: %s, cpf: %s, position: %s, registration: %s]", name, cpf, position, registration);
    }
}
