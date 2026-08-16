package Sistema_PDV.Otoque.github.com.produtosapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Sistema_PDV.Otoque.github.com.produtosapi.dto.OrderRequestDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.dto.OrderResponseDTO;
import Sistema_PDV.Otoque.github.com.produtosapi.service.OrderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderController{

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@Valid @RequestBody OrderRequestDTO payload){
        OrderResponseDTO newOrder = orderService.createOrder(payload);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
    }

}
