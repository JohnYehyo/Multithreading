import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author JohnYehyo
 * @date 2020-2-29
 */
public class Action4 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("嘿嘿嘿");
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date());
    }
}
