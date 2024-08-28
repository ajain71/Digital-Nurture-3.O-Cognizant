import java.util.Random;

public class SensorSimulation {

    static class Sensor extends Thread {
        private String sensorName;

        public Sensor(String sensorName) {
            this.sensorName = sensorName;
        }

        @Override
        public void run() {
            Random random = new Random();
            try {
                for (int i = 0; i < 5; i++) {
                    int data = random.nextInt(100);
                    System.out.println(sensorName + " collected data: " + data);
                    Thread.sleep(1000); // Simulate time delay between data collection
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Sensor sensor1 = new Sensor("Sensor 1");
        Sensor sensor2 = new Sensor("Sensor 2");
        Sensor sensor3 = new Sensor("Sensor 3");

        sensor1.start();
        sensor2.start();
        sensor3.start();

        try {
            sensor1.join();
            sensor2.join();
            sensor3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All sensors have completed data collection.");
    }
}
