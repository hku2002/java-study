package sample01;

public class ClassStart2 {

    public static void main(String[] args) {
        String[] student1Names = {"학생1", "학생2"};
        int[] student1Ages = {17, 18};
        int[] student1Grade = {10, 20};

        for (int i=0; i<student1Names.length; i++) {
            System.out.println("이름 : " + student1Names[i] + ", 나이 : " + student1Ages[i] + " 성적 : " + student1Grade[i]);
        }
    }
}
