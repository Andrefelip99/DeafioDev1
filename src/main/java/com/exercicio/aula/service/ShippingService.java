package com.exercicio.aula.service;


import org.springframework.stereotype.Service;

import com.exercicio.aula.model.Order;


@Service
public class ShippingService {

    public double shipment(Order order) {

        if (order.getBasic() < 100.0) {
            return 20.0;
        }
        if (order.getBasic() < 200.0) {
            return 12.0;
        }
        return 0.0;
    }
}

