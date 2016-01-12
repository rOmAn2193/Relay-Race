
package relayrace;

import java.util.logging.Level;
import java.util.logging.Logger;
import static relayrace.Tools.*;

public class Runner implements Runnable {
    private int id;
    private int size;
    private Baton left;
    private Baton right;
    public Runner(int _id, int _size) {
        this.id=_id;
        this.size=_size;
    }
    public int getID() { return id; }
    
    public void setLeftBaton(Baton baton) {
        this.left = baton;
    }

    public void setRightBaton(Baton baton) {
        this.right = baton;
    }
    
    private Thread thread = null;
    
    public void go()
    {
        System.out.println("On your marks... Get set... Go");
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private boolean running = false;
    
    public void stop() { 
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
        }
        System.out.println("Runner # " + getID() + " finished.");
        thread = null;
    }
    
    @Override
    public void run() {
        while (running) {
            System.out.println("Runner #" + getID() + " is running...");
            sleep(rand(50,150));
            System.out.println("Runner #" + getID() + " passed the baton");
            left.pickUp(this);
            sleep(rand(5,15));
            right.pickUp(this);
            System.out.println("Runner #" + getID() + " got the baton...");
            sleep(rand(50,150));
            right.drop();
            sleep(rand(5,15));
            left.drop();
        }
    }
}
