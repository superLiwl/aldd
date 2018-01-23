package cn.aldd.vape.common;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class Page implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "每页显示数")
	private Integer pageSize;

	@ApiModelProperty(value = "页码")
	private Integer pageNum;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

}
