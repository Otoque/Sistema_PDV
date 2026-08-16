package Sistema_PDV.Otoque.github.com.produtosapi.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Sistema_PDV.Otoque.github.com.produtosapi.entity.Employee;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Client;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Order;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.OrderItem;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Product;
import Sistema_PDV.Otoque.github.com.produtosapi.exception.ResourceNotFoundException;
import Sistema_PDV.Otoque.github.com.produtosapi.dto.OrderResponseDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.dto.OrderItemRequestDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.dto.OrderRequestDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.ClientRepository;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.EmployeeRepository;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.OrderRepository;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.ProductRepository;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.OrderItemRepository;


@Service
public class OrderService{
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;
    
    @Transactional
    public OrderResponseDTO createOrder(OrderRequestDTO dto){

        Employee employee = employeeRepository.findById(dto.employee_id())
            .orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado com o ID: " + dto.employee_id()));

        Client client = null;
        if(dto.client_id() != null){
            client = clientRepository.findById(dto.client_id())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + dto.client_id()));
        }

        Order order = new Order();
        order.setEmployee(employee);
        order.setClient(client);

        if(dto.status() != null){ 
            order.setStatus(dto.status());        
        } 

        double totalValue = 0.0;
        List<OrderItem> items = new ArrayList<>();

        for(OrderItemRequestDTO itemDto : dto.items()){ 
            Product product = productRepository.findById(itemDto.productId())
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado ID: " + itemDto.productId()));

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(product);
            item.setQuantity(itemDto.quantity());
            item.setUnitPrice(product.getPrice());

            totalValue += item.getSubTotal();
            items.add(item);

        }

        order.setTotalValue(totalValue);
        Order savedOrder = orderRepository.save(order);
        orderItemRepository.saveAll(items);
        return new OrderResponseDTO(savedOrder);

    }
}
