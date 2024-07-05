package pattern.strategy;

public interface PgStrategy {

    boolean isCorrectPg(PgType pgType);
    boolean requestPayment(Payment payment);

}
