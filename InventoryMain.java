/**
 * InventoryMain
 */
public class InventoryMain {
    static int inventory = 0;

    public static void main(String[] args) {
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
                System.out.println("An item has been added. Current inventory size: " + inventory);
            });
            addThreads[i].start();
        }

        for (int i = 0; i < subOP; i++) 
        {
            subThreads[i] = new Thread(run(0));
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

        
    }

    public synchronized int run(int i) {
        if(i == 0)inventory++;
        else if(i==1)inventory--;
        return inventory;
    }

}