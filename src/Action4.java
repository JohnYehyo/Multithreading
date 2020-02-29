import java.util.concurrent.Callable;

/**
 * @author JohnYehyo
 * @date 2020-2-29
 */
public class Action4 implements Callable<Double> {

    @Override
    public Double call() throws Exception {
        System.out.println("嘿嘿嘿");
        return Math.random();
    }
}
