package sample2;

public class MusicPlayerMain {

    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();

        musicPlayer.turnOn();
        musicPlayer.volumeUp(1);
        musicPlayer.volumeUp(1);
        musicPlayer.volumeDown(1);
        musicPlayer.checkStatus();
        musicPlayer.turnOff();
    }
}
