import javax.annotation.processing.SupportedSourceVersion;
import java.util.function.Consumer;

public class ConsumerEx {
    public static void main(String[] args) {
        ConsumerSample sample = new ConsumerSample();
        sample.print((a) -> System.out.println(" From Consumer " +a));
    }
}

class ConsumerSample
{

   public void print(Consumer<Integer> consumer)
   {
       consumer.accept(5);
   }
}