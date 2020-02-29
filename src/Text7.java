import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JohnYehyo
 * @date 2020-2-29
 */
public class Text7 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        //A方法打印A B方法打印B C方法打印C
        //先打印AA5次 再打印BB10次 再打印CC15次
        //三个线程执行10轮
        Action3 action3 = new Action3();

        executorService.execute(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    action3.A();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    action3.B();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    action3.C();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
