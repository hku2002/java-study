package pattern.strategy;

import static pattern.strategy.PgType.KCP;

public class KcpStrategy implements PgStrategy {
    @Override
    public boolean isCorrectPg(PgType pgType) {
        return KCP == pgType;
    }

    @Override
    public boolean requestPayment(Payment payment) {
        System.out.println("KCP 결제 요청");
        System.out.println("KCP 결제 성공");
        return true;
    }
}
