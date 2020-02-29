import java.util.*;
import java.util.concurrent.*;

/**
 * @author JohnYehyo
 * @date 2020-2-29
 */
public class Text2 {


    private static final ExecutorService executroService = Executors.newFixedThreadPool(5);


    public static void main(String[] args) {

        List list = new ArrayList();
//        List list = new Vector();
//        List list = Collections.synchronizedList(new ArrayList<>());
//        List list = new CopyOnWriteArrayList();


        for (int i = 0; i < 10; i++) {
            executroService.execute(() -> {
                list.add(UUID.randomUUID().toString().replace("-", ""));
                System.out.println(list);
            });
        }
    }
}
