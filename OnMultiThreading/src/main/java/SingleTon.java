public class SingleTon {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> Single.getSingleRef());
        Thread t2 = new Thread(() -> Single.getSingleRef());
        t1.start();
        t2.start();
    }
}


class Single
{
    private static   Single singleRef;

    private Single()
    {
        System.out.println(" Single :: Constructor ");
    }

    public static Single getSingleRef() {

        synchronized (Single.class)
        {
            if(singleRef == null)
            {
                singleRef = new Single();
            }
        }
        return  singleRef;
    }
}