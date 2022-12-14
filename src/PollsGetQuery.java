public class PollsGetQuery {
    
    // 설문 번호 받아오는 쿼리
    public String getMaxNum() {
        String query = "SELECT MAX(id) FROM response";
        return query;
    }

    // 문항 갯수 받아오는 쿼리
    public String countQuest() {
        String query = "SELECT COUNT(question) FROM quest";
        return query;
    }

     // 전체 질문 받아오는 쿼리
     public String getAllQuestions() {
        String query = "SELECT question FROM quest";

        return query;
    }

    // 문항 번호별 질문 받아오는 쿼리
    public String getQuestion(int qNum) {
        String query = "SELECT question FROM quest " +
                        "WHERE quest_key = " + qNum;

        return query;
    }

    // 설문 번호에 따른 설문 결과 받아오는 쿼리
    public String getTotalResult(int id) {

        String query = "SELECT ans.answer " +
                        "FROM ((((response " +
                        "INNER JOIN res_q ON response.id = res_q.id) " +
                        "INNER JOIN qna ON res_q.qna_key = qna.qna_key) " +
                        "INNER JOIN quest ON qna.quest_key = quest.quest_key) " +
                        "INNER JOIN ans ON qna.ans_key = ans.ans_key) " +
                        "WHERE response.id = " + id;
        return query;

    }
    
    // 설문 번호에 따른 유저 정보 받아오는 쿼리
    public String getUser(int id) {
        String query = "SELECT id, name FROM response " +
                        "WHERE id = " + id;
        return query;
    }

    // 답변 문항 받아오는 쿼리
    public String getAnswer(int aNum) {
        String query = "SELECT answer FROM ans " +
                        "WHERE ans_key = " + aNum;

        return query;
    }

    // 답변 질문 갯수 받아오는 쿼리
    public String countAns() {
        String query = "SELECT COUNT(answer) FROM ans";
        return query;
    }

    // 답변 번호별 응답 갯수 받아오는 쿼리
    public String getCountAnswers(int qNum, int aNum) {
        String query = "SELECT COUNT(ans.ans_key) " +
                        "FROM ((((response " +
                        "INNER JOIN res_q ON response.id = res_q.id) " +
                        "INNER JOIN qna ON res_q.qna_key = qna.qna_key) " +
                        "INNER JOIN quest ON qna.quest_key = quest.quest_key) " +
                        "INNER JOIN ans ON qna.ans_key = ans.ans_key) " +
                        "where quest.quest_key = "+ qNum + " and ans.ans_key = " + aNum;

        return query;
    }

    // 응답자 정보 입력하는 쿼리
    public String insertIntoResponse(int id, String name) {
        String query = "INSERT INTO response(id, name) " +
                        "VALUES("+id+", "+"\""+name+"\""+")";
        return query;
    }
    
    // 문항에 대한 답을 입력하는 쿼리
    public String insertIntoQnA(int total, int qNum, int aNum) {
        String query = "INSERT INTO qna(qna_key, ans_key, quest_key) " +
                        "VALUES("+total+", "+aNum+", "+qNum+")";
        return query;
    }

    // 응답자와 답의 연결을 입력하는 쿼리
    public String insertIntoResQ(int id, int total) {
        String query = "INSERT INTO res_q(id, qna_key) " +
                        "VALUES("+id+", "+total+")";
        return query;
    }

    // total 갯수 받아오는 쿼리
    public String getTotalNumber() {
        String query = "SELECT COUNT(qna_key) FROM qna";
        return query;
    }

    // 답항 리스트 받아오는 쿼리
    public String getAllAnswers() {
        String query = "SELECT answer FROM ans";
        return query;
    }
}
