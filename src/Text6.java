import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JohnYehyo
 * @date 2020-2-29
 */
public class Text6 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        //实现买卖商品有就卖没有就生产 0 -> 1 -> 0
        Action0 action0 = new Action0();

        executorService.execute(() -> {
            for (int i = 0; i < 10; i++) {
                action0.increase();
            }
        });

        executorService.execute(() -> {
            for (int i = 0; i < 10; i++) {
                action0.increase();
            }
        });

        executorService.execute(() -> {
            for (int i = 0; i < 10; i++) {
                action0.reduce();
            }
        });

        executorService.execute(() -> {
            for (int i = 0; i < 10; i++) {
                action0.reduce();
            }
        });

    }
}
