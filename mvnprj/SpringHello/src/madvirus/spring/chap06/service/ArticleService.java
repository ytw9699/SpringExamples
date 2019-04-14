package madvirus.spring.chap06.service;

	public class ArticleService {//mvc패턴이라 모델단 이렇게 만듬

		public void writeArticle(NewArticleCommand command) {
			//내가만든 자바빈 객체받아서 콘솔에출력
			System.out.println("신규 게시글 등록: " + command);
		}
	}