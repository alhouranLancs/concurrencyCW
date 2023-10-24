/**
 * InventoryMain
 */
public class InventoryMain {
    private static int inventory = 0;

    public static void main(String[] args) 
    {
        int addOp = Integer.parseInt(args[0]);
        int subOP = Integer.parseInt(args[1]);
        System.out.println("The number of add is " + addOp + "the number of subtract op " + subOP);

        InventoryMain warehouse = new InventoryMain();

        Thread[] addThreads = new Thread[addOp];
        Thread[] subThreads = new Thread[subOP];

        for (int i = 0; i < addOp; i++)
        {
            addThreads[i] = new Thread(() -> {
                warehouse.add();
                System.out.println("Added. Current inventory size = " + inventory);
            });
            addThreads[i].start();
        }

        for (int i = 0; i < subOP; i++) 
        {
            subThreads[i] = new Thread(() -> {
                warehouse.sub();
                System.out.println("Removed. Current inventory size = " + inventory);
            });
            subThreads[i].start();
        }

        for (int i = 0; i < addOp; i++) 
        {
            try {
                addThreads[i].join();
            }
            catch (Exception e) {
                System.out.println("The exception has been caught " + e);
            }
        }

        for (int i = 0; i < subOP; i++) 
        {
            try {
                subThreads[i].join();
            }
            catch (Exception e) {
                System.out.println("The exception has been caught " + e);
            }
        }

        System.out.println("Final inventory size = " + inventory);

        
    }

    public static int getInventory() {
        return inventory;
    }

    public synchronized static int add()
    {
        inventory++;
        return inventory;
    }

    public synchronized int sub()
    {
        inventory--;
        return inventory;
    }

}