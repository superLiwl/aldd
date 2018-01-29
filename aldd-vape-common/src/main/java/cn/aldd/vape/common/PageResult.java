package cn.aldd.vape.common;

import java.util.List;

public class PageResult<T> {
	/**
	 * 当前页
	 */
	private int pageNum;

	/**
	 * 每页显示行数
	 */
	private int pageSize;

	/**
	 * 总条数
	 */
	private long total;

	/**
	 * 总页数
	 */
	private int pages;

	/**
	 * 内容
	 */
	private List<T> list;

	/**
	 * 是否第一页
	 */
	private boolean isFirstPage;

	/**
	 * 是否最后一页
	 */
	private boolean isLastPage;

	public PageResult() {
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public void setFirstPage(boolean firstPage) {
		isFirstPage = firstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public void setLastPage(boolean lastPage) {
		isLastPage = lastPage;
	}
}
