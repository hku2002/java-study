package sample03;

public abstract class SyncManager {

    public abstract String findRds();
    public abstract String process(String rdsData);
    public abstract void upsertDocuments(String data);

    public void syncRdsToDocument() {
        String rdsResult = findRds();
        String data = process(rdsResult);
        upsertDocuments(data);
    }

}
