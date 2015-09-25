package com.vince.base;
/**
 * 分页组建
 * @author syh
 *
 */
public class PageRoll {
	private int currPage = 1; //当前页
	private int pageSize = 5; //每页的记录数
	private int pageCount; //总页数
	private int tatalCount; //总记录数
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	//总页数
	public int getPageCount() {
		if(tatalCount % pageSize==0){
			pageCount = tatalCount/pageSize;
		}else{
			pageCount = tatalCount/pageSize+1;
		}
		return pageCount;
	}
	
	public int getTatalCount() {
		return tatalCount;
	}
	public void setTatalCount(int tatalCount) {
		this.tatalCount = tatalCount;
	}
	
	
}
