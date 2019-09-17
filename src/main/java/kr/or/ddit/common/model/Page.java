package kr.or.ddit.common.model;

public class Page {
	private int page;
	private int pagesize;
	private String no;

	public Page() {}

	public Page(int page, int papagesize) {
		this.page = page;
		this.pagesize = papagesize;
	}

	public int getPage() {
		return page == 0 ? 1 : page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		if(no == null)
			return pagesize == 0 ? 10 : pagesize;
		else
			return pagesize == 0 ? 5 : pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	@Override
	public String toString() {
		return "Page [page=" + page + ", pagesize=" + pagesize + "]";
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
}
