package pattern.strategy;

public record Payment(Long id, PgType pgType, int totalPay, int userId) {
}
