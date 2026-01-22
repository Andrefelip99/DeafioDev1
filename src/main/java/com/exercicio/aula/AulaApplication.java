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
        int code = Integer.parseInt(sc.nextLine());

        System.out.print("Digite o valor básico do produto: ");
        double basic = Double.parseDouble(sc.nextLine().replace(",", "."));

        System.out.print("Digite o percentual de desconto (%): ");
        double discount = Double.parseDouble(sc.nextLine().replace(",", "."));

        Order order = new Order(code, basic, discount);
        double valorComDesconto = orderService.discount(order);
        double frete = shippingService.shipment(order);
        double total = valorComDesconto + frete;

        System.out.println("\n--- RESUMO DO PEDIDO ---");
        System.out.println("Código do pedido: " + order.getCode());
        System.out.printf("Valor básico: R$ %.2f%n", order.getBasic());
        System.out.printf("Desconto: %.2f%%%n", order.getDiscount());
        System.out.printf("Valor com desconto: R$ %.2f%n", valorComDesconto);
        System.out.printf("Frete: R$ %.2f%n", frete);
        System.out.printf("TOTAL: R$ %.2f%n", total);

        sc.close();
    }
}
