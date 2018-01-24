package ${package}.service;

import java.util.List;

import ${package}.domain.${className};
import ${package}.vo.${className}Vo;


public interface ${className}Service {
	

	${className} add${className}(${className} ${classNameLower});

	${className} update${className}(${className} ${classNameLower});

	${className}Vo find${className}ById(String id);

	List<${className}Vo> find${className}List(${className}Vo ${classNameLower}Vo);

	void delete${className}ById(String id);
	
}
