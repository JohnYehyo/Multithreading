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
         * 5个人同时售票这30张票
         */
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {

                for (int j = 0; j < 30; j++) {
                    Ticket.sale();
                    Ticket.sale2();
                }
            });
        }
    }

}
