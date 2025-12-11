package Sistema_PDV.Otoque.github.com.produtosapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product{

    @Id
    private String id;
    private String name;
    private Double price;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product (" +
        "id= '" + id + "\"" +
        ", name= '" + name + "\"" +
        ", price= '" + price;
    }


}