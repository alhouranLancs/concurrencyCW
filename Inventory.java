public class Inventory implements Runnable
{
    private int addSub;
    private int inventorySize;

    public Inventory(int i)
    {
        addSub = i;
    }
    
    public void run()
    {
        if(addSub = 0) inventory++;
        else if (addSub = 1) inventory--;
    }

}
