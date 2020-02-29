import java.util.concurrent.TimeUnit;

/**
 * @author JohnYehyo
 * @date 2020-2-29
 */
public class VolatileSyncTest {

    private boolean loop = true;

    public static void main(String... args) {
        VolatileSyncTest app = new VolatileSyncTest();
        new Thread(app.new LoopTask()).start();
        new Thread(app.new LoopController()).start();
    }

//    private class LoopTask implements Runnable {
//        @Override
//        public void run() {
//            // 在-server模式下进入死循环
//            while (loop) {
//                synchronized (this){};
//            }
//            System.out.println("stop...");
//        }
//    }

    private class LoopTask implements Runnable {
        @Override
        public void run() {
            while (loop) {
                synchronized (this){};
            }
            System.out.println("stop...");
        }
    }

    private class LoopController implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000L);
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            loop = false;
        }
    }
}
