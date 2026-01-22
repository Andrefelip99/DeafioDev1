package com.exercicio.aula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.aula.model.Order;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

 
    public double discount(Order order) {
        return order.getBasic() * (1 - order.getDiscount() / 100);
    }
  
    public double total(Order order) {
        double valorComDesconto = discount(order);
        double frete = shippingService.shipment(order);
        return valorComDesconto + frete;
    }
}
