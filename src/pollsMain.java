import java.sql.*;

public class PollsMain {
    public static void main(String[] args) {

        final String DB_URL = "jdbc:mysql://localhost/polls";
        final String USER = "root";
        final String PASS = "tbrs00002b";

        PollsPrintMenu prt = new PollsPrintMenu();
        PollsSurvey svy = new PollsSurvey();
        PollsStatistics sts = new PollsStatistics();

        
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        
        
        // 설문 프로그램 시작
            boolean run = true;
            while (run) {
                String poll = prt.mainMenu(); // 설문, 통계 선택 메뉴 출력
                switch (poll) {
                    case "p":
                    case "P": svy.runSurvey(stmt); break;
                    case "s":
                    case "S": sts.runStatistics(stmt); break;
                    case "q":
                    case "Q": System.out.println("설문을 종료합니다."); run = false; break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
