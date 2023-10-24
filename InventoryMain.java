/**
 * InventoryMain
 */
public class InventoryMain {
    
    private static int inventory = 0;

    /**
     * Main Method that starts the inventory manipulation process, by taking the number of add
     * operations as a first parameter and the number of subtract operations as the second parameter.
     * 
     * @param args Command-line arguments: number of add operations and then the number of subtract operations.
     */
    public static void main(String[] args) 
    {
        // Variables that store the command line arguments for the number of operations
        int addOp = Integer.parseInt(args[0]);
        int subOP = Integer.parseInt(args[1]);
        System.out.println("The number of add is " + addOp + "the number of subtract op " + subOP);

        // Arrays of threads that store the add and subtract operations
        Thread[] addThreads = new Thread[addOp];
        Thread[] subThreads = new Thread[subOP];

        // Creating and starting threads for adding operations.
        for (int i = 0; i < addOp; i++)
        {
            addThreads[i] = new Thread(() -> {
                add();
                System.out.println("Added. Current inventory size = " + inventory);
            });
            addThreads[i].start(); // Start the thread
        }

        // Creating and starting threads for subtract operations.
        for (int i = 0; i < subOP; i++) 
        {
            subThreads[i] = new Thread(() -> {
                sub();
                System.out.println("Removed. Current inventory size = " + inventory);
            });
            subThreads[i].start(); // Start the thread
        }

        // calling join() on the threads to ensure that they have all completed
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

        // Prints final inventory size
        System.out.println("Final inventory size = " + inventory);

        
    } 

    /**
     * Adds an item to the inventory. This method is synchronized to ensure atomicity of threads to avoid race conditions.
     *
     * @return Inventory size after adding an item.
     */
    public synchronized static int add()
    {
        inventory++;
        return inventory;
    }

    /**
     * Adds an item to the inventory. This method is synchronized to ensure atomicity of threads to avoid race conditions.
     *
     * @return Inventory size after removing an item.
     */
    public synchronized static int sub()
    {
        inventory--;
        return inventory;
    }

}