public class TaskScheduler {

    static class Task extends Thread {
        private String taskName;

        public Task(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            try {
                System.out.println(taskName + " is starting.");
                
                // Simulate some work
                for (int i = 1; i <= 3; i++) {
                    System.out.println(taskName + " is working... (" + i + ")");
                    Thread.sleep(1000);
                    
                    if (i == 2) {
                        System.out.println(taskName + " is yielding.");
                        Thread.yield();
                    }
                }

                System.out.println(taskName + " has finished.");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");

        task1.start();
        task2.start();

        try {
            task1.join();
            task2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks have completed.");
    }
}
