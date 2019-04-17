package net.nice19.smboard.board.dao;
import java.util.List;
import net.nice19.smboard.board.model.BoardCommentModel;
import net.nice19.smboard.board.model.BoardModel;

public interface BoardDao {//db단 작업해야할 메소드들
// get all contents in JMBoard table
List<BoardModel> getBoardList(int startArticleNum, int showArticleLimit);
//몇번째줄부터 몇번째줄까지 데이터를 가져오느 메소드

// show detail about selected article
BoardModel getOneArticle(int idx);//한줄

// get search result list
List<BoardModel> searchArticle(String type, String keyword, int startArticleNum, int endArticleNum);
//검색까지해서가져오는거

// get all comments
List<BoardCommentModel> getCommentList(int idx);//댓글의 리스트

// get a comment
BoardCommentModel getOneComment(int idx);//댓글 한줄

// modify(update) article
boolean modifyArticle(BoardModel board);//게시글 수정

// insert article data
boolean writeArticle(BoardModel board);//게시글 입력

// insert comment data
boolean writeComment(BoardCommentModel comment);//댓글입력

// update hitcount
void updateHitcount(int hitcount, int idx);//조회수 증가

// update recommendcount
void updateRecommendCount(int recommendcount, int idx);//추천수 업데이트

// get contents count
int getTotalNum();//입력된행의수

// get count of search results
int getSearchTotalNum(String type, String keyword);//검색으로 입력되는행의수

// delete a comment
void deleteComment(int idx);//댓글을 삭제

// delete a article
void deleteArticle(int idx);//게시글 삭제

List<BoardModel> getPush(String userId);
}