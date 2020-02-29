/**
 * @author JohnYehyo
 * @date 2019-11-9
 */
public class Text1 {

    int flag = 0;

    private Object lock = new Object();

    public Text1() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (lock){
            if(0!=flag){
                lock.wait();
            }
            printFirst.run();
            flag = 1;
            lock.notifyAll();
        }



    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock){
            if(1!=flag){
                lock.wait();
            }
            printSecond.run();
            flag = 2;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock){
            if(2!=flag){
                lock.wait();
            }

            printThird.run();
            flag = 0;
            lock.notifyAll();
        }
    }
}
