package sample02;

public class MusicPlayer {

    private String status;
    private int volume;

    public String getStatus() {
        return status;
    }

    public int getVolume() {
        return volume;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    public void volumeUp(int volume) {
        setVolume(this.volume + volume);
        System.out.println("음악 플레이어 볼륨 " + getVolume());
    }

    public void volumeDown(int volume) {
        setVolume(this.volume - volume);
        System.out.println("음악 플레이어 볼륨 " + getVolume());
    }

    public void checkStatus() {
        System.out.println("음악 플레이어 상태 확인");
        System.out.println("음악 플레이어 " + getStatus() + ", 볼륨: " + getVolume());
    }

    public void turnOn() {
        System.out.println("음악 플레이어를 시작합니다.");
        setStatus("ON");
    }

    public void turnOff() {
        System.out.println("음악 플레이어를 종료합니다.");
        setStatus("OFF");
    }
}
