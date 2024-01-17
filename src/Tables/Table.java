package Tables;

public class Table implements ITable {
    private boolean isFree;

    public Table() {
        this.isFree = true;
    }

    @Override
    public boolean isFree() {
        return isFree;
    }

    @Override
    public void Occupy() {
        if (!isFree) {
            System.out.println("The table already occupied");
        } else {
            isFree = false;
        }
    }

    @Override
    public void toFree() {
        if (isFree) {
            System.out.println("The table already free");
        } else {
            isFree = true;
        }
    }
}