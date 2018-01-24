package ${package}.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.aldd.vape.common.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class ${className}Vo extends Page {

	private static final long serialVersionUID = 1L;
	
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	<#list table.columns as column>
	@ApiModelProperty(value = "${column.label}")
	private ${column.type} ${column.name};
</#list>

// setter and getter
<#list table.columns as column>
	public ${column.type} get${column.nameUpper}(){
		return ${column.name};
	}
	
	public void set${column.nameUpper}(${column.type} ${column.name}){
		this.${column.name} = ${column.name};
	}
</#list>
	
}