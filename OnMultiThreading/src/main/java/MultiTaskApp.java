public class MultiTaskApp {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() +" Thread started ");

        Thread t1 = new Thread(new Task1());
        t1.setName(" Task-1 Thread");

        Thread t2 = new Thread(new Task2());
        t2.setName("Task-2 Thread");

        t1.start();
        t2.start();

        System.out.println(Thread.currentThread().getName() +" Thread ended ");



    }
}

class Task1 implements Runnable
{
    public void  run()
    {
        System.out.println(Thread.currentThread().getName() +" Thread started :: From Task1 ");
        int counter = 1;
        while(counter <= 10){
            System.out.println(Thread.currentThread().getName() + " Thread Running... : Counter "+counter++);
        }

        System.out.println(Thread.currentThread().getName() +" Thread ended :: From Task1 ");

    }
}

class Task2 implements Runnable
{
    public void  run()
    {
        System.out.println(Thread.currentThread().getName() +" Thread started :::: From Task2 ");
        int counter = 11;
        while(counter <= 20){
            System.out.println(Thread.currentThread().getName() + " Thread Running... : Counter "+counter++);
        }
        System.out.println(Thread.currentThread().getName() +" Thread ended :: From Task2");

    }
}