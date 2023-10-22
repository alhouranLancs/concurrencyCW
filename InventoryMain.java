/**
 * InventoryMain
 */
public class InventoryMain {
    static int inventory = 0;
    public static void main(String[] args) {
        int addOp = Integer.parseInt(args[0]);
        int subOP = Integer.parseInt(args[1]);
        System.out.println("the number of add is " + addOp + "the number of subtract op " + subOP);
        
        for(int i = 0; i>addOp; i++)
        {
            add();
        }
    }
    public synchronized static int add(){
        inventory++;
        return inventory;
    }
    public synchronized int sub(){
        inventory--;
        return inventory;
    }
}