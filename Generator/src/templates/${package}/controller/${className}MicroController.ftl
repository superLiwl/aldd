package ${package}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aldd.vape.common.DataMessage;
import ${package}.domain.${className};
import ${package}.service.${className}Service;
import ${package}.vo.${className}Vo;

@RestController
@RequestMapping(value = "/${classNameLower}/micro")
public class ${className}MicroController {
	@Autowired
	private ${className}Service ${classNameLower}Service;

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public DataMessage add${className}(@RequestBody ${className} ${classNameLower}) {
		return DataMessage.createSuccessMsg(${classNameLower}Service.add${className}(${classNameLower}), "创建成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public DataMessage update${className}(@RequestBody ${className} ${classNameLower}) {
		return DataMessage.createSuccessMsg(${classNameLower}Service.update${className}(${classNameLower}), "更新成功", "");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public DataMessage find${className}ById(@PathVariable("id") String id) {
		return DataMessage.createSuccessMsg(${classNameLower}Service.find${className}ById(id), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{pageNum}/{pageSize}")
	public DataMessage find${className}List(@RequestBody ${className}Vo ${classNameLower}Vo, @PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize") Integer pageSize) {
		return DataMessage.createSuccessMsg(${classNameLower}Service.find${className}List(${classNameLower}Vo, pageNum, pageSize), "查询成功", "");
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public DataMessage delete${className}ById(@PathVariable("id") String id) {
		${classNameLower}Service.delete${className}ById(id);
		return DataMessage.createSuccessMsg(true, "删除成功", "");
	}

}
