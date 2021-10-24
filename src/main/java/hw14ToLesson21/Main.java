package hw14ToLesson21;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(10000);


        new Thread(() -> atm.getMoney(4000)).start();
        new Thread(() -> atm.putMoney(1000)).start();
        new Thread(() -> atm.getMoney(10000)).start();
    }

}
