import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            Statement stmt1 = conn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );
            Statement stmt2 = conn.createStatement();
            
        // 설문 프로그램 시작
            boolean run = true;
            while (run) {
                String poll = prt.mainMenu(); // 설문, 통계 선택 메뉴 출력
                switch (poll) {
                    case "p":
                    case "P": svy.runSurvey(stmt1, stmt2); break;
                    case "s":
                    case "S": sts.runStatistics(stmt1); break;
                    case "q":
                    case "Q": System.out.println("설문을 종료합니다."); run = false; break;
                    default : System.out.println("올바른 항목을 입력해주세요.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
