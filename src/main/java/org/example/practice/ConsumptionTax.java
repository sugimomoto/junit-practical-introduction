package org.example.practice;

public class ConsumptionTax {

    private final int taxRate;

    public ConsumptionTax(int taxRate) {
        this.taxRate = taxRate;
    }

    public int apply(int price){
        return price + (price * this.taxRate / 100);
    }
}
