import java.util.LinkedList;
import java.util.Queue;

class DataQueue {
    private Queue<Integer> queue = new LinkedList<>();
    private int capacity;

    public DataQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int data) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // Wait if the queue is full
        }
        queue.add(data);
        System.out.println("Produced: " + data);
        notifyAll(); // Notify consumers that new data is available
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait if the queue is empty
        }
        int data = queue.poll();
        System.out.println("Consumed: " + data);
        notifyAll(); // Notify producers that space is available
        return data;
    }
}

class Producer extends Thread {
    private DataQueue dataQueue;

    public Producer(DataQueue dataQueue) {
        this.dataQueue = dataQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                dataQueue.produce(i);
                Thread.sleep(500); // Simulate time taken to produce data
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    private DataQueue dataQueue;

    public Consumer(DataQueue dataQueue) {
        this.dataQueue = dataQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                dataQueue.consume();
                Thread.sleep(1000); // Simulate time taken to consume data
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumer {

    public static void main(String[] args) {
        DataQueue dataQueue = new DataQueue(5);

        Producer producer1 = new Producer(dataQueue);
        Producer producer2 = new Producer(dataQueue);
        Consumer consumer1 = new Consumer(dataQueue);
        Consumer consumer2 = new Consumer(dataQueue);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

        try {
            producer1.join();
            producer2.join();
            consumer1.join();
            consumer2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
