package com.exercicio.aula.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Order {
    private Integer code;
    private Double basic;
    private Double discont;

    public Order() {
    }

    public Order(Integer code, Double basic, Double discont) {
        this.code = code;
        this.basic = basic;
        this.discont = discont;
    }

    

}
