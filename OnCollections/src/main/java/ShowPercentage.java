
public class ShowPercentage {
    public static void main(String[] args) throws InterruptedException {

        /*
        Print p = new Print();
        Thread t1 = new Thread( () -> p.printEven());
        Thread t2 = new Thread( () -> p.printOdd());

        t1.start();
        t2.start();
         */

        int count = 1;
        while(count <= 100)
        {
            synchronized (System.out)
            {
                System.out.print("\b\b\b"+ count++ +"%");
                        Thread.sleep(100);
            }
        }
        System.out.println();
    }
}

/*
class Print
{
    int count = 1;

    public synchronized void printEven()
    {
        synchronized (this)
        {
            try
            {
                while(count  <= 100) {
                    if (count % 2 == 1) {
                        System.out.print( count++ + "%");
                        notify();
                        Thread.sleep(200);
                    }
                    wait();
                }
            }catch (Exception exp){

            }

        }
    }

    public synchronized void printOdd()
    {
        synchronized (this)
        {
            try
            {
                while(count  <= 100) {
                    if (count % 2 == 0) {
                        System.out.print(    count++ + "%");
                        notify();
                        Thread.sleep(200);
                    }
                    wait();
                }
                notify();
            }catch (Exception exp){

            }

        }
    }
}
*/
