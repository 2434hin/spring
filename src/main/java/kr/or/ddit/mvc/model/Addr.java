package kr.or.ddit.mvc.model;

public class Addr {

	private String addr1;	// 도로 주소
	private String addr2;	// 상세 주소
	
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	
	@Override
	public String toString() {
		return "Addr [addr1=" + addr1 + ", addr2=" + addr2 + "]";
	}
	
}
