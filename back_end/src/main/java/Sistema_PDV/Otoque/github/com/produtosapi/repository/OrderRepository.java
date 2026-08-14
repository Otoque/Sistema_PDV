package Sistema_PDV.Otoque.github.com.produtosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
