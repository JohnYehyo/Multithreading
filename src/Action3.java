import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JohnYehyo
 * @date 2020-2-29
 */
public class Action3 {

    private int flag = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void A() throws InterruptedException {

        lock.lock();

        try {
            while(1!=flag){
                condition1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("AA");
            }
            flag = 2;
            condition2.signal();
        } finally {
            lock.unlock();
        }

    }

    public void B() throws InterruptedException {

        lock.lock();

        try {
            while(2!=flag){
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("BB");
            }
            flag = 3;
            condition3.signal();
        } finally {
            lock.unlock();
        }

    }

    public void C() throws InterruptedException {

        lock.lock();

        try {
            while(3!=flag){
                condition3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println("CC");
            }
            flag = 1;
            condition1.signal();
        } finally {
            lock.unlock();
        }

    }
}
