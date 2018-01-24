package ${package}.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ${package}.domain.${className};
import ${package}.service.${className}Service;
import ${package}.vo.${className}Vo;

@RestController
public class ${className}MicroController {
	@Autowired
	private ${className}Service ${classNameLower}Service;

	@RequestMapping(method = RequestMethod.POST, value = "/${classNameLower}/micro/add${className}")
	public ${className} add${className}(@RequestBody ${className} ${classNameLower}) {
		return ${classNameLower}Service.add${className}(${classNameLower});
	}

	@RequestMapping(method = RequestMethod.POST, value = "/${classNameLower}/micro/update${className}")
	public ${className} update${className}(@RequestBody ${className} ${classNameLower}) {
		return ${classNameLower}Service.update${className}(${classNameLower});
	}

	@RequestMapping(method = RequestMethod.GET, value = "/${classNameLower}/micro/{id}")
	public ${className}Vo find${className}ById(@PathVariable("id") String id) {
		return ${classNameLower}Service.find${className}ById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/${classNameLower}/micro/find${className}List")
	public List<${className}Vo> find${className}List(@RequestBody ${className}Vo ${classNameLower}Vo) {
		return ${classNameLower}Service.find${className}List(${classNameLower}Vo);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/${classNameLower}/micro/{id}")
	public void delete${className}ById(@PathVariable("id") String id) {
		${classNameLower}Service.delete${className}ById(id);
	}

}
