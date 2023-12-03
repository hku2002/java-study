package sample03;

public class SyncProducts extends SyncManager {

    @Override
    public String findRds() {
        System.out.println("find rds products");
        return "products";
    }

    @Override
    public String process(String rdsData) {
        System.out.println("process products");
        if (!"products".equals(rdsData)) {
            throw new RuntimeException();
        }
        return "documentProducts";
    }

    @Override
    public void upsertDocuments(String data) {
        System.out.println("upsert : " + data);
    }

}
