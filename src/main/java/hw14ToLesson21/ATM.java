package hw14ToLesson21;

public class ATM {
    private final Object monitor;
    private int sum;

    public ATM(int sum) {
        this.sum = sum;
        this.monitor = new Object();
    }

    public void getMoney(int amountMoneyTakenOff) {
        synchronized (monitor) {
            if (this.sum >= amountMoneyTakenOff) {
                this.sum -= amountMoneyTakenOff;
                System.out.printf("%s - снятие - %d%n", Thread.currentThread().getName(), amountMoneyTakenOff);
            } else
                System.out.printf("В банкомате недостаточно денег для снятия  %s%n", Thread.currentThread().getName());
        }
    }

    public void putMoney(int amountMoneyReceived) {
        synchronized (monitor) {
            this.sum += amountMoneyReceived;
            System.out.printf("%s - пополнение - %d%n", Thread.currentThread().getName(), amountMoneyReceived);
        }
    }
}
