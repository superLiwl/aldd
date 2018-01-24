package ${package}.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "${tableName}")
public class ${className} implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(unique = true, nullable = false, length = 36, name = "id")
	private String id;

<#list table.columns as column>
	/**
	 * ${column.label}
	 */
	@Column(nullable = false, length = ${column.length}, name = "${column.dbName}")
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
