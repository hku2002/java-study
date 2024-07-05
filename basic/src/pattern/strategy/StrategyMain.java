package pattern.strategy;

import static pattern.strategy.PgType.KAKAO_PAY;
import static pattern.strategy.PgType.NAVER_PAY;

public class StrategyMain {

    public static void main(String[] args) {

        Payment naverPayment = createPayment(NAVER_PAY);
        PgFactory pgFactory = new PgFactory();
        PgStrategy naverStrategy = pgFactory.findStrategy(NAVER_PAY);
        naverStrategy.requestPayment(naverPayment);

        Payment payment = createPayment(KAKAO_PAY);
        PgStrategy kakaoStrategy = pgFactory.findStrategy(KAKAO_PAY);
        kakaoStrategy.requestPayment(payment);

    }

    private static Payment createPayment(PgType pgType) {
        return new Payment(1L, pgType, 10_000, 1201);
    }

}
