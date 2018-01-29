package ${package}.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class ${className}Vo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	<#list table.columns as column>
	<#if column.type != "String">
	@ApiModelProperty(value = "${column.label}")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	<#else>
	@ApiModelProperty(value = "${column.label}")
	</#if>
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