package pattern.strategy;

import static pattern.strategy.PgType.NAVER_PAY;

public class NaverPayStrategy implements PgStrategy {
    @Override
    public boolean isCorrectPg(PgType pgType) {
        return NAVER_PAY == pgType;
    }

    @Override
    public boolean requestPayment(Payment payment) {
        System.out.println("네이버 페이 결제 요청");
        System.out.println("네이버 페이 결제 성공");
        return true;
    }
}
