
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PollsSurvey {

    ResultSet rs, rs2;

    private int id;
    private String name;
    private int ans;
    private int countQ, total;

    PollsGetQuery qry = new PollsGetQuery();
    PollsPrintMenu prt = new PollsPrintMenu();

    public void runSurvey(Statement stmt1, Statement stmt2) {

        try {
            name = prt.surveyMenu();
            rs = stmt1.executeQuery(qry.getMaxNum());
            while(rs.next()) {
                id = rs.getInt("MAX(id)") + 1;
            }

            survey(stmt1, stmt2);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    //  설문조사
    public void survey(Statement stmt1, Statement stmt2) {

        Scanner scan = new Scanner(System.in);

        try {
            rs = stmt1.executeQuery(qry.countQuest());
            while(rs.next()) {
                countQ = rs.getInt("COUNT(question)");
            }
            rs = stmt1.executeQuery(qry.getTotalNumber());
            while(rs.next()) {
                total = rs.getInt("COUNT(qna_key)");
            }

            List<String> answer = new ArrayList<String>();

            rs = stmt1.executeQuery(qry.getAllQuestions());
            rs.first();
            for(int qNum= 1; qNum <= countQ; qNum++) {
                System.out.println(rs.getString("question"));
                rs.next();

                rs2 = stmt2.executeQuery(qry.getAllAnswers());
                int num = 1;
                while(rs2.next()) {
                    System.out.print(String.valueOf(num) + ". ");
                    System.out.print(rs2.getString("answer"));
                    System.out.print("   ");
                    num++;
                }
                System.out.println("\n");
                System.out.print("입력: ");
                answer.add(scan.nextLine());
            }

            String[] answerList = new String[ answer.size() ];
            answer.toArray(answerList);
            
            int inst = stmt1.executeUpdate(qry.insertIntoResponse(id, name));
            for(int i = 1; i<=countQ; i++) {
                ans = Integer.parseInt(answerList[i-1]);
                inst = stmt1.executeUpdate(qry.insertIntoQnA(total+i,i,ans));
                inst = stmt1.executeUpdate(qry.insertIntoResQ(id, (total+i)));        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
}
