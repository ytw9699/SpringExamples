package madvirus.spring.chap06.service;

public class NewArticleCommand { //�ڹٺ�

	private String title;
	private String content;
	private int parentId;//get��İ� post������� ���۵Ǹ� ��Ʈ������ ���۵Ǵµ�
	//intŸ�Ե� �̷��� �ڵ���ȯ�ؼ� ���� ����!��Ƽ����.�Ľ���Ʈ ���ʿ����, �⺻������Ÿ�Ծȿ�����

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "NewArticleCommand toString [content=" + content + ", parentId="
				+ parentId + ", title=" + title + "]";
	}			
}