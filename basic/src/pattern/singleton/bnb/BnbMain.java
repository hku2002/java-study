package pattern.singleton.bnb;

public class BnbMain {

    public static void main(String[] args) {
        Bnb bnb = Bnb.getInstance();

        System.out.println("bnb home link: " + bnb.getHome().getLink());
        System.out.println("bnb home iconImg: " + bnb.getHome().getIconImgPath());
        System.out.println("bnb home description: " + bnb.getHome().getDescription());
        System.out.println("==================================");
        System.out.println("bnb category link: " + bnb.getCategory().getLink());
        System.out.println("bnb category iconImg: " + bnb.getCategory().getIconImgPath());
        System.out.println("bnb category description: " + bnb.getCategory().getDescription());
    }

}
