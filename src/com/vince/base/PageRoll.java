package com.vince.base;
/**
 * ��ҳ�齨
 * @author syh
 *
 */
public class PageRoll {
	private int currPage = 1; //��ǰҳ
	private int pageSize = 5; //ÿҳ�ļ�¼��
	private int pageCount; //��ҳ��
	private int tatalCount; //�ܼ�¼��
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
	//��ҳ��
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
