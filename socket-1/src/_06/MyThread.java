package _06;

public class MyThread extends Thread {
    public void run() {
        // スレッドが実行する処理を記述
        System.out.println("MyThread is running");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 新しいスレッドを作成して開始
        MyThread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}