package pattern.builder;

public class BuilderMain {

    public static void main(String[] args) {
        Book book = new BookBuilder()
                .id(1L)
                .title("빌더를 다루는 의 책")
                .subTitle("디자인 패턴의 빌더")
                .author("코니")
                .publisher("코니네 출판")
                .translator(null)
                .price(10_000)
                .build();

        System.out.println("Print book title : " + book.getTitle());
        System.out.println("Print book author : " + book.getAuthor());
    }
}
