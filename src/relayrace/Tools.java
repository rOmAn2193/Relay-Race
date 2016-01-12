
package relayrace;

import java.util.List;
import java.util.Random;

public class Tools {
    static Random random = new Random();
    static int rand(int a, int b) {
        return a + random.nextInt(b-a+1);
    }
    static int rand(int n) {
        return rand(0,n-1);
    }
    
    static <T> T rand(T [] a) {
       return a[rand(a.length)];
    }
    
    static <T> T rand(List<T> list) {
        return list.get(rand(list.size()));
    }

    public static final void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // ignore exception....
        }
    }
}
