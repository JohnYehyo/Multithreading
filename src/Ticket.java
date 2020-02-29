import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JohnYehyo
 * @date 2020-2-29
 */
public class Ticket {

    private static int num = 30;
    private static int num2 = 30;

    private static Lock lock = new ReentrantLock();
    private static Lock lock1 = new ReentrantLock();

    /**
     * 售票
     */
    public static void sale() {

        lock.lock();
        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "售出第" + (num--) + "张还剩" + num + "张");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    /**
     * 售票
     */
    public static void sale2() {

        lock1.lock();
        try {
            if (num2> 0) {
                System.out.println(Thread.currentThread().getName() + "售出第" + (num2--) + "张还剩" + num2 + "张******");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock1.unlock();
        }
    }
}
