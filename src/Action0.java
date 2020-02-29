/**
 * @author JohnYehyo
 * @date 2020-2-29
 */
public class Action0 {

    private int num = 0;

    public void increase() {

        while (num == 0) {
            num++;
            System.out.println("增加后:" + num);
        }

    }

    public  void reduce() {

        while (num > 0) {
            num--;
            System.out.println("减少后:" + num);
        }

    }
}
