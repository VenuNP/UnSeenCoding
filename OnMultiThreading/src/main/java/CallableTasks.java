import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CallableTasks {

    public static void main(String[] args) {


       ExecutorService service =  Executors.newFixedThreadPool(10);
       int count = 1;
        List<Future<String>> list = new ArrayList<>();
       IncrementNumber icnr = new IncrementNumber();
       while (count <= 100)
       {
          Future<String> future = service.submit(icnr);
           list.add(future);
           count++;
       }

       list.forEach(f -> {
           try {
               System.out.println(f.get());
           } catch (InterruptedException e) {
               e.printStackTrace();
           } catch (ExecutionException e) {
               e.printStackTrace();
           }
       });
      service.shutdown();
    }
}

class  IncrementNumber implements Callable<String>
{
    AtomicInteger count = new AtomicInteger(1);
    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName() + " : "+count.getAndIncrement();
    }
}


