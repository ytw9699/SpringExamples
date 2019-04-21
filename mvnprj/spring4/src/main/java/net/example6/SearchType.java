package net.example6;
public class SearchType {
	private int code;
	private String text;
/*	options.add(new SearchType(1, "전체"));
	options.add(new SearchType(2, "아이템"));
	options.add(new SearchType(3, "캐릭터"));*/

	public SearchType(int code, String text) {
		this.code = code;
		this.text = text;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}