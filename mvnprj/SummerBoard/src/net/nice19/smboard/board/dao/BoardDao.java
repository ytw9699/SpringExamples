package net.nice19.smboard.board.dao;
import java.util.List;
import net.nice19.smboard.board.model.BoardCommentModel;
import net.nice19.smboard.board.model.BoardModel;

public interface BoardDao {//db�� �۾��ؾ��� �޼ҵ��
// get all contents in JMBoard table
List<BoardModel> getBoardList(int startArticleNum, int showArticleLimit);
//���°�ٺ��� ���°�ٱ��� �����͸� �������� �޼ҵ�

// show detail about selected article
BoardModel getOneArticle(int idx);//����

// get search result list
List<BoardModel> searchArticle(String type, String keyword, int startArticleNum, int endArticleNum);
//�˻������ؼ��������°�

// get all comments
List<BoardCommentModel> getCommentList(int idx);//����� ����Ʈ

// get a comment
BoardCommentModel getOneComment(int idx);//��� ����

// modify(update) article
boolean modifyArticle(BoardModel board);//�Խñ� ����

// insert article data
boolean writeArticle(BoardModel board);//�Խñ� �Է�

// insert comment data
boolean writeComment(BoardCommentModel comment);//����Է�

// update hitcount
void updateHitcount(int hitcount, int idx);//��ȸ�� ����

// update recommendcount
void updateRecommendCount(int recommendcount, int idx);//��õ�� ������Ʈ

// get contents count
int getTotalNum();//�Էµ����Ǽ�

// get count of search results
int getSearchTotalNum(String type, String keyword);//�˻����� �ԷµǴ����Ǽ�

// delete a comment
void deleteComment(int idx);//����� ����

// delete a article
void deleteArticle(int idx);//�Խñ� ����

List<BoardModel> getPush(String userId);
}