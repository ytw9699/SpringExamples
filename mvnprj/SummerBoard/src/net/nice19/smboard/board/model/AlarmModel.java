package net.nice19.smboard.board.model;

public class AlarmModel {
	private int idx;
	private String showhide;
	private String kind;
	private String id;
	private int productnumber;
	private int ordernumber;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getShowhide() {
		return showhide;
	}
	public void setShowhide(String showhide) {
		this.showhide = showhide;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getProductnumber() {
		return productnumber;
	}
	public void setProductnumber(int productnumber) {
		this.productnumber = productnumber;
	}
	public int getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}
}
