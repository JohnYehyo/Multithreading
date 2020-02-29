import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JohnYehyo
 * @date 2020-2-29
 */
public class Action2 {

    private int num = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increase() throws InterruptedException {

        lock.lock();

        try {
            //未防止虚假唤醒,涉及多线程横向通知回访调用的判断只能用while
            while (num > 0) {
                condition.await();
            }
            num++;
            System.out.println("增加后:" + num);

            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void reduce() throws InterruptedException {

        lock.lock();
        try {
            //未防止虚假唤醒,涉及多线程横向通知回访调用的判断只能用while
            while (num == 0) {
                condition.await();
            }
            num--;
            System.out.println("减少后:" + num);

            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
