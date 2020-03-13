import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author JohnYehyo
 * @date 2020-2-29
 */
public class Text8 {


    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws ExecutionException, InterruptedException {


//        Future<String> future = executorService.submit(() -> {
//            System.out.println("嘿嘿");
//            return "123";
//        });
        //比起上面的方法 如果执行的Callable比较常用建议封装起来
        Future<String> future = executorService.submit(new Action4());
        System.out.println(future.get());

        Action4 action4 = new Action4();

        List<Action4> list = new ArrayList<>();
        list.add(new Action4());
        list.add(new Action4());
        list.add(new Action4());
        list.add(new Action4());
        list.add(new Action4());

        List<Future<String>> futures = executorService.invokeAll(list, 5, TimeUnit.SECONDS);
        for (Future<String> f : futures) {
            System.out.println(f.get());
        }

        FutureTask<String> futureTask = new FutureTask(action4);
        new Thread(futureTask).start();
        try {
            String d = futureTask.get(5, TimeUnit.SECONDS);
            System.out.println(d);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
