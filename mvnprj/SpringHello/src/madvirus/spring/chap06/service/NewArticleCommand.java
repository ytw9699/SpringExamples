package madvirus.spring.chap06.service;

public class NewArticleCommand { //자바빈

	private String title;
	private String content;
	private int parentId;//get방식과 post방식으로 전송되면 스트링으로 전송되는데
	//int타입도 이렇게 자동변환해서 저장 가능!인티저점.파스인트 할필요없음, 기본데이터타입안에서만

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