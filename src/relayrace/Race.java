
package relayrace;


public class Race {
    private int size;
    private Baton [] batons;
    private Runner [] runners;
    public Race(int _size) {
        this.size = _size;
        this.batons = new Baton[this.size];
        for (int i=0; i<this.size; ++i) {
            this.batons[i] = new Baton(i,this.size);
        }
       this.runners = new Runner[this.size];

    }
    public void addRunner(Runner runner) {
        int id = runner.getID();
        this.runners[id]=runner;
        runner.setLeftBaton(this.batons[(id+1)%this.size]);
        runner.setRightBaton(this.batons[id]);
    }

    public void go()
    {
        for (int i=0; i<this.size; ++i) {
            runners[i].go();
        }
    }
    
    public void stop()
    {
        for (int i=0; i<this.size; ++i) {
            runners[i].stop();
        }
    }
}

