package pattern.builder;

public class BuilderMain {

    public static void main(String[] args) {
        Book book1 = new BookBuilder()
                .id(1L)
                .title("빌더를 다루는 책 part1")
                .subTitle("디자인 패턴의 빌더")
                .author("코니")
                .publisher("코니네 출판")
                .translator(null)
                .price(10_000)
                .build();

        System.out.println("Print book title : " + book1.getTitle());
        System.out.println("Print book author : " + book1.getAuthor());

        Book book2 = Book.builder()
                .id(2L)
                .title("빌더를 다루는 책 part2")
                .subTitle("디자인 패턴의 빌더")
                .author("코니")
                .publisher("코니네 출판")
                .translator(null)
                .price(12_000)
                .build();

        System.out.println("Print book title : " + book2.getTitle());
        System.out.println("Print book author : " + book2.getAuthor());
    }
}
