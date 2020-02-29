import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JohnYehyo
 * @date 2020-2-29
 */
public class Text4 {


    public static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        //实现买卖商品有就卖没有就生产 0 -> 1 -> 0
        Action action = new Action();

        executor.execute(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    action.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.execute(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    action.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.execute(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    action.reduce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executor.execute(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    action.reduce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
