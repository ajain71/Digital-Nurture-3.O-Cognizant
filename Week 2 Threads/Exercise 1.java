public class ThreadStateLogger {

    static class SimpleThread extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println(i);
                    Thread.sleep(1000); // Simulate some work
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SimpleThread thread = new SimpleThread();

        System.out.println("State before starting: " + thread.getState()); // NEW

        thread.start();
        System.out.println("State after starting: " + thread.getState()); // RUNNABLE

        try {
            while (thread.isAlive()) {
                System.out.println("State during execution: " + thread.getState()); // RUNNABLE or TIMED_WAITING
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State after completion: " + thread.getState()); // TERMINATED
    }
}
