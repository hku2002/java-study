package pattern.strategy;

import static pattern.strategy.PgType.KAKAO_PAY;

public class KakaoPayStrategy implements PgStrategy {
    @Override
    public boolean isCorrectPg(PgType pgType) {
        return KAKAO_PAY == pgType;
    }

    @Override
    public boolean requestPayment(Payment payment) {
        System.out.println("카카오 페이 결제 요청");
        System.out.println("카카오 페이 결제 성공");
        return true;
    }
}
