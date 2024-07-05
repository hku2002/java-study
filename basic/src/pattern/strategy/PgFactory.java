package pattern.strategy;

import java.util.List;

public class PgFactory {

    public static final List<PgStrategy> pgStrategies = List.of(
            new KakaoPayStrategy(),
            new NaverPayStrategy(),
            new KakaoPayStrategy()
    );

    public PgStrategy findStrategy(PgType pgType) {
        return pgStrategies.stream()
                .filter(pgStrategy -> pgStrategy.isCorrectPg(pgType))
                .findFirst()
                .orElseThrow();
    }

}
