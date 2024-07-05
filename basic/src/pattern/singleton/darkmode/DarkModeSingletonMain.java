package pattern.singleton.darkmode;

public class DarkModeSingletonMain {

    public static void main(String[] args) {

        DarkModeSingleton darkModeSingleton = DarkModeSingleton.getInstance();
        System.out.println("다크모드 여부: " + darkModeSingleton.isDarkMode());

        darkModeSingleton.setDarkMode(false);
        System.out.println("다크모드 여부: " + darkModeSingleton.isDarkMode());

    }

}
