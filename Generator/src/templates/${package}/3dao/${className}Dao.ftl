package ${package}.repository.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ${package}.vo.${className}Vo;

@Mapper
public interface ${className}Dao {

	${className}Vo find${className}ById(@Param("id") String id);

	List<${className}Vo> find${className}List(@Param("entity") ${className}Vo ${classNameLower}Vo);

}
