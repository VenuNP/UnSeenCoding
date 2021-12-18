import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTasks {

    public static void main(String[] args) {
        Runnable rTask1 = () -> {
            int i = 1;
            while( i <= 5)
            {
                System.out.println("Runnable Task - 01 -- " +Thread.currentThread().getName());
                i++;
            }
        };

        Runnable rTask2 = () -> {
            int i = 1;
            while( i <= 5)
            {
                System.out.println("Runnable Task - 02 -- " +Thread.currentThread().getName());
                i++;

            }
        };
        Runnable rTask3 = () -> {
            int i = 1;
            while( i <= 5)
            {
                System.out.println("Runnable Task - 03  -- " +Thread.currentThread().getName());
                i++;

            }
        };
        Runnable rTask4 = () -> {
            int i = 1;
            while( i <= 5)
            {
                System.out.println("Runnable Task - 04 -- " +Thread.currentThread().getName());
                i++;

            }
        };

        Runnable rTask5 = () -> {
            int i = 1;
            while( i <= 5)
            {
                System.out.println("Runnable Task - 05 -- " +Thread.currentThread().getName());
                i++;

            }
        };

        Runnable rTask6 = () -> {
            int i = 1;
            while( i <= 5)
            {
                System.out.println("Runnable Task - 06 -- " +Thread.currentThread().getName());
                i++;

            }
        };

        Runnable rTask7 = () -> {
            int i = 1;
            while( i <= 5)
            {
                System.out.println("Runnable Task - 07 -- " +Thread.currentThread().getName());
                i++;

            }
        };

     ExecutorService service =  Executors.newFixedThreadPool(2);
        service.submit(rTask1);
        service.submit(rTask2);
        service.submit(rTask3);
        service.submit(rTask4);
        service.submit(rTask5);
        service.submit(rTask6);
        service.submit(rTask7);
       service.shutdown();

    }
}

