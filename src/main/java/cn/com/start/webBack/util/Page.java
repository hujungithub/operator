package cn.com.start.webBack.util;

import java.util.List;

/**
 * 分页
 */
public class Page {
	public static void main(String[] args) {
		Page zzPage = new Page(1000, 20, 5);
		System.out.println(zzPage.getTotalPageCount());
	}
	
	private int pageNow; // 当前页数   3

	private int pageSize;// 每页显示记录的条数 30
 
	private int totalCount; // 总的记录条数 1000条记录  

	private int totalPageCount; // 总的页数 计算总共50页 

	private List list;
	
	private int startPos; // 开始位置，从0开始 拿到之后-1 limit 1,5 (2 3 4 5 6)

	private List addList;

	private String json;
	
	private String Header;

	/**
	 * 通过构造函数 传入 总记录数 和 当前页
	 * 
	 * @param totalCount
	 * @param pageNow
	 */
	public Page(int totalCount, int PageSize, int PageNow) {
		this.totalCount = totalCount; // 1000条记录
		this.pageSize = PageSize; // 每页50条
		this.pageNow = PageNow; // 现在第10页
	}
	
	public Page() {}

	public String getHeader() {
		return Header;
	}

	public void setHeader(String header) {
		Header = header;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	// 通过总记录数和每页条数 求总页数
	public int getTotalPageCount() {
		int temp = totalCount / pageSize;
		if (totalCount % pageSize != 0) {
			temp += 1;
		}
		this.setTotalPageCount(temp);
		return temp;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	// 计算开始位置
	public int getStartPos() {
		int temp = (pageNow - 1) * pageSize;
		this.setStartPos(temp);
		return temp;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public List getAddList() {
		return addList;
	}

	public void setAddList(List addList) {
		this.addList = addList;
	}

	@Override
	public String toString() {
		return "Page [pageNow=" + pageNow + ", pageSize=" + pageSize
				+ ", totalCount=" + totalCount + ", totalPageCount="
				+ totalPageCount + ", startPos=" + startPos + ", list=" + list
				+ ", addList=" + addList + "]";
	}
}