import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JohnYehyo
 * @date 2020-2-29
 */
public class Text3 {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        /**
         * 两个售票窗口各分配30张票35个人同时购买这30张票
         */
        for (int i = 0; i < 35; i++) {
            executorService.execute(() -> {

                for (int j = 0; j < 30; j++) {
                    Ticket.sale();
                    Ticket.sale2();
                }
            });
        }
    }

}
