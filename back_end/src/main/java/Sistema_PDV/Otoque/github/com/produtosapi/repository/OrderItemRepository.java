package Sistema_PDV.Otoque.github.com.produtosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.OrderItem;

public interface OrderItemRepository  extends JpaRepository<OrderItem, Long>{
  
}
