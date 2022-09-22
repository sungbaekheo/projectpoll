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
-- 특정 문항의 답항별 갯수를 가져오는 쿼리
SELECT ans.answer, COUNT(ans.ans_key) as count
FROM ((((response
INNER JOIN res_q ON response.id = res_q.id)
INNER JOIN qna ON res_q.qna_key = qna.qna_key)
INNER JOIN quest ON qna.quest_key = quest.quest_key)
INNER JOIN ans ON qna.ans_key = ans.ans_key)
WHERE quest.quest_key = 1 and ans.ans_key = 4
;

-- 답변 내용 가져오는 쿼리
SELECT answer FROM ans
WHERE ans_key = 5
;

-- 문항과 답변에 따른 응답 갯수 받아오는 쿼리
SELECT COUNT(ans.ans_key)
FROM ((((response
INNER JOIN res_q ON response.id = res_q.id)
INNER JOIN qna ON res_q.qna_key = qna.qna_key)
INNER JOIN quest ON qna.quest_key = quest.quest_key)
INNER JOIN ans ON qna.ans_key = ans.ans_key)
where quest.quest_key = 2 and ans.ans_key = 5
;

SELECT question FROM quest
WHERE quest_key = 1;