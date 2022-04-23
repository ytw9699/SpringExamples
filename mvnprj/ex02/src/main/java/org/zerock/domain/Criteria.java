package org.zerock.domain;
	import org.springframework.web.util.UriComponentsBuilder;
	import lombok.Getter;
	import lombok.Setter;
	import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {//349페이지 나중에다시봐보자

	private int pageNum;
	private int amount;

	private String type;
	private String keyword;

	public Criteria() {
		this(1, 10);
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public String[] getTypeArr() {

		return type == null ? new String[] {} : type.split("");//null이면 배열 빈값을 줘서 마이바티스 동적 쿼리에서 if문을 안줘도 된다.
	}

	public String getListLink() {// 이렇게 url을 붙이는 방법도 있다.

		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());

		return builder.toUriString();
	}
}
