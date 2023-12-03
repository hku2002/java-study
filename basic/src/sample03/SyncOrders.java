package sample03;

public class SyncOrders extends SyncManager {
    @Override
    public String findRds() {
        System.out.println("find rds orders");
        return "orders";
    }

    @Override
    public String process(String rdsData) {
        System.out.println("process orders");
        if (!"orders".equals(rdsData)) {
            throw new RuntimeException();
        }
        return "documentOrders";
    }

    @Override
    public void upsertDocuments(String data) {
        System.out.println("upsert : " + data);
    }
}
