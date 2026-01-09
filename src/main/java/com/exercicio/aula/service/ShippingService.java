package com.exercicio.aula.service;

import org.springframework.stereotype.Service;

import com.exercicio.aula.model.Order;

@Service
public class ShippingService extends OrderService {

    public double shipment(Order order) {

        double valorComDesconto = discount(order.getBasic(), order.getDiscont());

        if (valorComDesconto < 100.0) {
            return 20.0;
        }
        else if (valorComDesconto >= 100.0 && valorComDesconto < 200.0) {
            return 12.0;
        }
        else {
            return 0.0;
        }
    }
}
