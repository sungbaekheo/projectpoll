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

    

    
}
