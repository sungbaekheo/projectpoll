
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PollsSurvey {

    ResultSet rs;

    private int id;
    private String name;
    private int ans1, ans2, ans3, ans4;

    PollsGetQuery qry = new PollsGetQuery();
    PollsPrintMenu prt = new PollsPrintMenu();

    public void runSurvey(Statement stmt) {

        try {
            name = prt.surveyMenu();
            rs = stmt.executeQuery(qry.getMaxNum());
            while(rs.next()) {
                id = rs.getInt("MAX(id)") + 1;
            }

            System.out.println(id + " " + name);


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }
    
}
