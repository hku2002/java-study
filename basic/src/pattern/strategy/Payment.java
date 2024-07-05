package pattern.strategy;

public class Payment {

    private final Long id;
    private final PgType pgType;
    private final int totalPay;
    private final int userId;

    public Payment(Long id, PgType pgType, int totalPay, int userId) {
        this.id = id;
        this.pgType = pgType;
        this.totalPay = totalPay;
        this.userId = userId;
    }
}
