package ${package}.service;

import com.github.pagehelper.PageInfo;

import ${package}.domain.${className};
import ${package}.vo.${className}Vo;

public interface ${className}Service {

	${className} add${className}(${className} ${classNameLower});

	${className} update${className}(${className} ${classNameLower});

	${className}Vo find${className}ById(String id);

	PageInfo<${className}Vo> find${className}List(${className}Vo ${classNameLower}Vo, Integer pageNum, Integer pageSize);

	void delete${className}ById(String id);

}
