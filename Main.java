public class Main {
    public static void main(String[] args) {
        // Создаем и запускаем 10 потоков
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new MyRunnable(i)); // Создаем новый поток с экземпляром MyRunnable
            threads[i].start(); // Запускаем поток
        }

        // Ожидаем завершения всех потоков
        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join(); // Ожидаем завершения потока
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Все потоки завершены.");
    }
}

class MyRunnable implements Runnable {
    private int threadNumber;

    public MyRunnable(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        System.out.println("Поток " + threadNumber + " стартовал.");
        try {
            Thread.sleep(1000); // Поток выполняет какую-то работу (здесь просто ожидание)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Поток " + threadNumber + " завершился.");
    }
}
