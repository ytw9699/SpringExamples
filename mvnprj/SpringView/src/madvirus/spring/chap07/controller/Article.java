package madvirus.spring.chap07.controller;

public class Article {

	private Integer id;
	
	public Article(Integer id) {
		this.id = id;
	}

	public Article() {//?질문이건뭐지
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
