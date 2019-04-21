package net.example14;

import java.util.List;

public class CheckboxModel {

	private String[] pet;
	private List<String> pet2;
	private boolean pet3;

	public boolean isPet3() {
		return pet3;
	}
	public void setPet3(boolean pet3) {
		this.pet3 = pet3;
	}
	public String[] getPet() {
		return pet;
	}
	public void setPet(String[] pet) {
		this.pet = pet;
	}
	public List<String> getPet2() {
		return pet2;
	}
	public void setPet2(List<String> pet2) {
		this.pet2 = pet2;
	}
	
}
