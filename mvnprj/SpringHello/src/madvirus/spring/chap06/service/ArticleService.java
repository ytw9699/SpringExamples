package madvirus.spring.chap06.service;

	public class ArticleService {//mvc�����̶� �𵨴� �̷��� ����

		public void writeArticle(NewArticleCommand command) {
			//�������� �ڹٺ� ��ü�޾Ƽ� �ֿܼ����
			System.out.println("�ű� �Խñ� ���: " + command);
		}
	}