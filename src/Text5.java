import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JohnYehyo
 * @date 2020-2-29
 */
public class Text5 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        //实现买卖商品有就卖没有就生产 0 -> 1 -> 0
        Action2 action2 = new Action2();

        executorService.execute(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    action2.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    action2.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    action2.reduce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    action2.reduce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
