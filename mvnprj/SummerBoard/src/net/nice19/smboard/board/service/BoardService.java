package net.nice19.smboard.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import net.nice19.smboard.board.dao.BoardDao;
import net.nice19.smboard.board.model.BoardCommentModel;
import net.nice19.smboard.board.model.BoardModel;
import net.nice19.smboard.board.model.AlarmModel;

public class BoardService implements BoardDao {//객체지향형이라 이렇게 서비스로 빼놓고 여러곳에서 가져다쓰는것 컨트롤러에서 직접안만들고
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	private HashMap<String, Object> valueMap = new HashMap<String, Object>();//값이여러개면 이렇게 맵을이용하자
		
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}
	@Override
	public List<BoardModel> getBoardList(int startArticleNum, int endArticleNum) {//리스트
		valueMap.put("startArticleNum", startArticleNum);
		valueMap.put("endArticleNum", endArticleNum);
		return sqlMapClientTemplate.queryForList("board.getBoardList", valueMap);
	}
	
	@Override
	public List<BoardModel> searchArticle(String type, String keyword, int startArticleNum, int endArticleNum) {
		valueMap.put("type", type);
		valueMap.put("keyword", keyword);
		valueMap.put("startArticleNum", startArticleNum);
		valueMap.put("endArticleNum", endArticleNum);
		return sqlMapClientTemplate.queryForList("board.searchArticle", valueMap);//검색포함
	}
	@Override
	public BoardModel getOneArticle(int idx) {//한줄
		return (BoardModel) sqlMapClientTemplate.queryForObject("board.getOneArticle", idx);
	}
	@Override
	public int getTotalNum() {//입력된행의수
		return (Integer) sqlMapClientTemplate.queryForObject("board.getTotalNum");
	}

	@Override
	public int getSearchTotalNum(String type, String keyword) {
		valueMap.put("type", type);
		valueMap.put("keyword", keyword);
		return (Integer) sqlMapClientTemplate.queryForObject("board.getSearchTotalNum", valueMap);
	}
	@Override
	public List<BoardCommentModel> getCommentList(int idx) {//게시물의 글번호
		return sqlMapClientTemplate.queryForList("board.getCommentList", idx);
	}
	@Override
	public boolean writeArticle(BoardModel board) {//글입력
		sqlMapClientTemplate.insert("board.writeArticle", board);		
		return true;
	}
	@Override
	public boolean writeComment(BoardCommentModel comment) {//댓글입력
		sqlMapClientTemplate.insert("board.writeComment", comment);
		return true;
	}
	@Override
	public void updateHitcount(int hitcount, int idx) {
		valueMap.put("hitcount", hitcount);
		valueMap.put("idx", idx);
		sqlMapClientTemplate.update("board.updateHitcount", valueMap);		
	}
	@Override
	public void updateRecommendCount(int recommendcount, int idx) {
		valueMap.put("recommendcount", recommendcount);
		valueMap.put("idx", idx);
		sqlMapClientTemplate.update("board.updateRecommendcount", valueMap);
	}
	@Override
	public void deleteComment(int idx) {
		sqlMapClientTemplate.delete("board.deleteComment", idx);
	}
	@Override
	public void deleteArticle(int idx) {//게시물삭제
		sqlMapClientTemplate.delete("board.deleteArticle", idx);	
	}
	@Override
	public BoardCommentModel getOneComment(int idx) {//글번호에 해당되는 댓글에대한정보//삭제할때비밀번호 확인하기위해
		return (BoardCommentModel) sqlMapClientTemplate.queryForObject("board.getOneComment", idx);		
	}
	@Override
	public boolean modifyArticle(BoardModel board) {
		sqlMapClientTemplate.update("board.modifyArticle", board);
		return true;
	}
	public void push(int idx) {
		sqlMapClientTemplate.update("board.updatePush", idx);
	}
	public void pushinsert(AlarmModel alarm) {//알람 입력
		sqlMapClientTemplate.insert("board.pushinsert", alarm);
	}
	public void BackPush(int idx) {
		sqlMapClientTemplate.update("board.BackPush", idx);
	}
	public void deleteAlarm(int alarmidx) {
		sqlMapClientTemplate.update("board.deleteAlarm", alarmidx);
	}
	@Override
	public List<BoardModel> getPush(String userId) {//한줄
		return sqlMapClientTemplate.queryForList("board.getPush", userId);
	}
	public List<AlarmModel> getAlarm(String userId) {//한줄
		return sqlMapClientTemplate.queryForList("board.getAlarm", userId);
	}
}