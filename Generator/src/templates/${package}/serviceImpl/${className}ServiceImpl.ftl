package ${package}.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import ${package}.domain.${className};
import ${package}.repository.jpa.${className}Repository;
import ${package}.repository.mybatis.dao.${className}Dao;
import ${package}.service.${className}Service;
import ${package}.vo.${className}Vo;

@Service("${classNameLower}Service")
public class ${className}ServiceImpl implements ${className}Service {

	@Autowired
	private ${className}Dao ${classNameLower}Dao;
	@Autowired
	private ${className}Repository ${classNameLower}Repository;

	@Override
	public ${className} add${className}(${className} ${classNameLower}) {
		${classNameLower}.setCreateTime(new Date());
		${classNameLower}.setUpdateTime(new Date());
		${classNameLower} = ${classNameLower}Repository.save(${classNameLower});
		return ${classNameLower};
	}

	@Override
	public ${className} update${className}(${className} ${classNameLower}) {
		${classNameLower}.setUpdateTime(new Date());
		${classNameLower} = ${classNameLower}Repository.save(${classNameLower});
		return ${classNameLower};
	}

	@Override
	public ${className}Vo find${className}ById(String id) {
		return ${classNameLower}Dao.find${className}ById(id);
	}

	@Override
	public List<${className}Vo> find${className}List(${className}Vo ${classNameLower}Vo) {
		PageHelper.startPage(${classNameLower}Vo.getPageNum(), ${classNameLower}Vo.getPageSize());
		List<${className}Vo> result = ${classNameLower}Dao.find${className}List(${classNameLower}Vo);
		return result;
	}

	@Override
	public void delete${className}ById(String id) {
		${classNameLower}Repository.delete(id);
	}

}