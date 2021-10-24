package hw14ToLesson21;

import java.util.Scanner;

public class ATM {
    private static final int MIN_MONEY = 1;
    private final int maximumTopUpAmount;
    private final int maximumWithdrawalAmount;
    private final Object monitor;
    private int sum;

    public ATM(int sum, int maximumTopUpAmount, int maximumWithdrawalAmount) {
        this.sum = sum;
        this.maximumTopUpAmount = maximumTopUpAmount;
        this.maximumWithdrawalAmount = maximumWithdrawalAmount;
        this.monitor = new Object();
    }

    public void getMoney() {
        int amountMoneyTakenOff = randomAmountOfMoney(maximumWithdrawalAmount);
        synchronized (monitor) {
            if (this.sum >= amountMoneyTakenOff) {
                this.sum -= amountMoneyTakenOff;
                System.out.printf("%s - снятие - %d%n", Thread.currentThread().getName(), amountMoneyTakenOff);
            } else {
                Scanner scanner = new Scanner(System.in);
                do {
                    System.out.printf("В банкомате недостаточно денег для снятия  %s%n ", Thread.currentThread().getName());
                    System.out.printf("Введите сумму меньшую чем %d: ", amountMoneyTakenOff);
                    amountMoneyTakenOff = scanner.nextInt();
                } while (this.sum < amountMoneyTakenOff);
            }
        }
    }

    public void putMoney() {
        int amountMoneyReceived = randomAmountOfMoney(maximumTopUpAmount);
        synchronized (monitor) {
            this.sum += amountMoneyReceived;
            System.out.printf("%s - пополнение - %d%n", Thread.currentThread().getName(), amountMoneyReceived);
        }
    }

    private int randomAmountOfMoney(int topBorder){
        return (int)(Math.random() * (topBorder - MIN_MONEY) + MIN_MONEY);
    }
}
