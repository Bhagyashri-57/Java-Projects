import java.util.Random;

class SharedNumber {
    int number;
    boolean isNew = false;
}

class RandomNumberGenerator extends Thread {
    private final SharedNumber shared;

    public RandomNumberGenerator(SharedNumber shared) {
        this.shared = shared;
    }

    public void run() {
        Random random = new Random();

        while (true) {
            synchronized (shared) {
                while (shared.isNew) {
                    try {
                        shared.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                shared.number = random.nextInt(100);
                shared.isNew = true;
                System.out.println("\nGenerated Number: " + shared.number);

                shared.notifyAll();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SquareComputation extends Thread {
    private final SharedNumber shared;

    public SquareComputation(SharedNumber shared) {
        this.shared = shared;
    }

    public void run() {
        while (true) {
            synchronized (shared) {
                while (!shared.isNew) {
                    try {
                        shared.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int square = shared.number * shared.number;
                System.out.println("Square of " + shared.number + " is " + square);

                shared.notifyAll();
            }
        }
    }
}

class CubeComputation extends Thread {
    private final SharedNumber shared;

    public CubeComputation(SharedNumber shared) {
        this.shared = shared;
    }

    public void run() {
        while (true) {
            synchronized (shared) {
                while (!shared.isNew) {
                    try {
                        shared.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int cube = shared.number * shared.number * shared.number;
                System.out.println("Cube of " + shared.number + " is " + cube);

                shared.isNew = false;

                shared.notifyAll();
            }
        }
    }
}

public class MultiThreadedComputation {
    public static void main(String[] args) {
        SharedNumber shared = new SharedNumber();

        Thread generator = new RandomNumberGenerator(shared);
        Thread squareThread = new SquareComputation(shared);
        Thread cubeThread = new CubeComputation(shared);

        generator.start();
        squareThread.start();
        cubeThread.start();
    }
}