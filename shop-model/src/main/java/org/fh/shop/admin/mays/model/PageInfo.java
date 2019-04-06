package org.fh.shop.admin.mays.model;

import java.util.Date;

public class PageInfo {
	//总条数
	private long  totalCount;
	//总页数
	private long pageCount;
	//每页的条数
	private Long pageSize = 5L;
	//当前页
	private long pageIndex = 1;
	//起始位置
	private Long startPos;
	//终止位置
	private long endPos;

	//bootstrap 传过来的字段
	private Long draw;
	private Long start;
	private Long length;

	//排序字段
	private String filed;
	private String orderby;
	
	
	private Date createTime;
	private Date updateTime;
//	录入时间范围查询
	private Date minCreateTime;
	private Date maxCreateTime;
//	修改时间范围查询
	private Date minUpdateTime;
	private Date maxUpdateTime;
	//计算分页信息
	public void calculatePage(){
		//获取总页数
		if(totalCount % pageSize ==0){
			pageCount = totalCount / pageSize;
		}else{
			pageCount = totalCount / pageSize + 1;
		}
		// 1 0 5 >0 <=5
		// 2 5 10 >5 <=10
		// 3 10 15 >10 <=15
		startPos = ( pageIndex - 1 ) * pageSize;
		endPos = pageIndex * pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public long getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(long pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Long getStartPos() {
		return startPos;
	}

	public void setStartPos(Long startPos) {
		this.startPos = startPos;
	}

	public long getEndPos() {
		return endPos;
	}

	public void setEndPos(long endPos) {
		this.endPos = endPos;
	}

	public Long getDraw() {
		return draw;
	}

	public void setDraw(Long draw) {
		this.draw = draw;
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
		this.startPos = start;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
		this.pageSize = length;
	}

	public String getFiled() {
		return filed;
	}

	public void setFiled(String filed) {
		this.filed = filed;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getMinCreateTime() {
		return minCreateTime;
	}

	public void setMinCreateTime(Date minCreateTime) {
		this.minCreateTime = minCreateTime;
	}

	public Date getMaxCreateTime() {
		return maxCreateTime;
	}

	public void setMaxCreateTime(Date maxCreateTime) {
		this.maxCreateTime = maxCreateTime;
	}

	public Date getMinUpdateTime() {
		return minUpdateTime;
	}

	public void setMinUpdateTime(Date minUpdateTime) {
		this.minUpdateTime = minUpdateTime;
	}

	public Date getMaxUpdateTime() {
		return maxUpdateTime;
	}

	public void setMaxUpdateTime(Date maxUpdateTime) {
		this.maxUpdateTime = maxUpdateTime;
	}
}
