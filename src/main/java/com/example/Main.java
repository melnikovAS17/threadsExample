package com.example;


public class Main {
    public static final Object monitor = new Object();
    private static final String A = "A";
    private static final String B = "B";
    private static final String C = "C";
    public static String nextLetter = A ;
        public static void main(String[] args) {

        new Thread(new Runnable(){
            @Override
            public void run() {
                //Монитор - созданный выше объект (Object)
                //делается для предотвращения race condition 
                // без указания монитора онитором будет наш класс this.Main (пример)
                synchronized(monitor){
                    for(int i = 0; i < 3; i++){
                        try {
                            if(!nextLetter.equals(A)){
                                monitor.wait();
                            }
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.print(A);
                        nextLetter = B;
                        monitor.notifyAll();
                    }
            }
            }
        }).start();
        new Thread(new Runnable(){

            @Override
            public void run() {
                synchronized(monitor){
                    for(int i = 0; i < 3; i++){
                        try {
                            if(!nextLetter.equals(B)){
                                monitor.wait();
                            }
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.print(B);
                        nextLetter = C;
                        monitor.notifyAll();
                    }
            }
            }

        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized(monitor){
                    for(int i = 0; i < 3; i++){
                        try {
                            if(!nextLetter.equals(C)){
                                monitor.wait();
                            }
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.print(C);
                        nextLetter = A;
                        monitor.notifyAll();
                    }
                }
            }
        }).start();        
                   
    }
}
    
