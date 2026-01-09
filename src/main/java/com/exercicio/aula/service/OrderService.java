package com.exercicio.aula.service;

import org.springframework.stereotype.Service;

import com.exercicio.aula.model.Order;

@Service
public class OrderService {


    public double discount(double basic, double percentual) {
    return basic - (basic * percentual / 100);
}


    public double total(Order order) {
        return order.getBasic() - order.getDiscont();
    }

}
