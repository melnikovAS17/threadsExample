package com.example;

public class ATM {
    private int moneyInBank;
    public ATM(int moneyInBank){
        this.moneyInBank = moneyInBank;
    }

    public synchronized void getMoney(String name, int amountOfMoney){

        System.out.println(name + " подошёл к банкомату");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            
        }
        if(amountOfMoney <= moneyInBank){
            System.out.println(name + " вывел сумму " + amountOfMoney);
            moneyInBank -= amountOfMoney;
            System.out.println(name + "в банкомате осталось: " + moneyInBank);
        }else{
            System.out.println("в банкомате недостаточно средств для " + name);
        }
    }
}