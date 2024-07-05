package pattern.strategy;

public enum PgType {

    KAKAO_PAY("카카오페이"),
    NAVER_PAY("네이버페이"),
    KCP("KCP");

    private String description;

    PgType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
