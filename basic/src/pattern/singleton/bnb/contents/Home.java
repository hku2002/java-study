package pattern.singleton.bnb.contents;

public class Home {

    private Home() {}

    private static final class HomeHolder {
        private static final Home HOME_INSTANCE = new Home();
    }

    public static Home getInstance() {
        return HomeHolder.HOME_INSTANCE;
    }

    public String getLink() {
        return "/link/home";
    }

    public String getIconImgPath() {
        return "/images/home.webp";
    }

    public String getDescription() {
        return "홈";
    }
}
