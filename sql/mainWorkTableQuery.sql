-- 전체 인원의 설문 결과를 불러오는 쿼리문
SELECT response.id, response.name, quest.question, ans.answer
FROM ((((response
INNER JOIN res_q ON response.id = res_q.id)
INNER JOIN qna ON res_q.qna_key = qna.qna_key)
INNER JOIN quest ON qna.quest_key = quest.quest_key)
INNER JOIN ans ON qna.ans_key = ans.ans_key)
;

-- 응답자의 번호와 이름을 불러오는 쿼리문
SELECT id, name
FROM response
;

-- 응답자의 번호를 통해 해당 응답자의 문항과 답변을 불러오는 쿼리문
SELECT quest.question, ans.answer
FROM ((((response
INNER JOIN res_q ON response.id = res_q.id)
INNER JOIN qna ON res_q.qna_key = qna.qna_key)
INNER JOIN quest ON qna.quest_key = quest.quest_key)
INNER JOIN ans ON qna.ans_key = ans.ans_key)
WHERE response.id = 1
;
