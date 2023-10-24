public class Inventory implements Runnable
{
    private int addSub;
    private int inventory;

    public Inventory(int addSub, int inventory)
    {
        this.addSub = addSub;
        this.inventory = inventory;
    }
    
    @Override
    public synchronized void run() {
        if(addSub == 0)inventory++;
        else if(addSub==1)inventory--;
        return inventory;
    }

}
