/**
 * InventoryMain
 */
public class InventoryMain {
    static int inventory = 0;

    public static void main(String[] args) {
        int addOp = Integer.parseInt(args[0]);
        int subOP = Integer.parseInt(args[1]);
        System.out.println("the number of add is " + addOp + "the number of subtract op " + subOP);

        InventoryMain warehouse = new InventoryMain();

        for (int i = 0; i < addOp; i++)
        {
            Thread addThread = new Thread(() -> {
                warehouse.add();
                System.out.println("An item has been added. Current inventory size: " + inventory);
            });
            addThread.start();
        }

        for (int i = 0; i < subOP; i++) 
        {
            Thread subThread = new Thread(() -> {
                warehouse.sub();
                System.out.println("An Iitem has been removed. Current inventory size: " + inventory);
            });
            subThread.start();
        }

        
    }

    public synchronized int add() {
        inventory++;
        return inventory;
    }

    public synchronized int sub() {
        inventory--;
        return inventory;
    }

}