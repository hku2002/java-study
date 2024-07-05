package pattern.singleton.darkmode;

public class DarkModeSingleton {

    private boolean isDarkMode;

    private DarkModeSingleton(boolean isDarkMode) {
        this.isDarkMode = isDarkMode;
    }

    private static final class DarkModeSingletonHolder {
        private static final DarkModeSingleton INSTANCE = new DarkModeSingleton(true);
    }

    public static DarkModeSingleton getInstance() {
        return DarkModeSingletonHolder.INSTANCE;
    }

    public boolean isDarkMode() {
        return isDarkMode;
    }

    public void setDarkMode(boolean darkMode) {
        isDarkMode = darkMode;
    }
}
