package OnStatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleTonDesignPattern {

    public static void main(String[] args) {

        Thread t1 = new Thread(() ->
        {
            Sample.getInstance();
            System.out.println("Request through ..."+Thread.currentThread().getName()+" .....Completed");
        }
                );
        Thread t2 =  new Thread(() ->
        {
            Sample.getInstance();
            System.out.println("Request through ..."+Thread.currentThread().getName()+" .....Completed");
        }
        );
        Thread t3 =  new Thread(() ->
        {
            Sample.getInstance();
            System.out.println("Request through ..."+Thread.currentThread().getName()+" .....Completed");
        }
        );
        Thread t4 =  new Thread(() ->
        {
            Sample.getInstance();
            System.out.println("Request through ..."+Thread.currentThread().getName()+" .....Completed");
        }
        );

        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(t1);
        service.submit(t2);
        service.submit(t3);
        service.submit(t4);
        service.shutdownNow();

        try{
            Thread.sleep(2000);
        }catch (Exception exception){}


        if( Sample.getCounter() == 1)
            {
                System.out.println("SingleTon Achieved !!! ");
            }else
            {
                System.out.println("SingleTon Failed !!! Instances :: "+Sample.getCounter());
            }



    }
}


class  Sample
{
    private static Sample sampleRef = null;
     static int counter = 0;

    private Sample()
    {
        counter++;
    }

    public static  int getCounter()
    {
        return counter;
    }

    public static Sample getInstance()   {

        synchronized (Sample.class)
        {
            if(sampleRef == null)
            {
                try{
                    Thread.sleep(500);
                }catch (Exception exception){}
                sampleRef = new Sample();
            }
        }


        return sampleRef;
    }



}