public class InterThreadCommunication {

    public static void main(String[] args)  {

        Sample sampleRef = new Sample();
        Thread t1 = new EvenTask(sampleRef);
        t1.setName("Even-Thread");

        Thread t2 = new OddTask(sampleRef);
        t2.setName("Odd-Thread");

        t1.start();
        t2.start();

    }
}

class EvenTask extends  Thread
{
    Sample sample ;
    public EvenTask(Sample sample)
    {
        this.sample = sample;
    }

    public void run()
    {
        sample.printEven();
    }

}

class OddTask extends  Thread
{
    Sample sample ;
    public OddTask(Sample sample)
    {
        this.sample = sample;
    }

    public void run()
    {
        sample.printOdd();
    }

}

class Sample
{
    private int counter = 1;

    public synchronized void printEven()  {
        while (counter <= 10)
        {
            if(counter%2 == 0)
            {
                System.out.println(Thread.currentThread().getName()+" : "+counter++);
                notify();
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
                notify();
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
}
