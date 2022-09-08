import java.sql.*;

public class PollsMain {
    public static void main(String[] args) {
        PollsPrintMenu prt = new PollsPrintMenu();
        PollsSurvey svy = new PollsSurvey();
        PollsStatistics sts = new PollsStatistics();

        boolean run = true;
       while (run) {
        String poll = prt.mainMenu(); // 설문, 통계 선택 메뉴 출력
        switch (poll) {
            case "p":
            case "P": System.out.println("설문조사"); break;
            case "s":
            case "S": System.out.println("통계 확인"); break;
            case "q":
            case "Q": System.out.println("설문을 종료합니다."); run = false; break;
        }
       }
    }
}
