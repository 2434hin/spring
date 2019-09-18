package kr.or.ddit.mvc.model;

import java.util.List;

public class Main {
	
	private List<String> userId;	// input name = userId
	private Addr addr;				// input name = addr.addr1
	
	private List<Addr> addrList;

	public List<String> getUserId() {
		return userId;
	}

	public void setUserId(List<String> userId) {
		this.userId = userId;
	}

	public Addr getAddr() {
		return addr;
	}

	public void setAddr(Addr addr) {
		this.addr = addr;
	}

	public List<Addr> getAddrList() {
		return addrList;
	}

	public void setAddrList(List<Addr> addrList) {
		this.addrList = addrList;
	}

	@Override
	public String toString() {
		return "Main [userId=" + userId + ", addr=" + addr + ", addrList=" + addrList + "]";
	}

}
