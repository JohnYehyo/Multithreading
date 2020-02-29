public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        new Text1();
                    }
                }
        ).start();
    }
}
