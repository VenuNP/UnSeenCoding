public class Synchronisation {

    public static void main(String[] args)  {

        SampleTask sampleTask = new SampleTask();

        Sample sampleRef = new Sample();
        Thread t1 = new Thread(() -> sampleTask.printEven());
        t1.setName("Even-Thread");

        Thread t2 = new Thread(() -> sampleTask.printOdd());
        t2.setName("Odd-Thread");

        Thread t3 = new Thread(() -> sampleTask.printDivisibleOf3());
        t3.setName("Divisible(3)-Thread");

        Thread t4 = new Thread(() -> sampleTask.printDivisibleOf4());
        t4.setName("Divisible(4)-Thread");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}


class SampleTask
{
    private int counter = 1;

    public synchronized void printEven()  {
        while (counter <= 10)
        {
            if(counter%2 == 0)
            {
                System.out.println(Thread.currentThread().getName()+" : "+counter++);
                notifyAll();
            }

            try {
                Thread.sleep(500);
                wait(); // Releases the Lock
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public synchronized void printOdd()
    {
        while (counter <= 10)
        {
            if(counter%2 == 1)
            {
                System.out.println(Thread.currentThread().getName()+" : "+counter++);
                notifyAll();
            }

            try {
                Thread.sleep(500);
                wait(); //  Releases the Lock
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        notifyAll();

    }

    public  void printDivisibleOf3()
    {
        int counter = 1;
        synchronized (this){
        while (counter <= 10)
        {


            if(counter%3 == 0)
            {
                System.out.println(Thread.currentThread().getName()+" : "+counter);
            }
            counter++;
            notifyAll();

            try {
                Thread.sleep(500);
                wait(); //  Releases the Lock
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        notifyAll();
        }
    }

    public synchronized void printDivisibleOf4()
    {

        int counter = 1;

        while (counter <= 10)
        {

            if(counter%4 == 0)
            {
                System.out.println(Thread.currentThread().getName()+" : "+counter);
            }
            counter++;
            notifyAll();

            try {
                Thread.sleep(500);
                wait(); //  Releases the Lock
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        notifyAll();

    }


}
