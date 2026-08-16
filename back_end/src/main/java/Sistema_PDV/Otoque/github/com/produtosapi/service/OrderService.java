package Sistema_PDV.Otoque.github.com.produtosapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Sistema_PDV.Otoque.github.com.produtosapi.entity.Employee;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Client;
import Sistema_PDV.Otoque.github.com.produtosapi.entity.Order;
import Sistema_PDV.Otoque.github.com.produtosapi.dto.OrderResponseDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.dto.OrderRequestDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.ClientRepository;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.EmployeeRepository;
import Sistema_PDV.Otoque.github.com.produtosapi.repository.OrderRepository;


@Service
public class OrderService{
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ClientRepository clientRepository;
    
    @Transactional
    public OrderResponseDTO createOrder(OrderRequestDTO dto){

        Employee employee = employeeRepository.findById(dto.employee_id())
            .orElseThrow(() -> new RuntimeException("Funcionario não encontrado com o ID: " + dto.employee_id()));

        Client client = null;
        if(dto.client_id() != null){
            client = clientRepository.findById(dto.client_id())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + dto.client_id()));
        }

        Order order = new Order();
        order.setEmployee(employee);
        order.setClient(client);

        if(dto.status() != null){
            order.setStatus(dto.status());        
        }

        Order savedOrder = orderRepository.save(order);

        return new OrderResponseDTO(savedOrder);

    }
}
