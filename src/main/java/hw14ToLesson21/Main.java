package hw14ToLesson21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int RANDOM_BOUND = 10;
    private static final int OPERATION_AMOUNT = 5;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(3);
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        ATM atm = new ATM(100_000, 10_000, 100_000);

        for (int i = 0; i < OPERATION_AMOUNT; i++) {
            executorService.execute(() -> {
                int rand = RANDOM.nextInt(RANDOM_BOUND);
                if (rand % 2 == 0)
                    atm.getMoney();
                else
                    atm.putMoney();
            });
        }

    }

}
