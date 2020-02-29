import java.util.concurrent.TimeUnit;

/**
 * @author JohnYehyo
 * @date 2020-2-29
 */
public class Action {

    private int num = 0;

    public synchronized void increase() throws InterruptedException {

        //未防止虚假唤醒,涉及多线程横向通知回访调用的判断只能用while
        while (num > 0) {
            this.wait();
        }

        num++;
        System.out.println("增加后:" + num);

        this.notifyAll();
    }

    public synchronized void reduce() throws InterruptedException {

        //未防止虚假唤醒,涉及多线程横向通知互访调用的判断只能用while
        while (num == 0) {
            this.wait();
        }

        num--;
        System.out.println("减少后:" + num);

        this.notifyAll();
    }
}
