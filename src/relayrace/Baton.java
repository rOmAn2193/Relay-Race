
package relayrace;


public class Baton {

    private int id;
    private int size;
    private Runner owner = null;
    private Object lock = new Object();

    public Baton(int _id, int _size) {
        this.id = _id;
        this.size = _size;
    }

    public int getID() {
        return id;
    }

    public void pickUp(Runner _owner) {
        synchronized (lock) {
            while (owner != null) {
                System.out.println("Runner # " + _owner.getID()
                        + " waiting for baton # " + getID());
                try {
                    lock.wait();
                } catch (InterruptedException ex) {
                }
            }
            owner = _owner;
            System.out.println("Runner # " + owner.getID()
                    + " got baton # " + getID());
        }
    }

    public void drop() {
        synchronized (lock) {
            System.out.println("Runner # " + owner.getID()
                    + " lost the baton # " + getID());
            owner = null;
            lock.notifyAll();
        }
    }
}
