package Sistema_PDV.Otoque.github.com.produtosapi.dto;
import Sistema_PDV.Otoque.github.com.produtosapi.model.Client;

public class ClientDTO {

    private String cpf;
    private String name;

    public ClientDTO(){
    }

    public ClientDTO(Client client){
        this.name = client.getName();
        this.cpf = client.getCpf();
    }

    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
