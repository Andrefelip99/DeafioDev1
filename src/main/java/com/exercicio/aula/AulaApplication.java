package com.exercicio.aula;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exercicio.aula.model.Order;
import com.exercicio.aula.service.OrderService;
import com.exercicio.aula.service.ShippingService;

@SpringBootApplication
public class AulaApplication implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShippingService shippingService;

    public static void main(String[] args) {
        SpringApplication.run(AulaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o código do pedido: ");
        int code = sc.nextInt();

        System.out.print("Digite o valor básico do produto: ");
        double basic = sc.nextDouble();

        System.out.print("Digite o percentual de desconto (%): ");
        double discount = sc.nextDouble();

        Order order = new Order(code, basic, discount);

        double valorComDesconto = orderService.discount(order.getBasic(), order.getDiscont());
        double frete = shippingService.shipment(order);
        double total = valorComDesconto + frete;

     
        System.out.println("Código: " + order.getCode());
        System.out.println("Valor básico: " + basic);
        System.out.println("Desconto: " + discount + "%");
        System.out.println("Valor com desconto: " + valorComDesconto);
        System.out.println("Frete: " + frete);
        System.out.println("TOTAL: " + total);

        sc.close();
    }
}
