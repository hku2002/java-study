package sample03;

public class SyncMain {

    public static void main(String[] args) {

        SyncManager productSync = new SyncProducts();
        productSync.syncRdsToDocument();

        SyncManager orderSync = new SyncOrders();
        orderSync.syncRdsToDocument();

    }
}
