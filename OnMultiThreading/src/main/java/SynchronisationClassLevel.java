public class SynchronisationClassLevel {

    public static void main(String[] args)  {

        SampleTaskLevel sampleTask1 = new SampleTaskLevel();
        SampleTaskLevel sampleTask2 = new SampleTaskLevel();


        Thread t1 = new Thread(() -> sampleTask1.printTable(1));
        t1.setName("Thread-01");

        Thread t2 = new Thread(() -> sampleTask1.printTable(2));
        t2.setName("Thread-02");

        Thread t3 = new Thread(() -> sampleTask2.printTable(3));
        t3.setName("Thread-03");

        Thread t4 = new Thread(() -> sampleTask2.printTable(4));
        t4.setName("Thread-04");
        t4.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}


class SampleTaskLevel
{
   public static  void printTable(int n)
   {
       synchronized(SampleTaskLevel.class)
       {
           for(int i = 1  ; i <= 10 ; i++)
           {
               System.out.println(Thread.currentThread().getName()+" :: "+n+ " * "+i+" = "+(n*i));
               try
               {
                   Thread.sleep(500);
               }catch (Exception exp)
               {
                   exp.printStackTrace();
               }
           }
       }

   }
}
