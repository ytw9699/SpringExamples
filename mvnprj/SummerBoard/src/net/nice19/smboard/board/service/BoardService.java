package net.nice19.smboard.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import net.nice19.smboard.board.dao.BoardDao;
import net.nice19.smboard.board.model.BoardCommentModel;
import net.nice19.smboard.board.model.BoardModel;
import net.nice19.smboard.board.model.AlarmModel;

public class BoardService implements BoardDao {//��ü�������̶� �̷��� ���񽺷� ������ ���������� �����پ��°� ��Ʈ�ѷ����� �����ȸ����
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	private HashMap<String, Object> valueMap = new HashMap<String, Object>();//���̿������� �̷��� �����̿�����
		
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}
	@Override
	public List<BoardModel> getBoardList(int startArticleNum, int endArticleNum) {//����Ʈ
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
		return sqlMapClientTemplate.queryForList("board.searchArticle", valueMap);//�˻�����
	}
	@Override
	public BoardModel getOneArticle(int idx) {//����
		return (BoardModel) sqlMapClientTemplate.queryForObject("board.getOneArticle", idx);
	}
	@Override
	public int getTotalNum() {//�Էµ����Ǽ�
		return (Integer) sqlMapClientTemplate.queryForObject("board.getTotalNum");
	}

	@Override
	public int getSearchTotalNum(String type, String keyword) {
		valueMap.put("type", type);
		valueMap.put("keyword", keyword);
		return (Integer) sqlMapClientTemplate.queryForObject("board.getSearchTotalNum", valueMap);
	}
	@Override
	public List<BoardCommentModel> getCommentList(int idx) {//�Խù��� �۹�ȣ
		return sqlMapClientTemplate.queryForList("board.getCommentList", idx);
	}
	@Override
	public boolean writeArticle(BoardModel board) {//���Է�
		sqlMapClientTemplate.insert("board.writeArticle", board);		
		return true;
	}
	@Override
	public boolean writeComment(BoardCommentModel comment) {//����Է�
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
	public void deleteArticle(int idx) {//�Խù�����
		sqlMapClientTemplate.delete("board.deleteArticle", idx);	
	}
	@Override
	public BoardCommentModel getOneComment(int idx) {//�۹�ȣ�� �ش�Ǵ� ��ۿ���������//�����Ҷ���й�ȣ Ȯ���ϱ�����
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
	public void pushinsert(AlarmModel alarm) {//�˶� �Է�
		sqlMapClientTemplate.insert("board.pushinsert", alarm);
	}
	public void BackPush(int idx) {
		sqlMapClientTemplate.update("board.BackPush", idx);
	}
	public void deleteAlarm(int alarmidx) {
		sqlMapClientTemplate.update("board.deleteAlarm", alarmidx);
	}
	@Override
	public List<BoardModel> getPush(String userId) {//����
		return sqlMapClientTemplate.queryForList("board.getPush", userId);
	}
	public List<AlarmModel> getAlarm(String userId) {//����
		return sqlMapClientTemplate.queryForList("board.getAlarm", userId);
	}
}