public class MultiTaskFunctionalProgrammingApp {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() +" Thread started ");

        Thread t1 = new Thread( () ->
        {
            int counter = 1;
            while(counter <= 10){
                System.out.println(Thread.currentThread().getName() + " Thread Running... : Counter "+counter++);
            }


        });
        t1.setName(" Lamda-1 Thread");
        t1.setPriority(Thread.MIN_PRIORITY);


        Thread t2 = new Thread(() ->
        {
            int counter = 11;
            while(counter <= 20){
                System.out.println(Thread.currentThread().getName() + " Thread Running... : Counter "+counter++);
            }

        }
              );
        t2.setName("Lamda-2 Thread");
        t2.setPriority(Thread.MAX_PRIORITY);




        Thread t3 = new Thread(() ->
        {
            int counter = 11;
            while(counter <= 20){
                System.out.println(Thread.currentThread().getName() + " Thread Running... : Counter "+counter++);
            }

        }
        );
        t2.setName("Lamda-3 Thread");
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t1.join();
        t2.start();
        t3.start();

        System.out.println(Thread.currentThread().getName() +" Thread ended ");

// New State -> Thread Object is been created.
// Runnable -> Thread is ready the but ThreadScheduler did not schedule it.
// Running ... ->  Thread is Running....
// Waiting state --> Leads to Blocked State if no other thread calls notify
// Time Waiting State --> Goes to Runnable state once the sleeping time completed.
// Blocked State --> Both the threads waiting to aquire the lock

    }
}
