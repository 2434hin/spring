package kr.or.ddit.common.model;

public class Page {
	private int page;
	private int pagesize;

	public Page() {}

	public Page(int page, int papagesize) {
		this.page = page;
		this.pagesize = papagesize;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}


}
