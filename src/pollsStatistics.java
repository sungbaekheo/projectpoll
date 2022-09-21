
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PollsStatistics {

    PollsGetQuery qry = new PollsGetQuery();
    PollsPrintMenu prt = new PollsPrintMenu();
    ResultSet rs, rs2, rs3;

    int maxNum, id, countQ, countA, numberA; 
    String name, answer, question;

    // 통계 항목 실행 바디
    public void runStatistics(Statement stmt) {
        boolean run = true;
        while (run) {
            int menu = prt.statisticsMenu();
            switch (menu) {
                case 1: statisticsByResponses(stmt); break;
                case 2: statisticsByQuestions(stmt); break;
                case 3: run = false;
                default : System.out.println("올바른 항목을 입력해주세요.");
            }
        }
        
    }

    // 질문자별 통계
    public void statisticsByResponses(Statement stmt) {

        try {
            // 설문 번호 받아오기
            rs = stmt.executeQuery(qry.getMaxNum());
            while(rs.next()) {
                maxNum = rs.getInt("MAX(id)");
            }
            // 문항 갯수 받아오기
            rs = stmt.executeQuery(qry.countQuest());
            while(rs.next()) {
                countQ = rs.getInt("COUNT(question)");
            }
            // 설문 번호에 따른 결과 출력
            for(int i = 1; i <= maxNum; i++) {
                
                // 순서대로 id와 name 받아오기
                rs2 = stmt.executeQuery(qry.getUser(i));
                while(rs2.next()) {
                    id = rs2.getInt("id");
                    name = rs2.getString("name");
                }
                System.out.print(id + "    " + name + "     ");
                
                // id에 맞는 순서대로 결과 불러오기
                rs3 = stmt.executeQuery(qry.getTotalResult(i));
                rs3.first();
                for(int j = 1; j <= countQ; j++) {
                    String space = " ";
                    System.out.printf("%s%-30s",rs3.getString("answer"), space);
                    rs3.next();
                }
                
                System.out.println();

            }

        } catch (SQLException e) {
        e.printStackTrace();
        }
    
    }

    // 문항별 통계
    public void statisticsByQuestions(Statement stmt) {

        try {
            // 문항 갯수 받아오기
            rs = stmt.executeQuery(qry.countQuest());
            while(rs.next()) {
                countQ = rs.getInt("COUNT(question)");
            }
            rs = stmt.executeQuery(qry.countAns());
            while(rs.next()) {
                countA = rs.getInt("COUNT(answer)");
            }

            for(int qNum = 1; qNum <= countQ; qNum++) {

                rs = stmt.executeQuery(qry.getQuestion(qNum));
                rs.first();
                question = rs.getString("question");
                System.out.println(question);
                
                for (int aNum = 1; aNum <= countA; aNum++) {
                    // 답변 항목 가져오기
                    rs = stmt.executeQuery(qry.getAnswer(aNum));
                    while(rs.next()) {
                        answer = rs.getString("answer");
                    }
                    // 해당 답변 응답 갯수 가져오기
                    rs2 = stmt.executeQuery(qry.getCountAnswers(qNum, aNum));
                    while(rs2.next()) {
                        numberA = rs2.getInt("COUNT(ans.ans_key)");
                    }
                    System.out.println(answer + ": " + numberA + " 개");
                }
                System.out.println();

            }
        } catch (SQLException e) {
        e.printStackTrace();
        }



    }
    

}




