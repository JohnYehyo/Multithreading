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


        Future<String> future = executorService.submit(() -> {
            System.out.println("嘿嘿");
            return "123";
        });
        System.out.println(future.get());

        Action4 action4 = new Action4();

        List<Action4> list = new ArrayList<>();
        list.add(new Action4());
        list.add(new Action4());
        list.add(new Action4());
        list.add(new Action4());
        list.add(new Action4());

        List<Future<Double>> futures = executorService.invokeAll(list, 5, TimeUnit.SECONDS);
        for (Future<Double> f: futures){
            System.out.println(f.get());
        }

        FutureTask<Double> futureTask = new FutureTask(action4);
        new Thread(futureTask).start();
        try {
            Double d= futureTask.get(5, TimeUnit.SECONDS);
            System.out.println(d);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
