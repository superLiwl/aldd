package cn.aldd.vape.util;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * All rights Reserved, Designed By 翼虎能源
 * Copyright:    Copyright(C) 2015-2015
 * Company   北京翼虎能源科技有限公司
 *
 * @author 刘广路
 * @version 1.0
 * @date 2015/9/26 12:39
 * @Description 反射工具类
 */
public class ReflectionUtils {

	private final static Log logger = LogFactory.getLog(ReflectionUtils.class);

	/**
	 * 通过反射, 获得定义 Class 时声明的父类的泛型参数的类型 如: public EmployeeDao extends
	 * BaseDao<Employee, String>
	 *
	 * @param clazz
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Class getSuperClassGenricType(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			logger.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			logger.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: "
					+ params.length);
			return Object.class;
		}

		if (!(params[index] instanceof Class)) {
			logger.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
			return Object.class;
		}

		return (Class) params[index];
	}

	/**
	 * 通过反射, 获得 Class 定义中声明的父类的泛型参数类型 如: public EmployeeDao extends
	 * BaseDao<Employee, String>
	 *
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getSuperGenericType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * 循环向上转型, 获取对象的 DeclaredMethod
	 *
	 * @param object         : 子类对象
	 * @param methodName     : 父类中的方法名
	 * @param parameterTypes : 父类中的方法参数类型
	 * @return 父类中的方法对象
	 */

	public static Method getDeclaredMethod(Object object, String methodName, Class<?>... parameterTypes) {
		Method method = null;

		for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				method = clazz.getDeclaredMethod(methodName, parameterTypes);
				return method;
			} catch (Exception e) {
				//这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
				//如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
			}
		}

		return null;
	}

	/**
	 * 直接调用对象方法, 而忽略修饰符(private, protected, default)
	 *
	 * @param object         : 子类对象
	 * @param methodName     : 父类中的方法名
	 * @param parameterTypes : 父类中的方法参数类型
	 * @param parameters     : 父类中的方法参数
	 * @return 父类中方法的执行结果
	 */

	public static Object invokeMethod(Object object, String methodName, Class<?>[] parameterTypes,
			Object[] parameters) {
		//根据 对象、方法名和对应的方法参数 通过反射 调用上面的方法获取 Method 对象
		Method method = getDeclaredMethod(object, methodName, parameterTypes);
		try {
			if (null != method) {
				//抑制Java对方法进行检查,主要是针对私有方法而言
				method.setAccessible(true);

				//调用object 的 method 所代表的方法，其方法的参数是 parameters
				return method.invoke(object, parameters);
			}
		} catch (IllegalArgumentException e) {
			logger.error("invokeMethod  IllegalArgumentException", e);
		} catch (IllegalAccessException e) {
			logger.error("invokeMethod  IllegalAccessException", e);
		} catch (InvocationTargetException e) {
			logger.error("invokeMethod  InvocationTargetException", e);
		}

		return null;
	}

	/**
	 * 循环向上转型, 获取对象的 DeclaredField
	 *
	 * @param object    : 子类对象
	 * @param fieldName : 父类中的属性名
	 * @return 父类中的属性对象
	 */

	public static Field getDeclaredField(Object object, String fieldName) {
		Field field = null;

		Class<?> clazz = object.getClass();

		for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				field = clazz.getDeclaredField(fieldName);
				return field;
			} catch (Exception e) {
				//这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
				//如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
			}
		}

		return null;
	}

	/**
	 * 直接设置对象属性值, 忽略 private/protected 修饰符, 也不经过 setter
	 *
	 * @param object    : 子类对象
	 * @param fieldName : 父类中的属性名
	 * @param value     : 将要设置的值
	 */

	public static void setFieldValue(Object object, String fieldName, Object value) {

		//根据 对象和属性名通过反射 调用上面的方法获取 Field对象
		Field field = getDeclaredField(object, fieldName);

		//抑制Java对其的检查
		field.setAccessible(true);

		try {
			//将 object 中 field 所代表的值 设置为 value
			field.set(object, value);
		} catch (IllegalArgumentException e) {
			logger.error("setFieldValue  IllegalArgumentException", e);
		} catch (IllegalAccessException e) {
			logger.error("setFieldValue  IllegalAccessException", e);
		}

	}

	/**
	 * 直接读取对象的属性值, 忽略 private/protected 修饰符, 也不经过 getter
	 *
	 * @param object    : 子类对象
	 * @param fieldName : 父类中的属性名
	 * @return : 父类中的属性值
	 */

	public static Object getFieldValue(Object object, String fieldName) {

		//根据 对象和属性名通过反射 调用上面的方法获取 Field对象
		Field field = getDeclaredField(object, fieldName);

		//抑制Java对其的检查
		field.setAccessible(true);
		try {
			//获取 object 中 field 所代表的属性值
			return field.get(object);
		} catch (Exception e) {
			logger.error("getFieldValue  IllegalAccessException", e);
		}
		return null;
	}

	/**
	 * 将一个对象的属性值赋给另一个对象的相同的属性 这两个对象必须都符合javaBean的标准
	 *
	 * @param source           要赋值的源对象
	 * @param target           被赋值的目标对象
	 * @param ignoreProperties 被忽略赋值的属性数组
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public static void copyProperties(Object source, Object target, List<String> ignoreList) throws Exception {
		Class targetClass = target.getClass();
		Class sourceClass = source.getClass();

		// 得到目标对象和源对象的属性数组
		PropertyDescriptor targetPds[] = Introspector.getBeanInfo(targetClass).getPropertyDescriptors();
		PropertyDescriptor sourcetPds[] = Introspector.getBeanInfo(sourceClass).getPropertyDescriptors();
		//        // 将忽略字段的数组转化为list
		//        List<String> ignoreList = ignoreProperties == null ? null : Arrays
		//                .asList(ignoreProperties);
		// 把源对象的所有属性放的map中
		Map<String, PropertyDescriptor> sourcePropertyMap = new HashMap<String, PropertyDescriptor>();
		for (int i = 0; i < sourcetPds.length; i++) {
			PropertyDescriptor pd = sourcetPds[i];
			sourcePropertyMap.put(pd.getName(), pd);
		}
		for (int i = 0; i < targetPds.length; i++) {
			PropertyDescriptor targetPd = targetPds[i];

			if (targetPd.getWriteMethod() == null || ignoreList != null && ignoreList.contains(targetPd.getName()))
				continue;
			PropertyDescriptor sourcePd = sourcePropertyMap.get(targetPd.getName());
			if (sourcePd == null || sourcePd.getReadMethod() == null)
				continue;
			try {
				// 得到源对象对应的属性值
				Method readMethod = sourcePd.getReadMethod();
				if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers()))
					readMethod.setAccessible(true);
				Object value = readMethod.invoke(source, new Object[0]);
				// 将源对象的属性值赋值给目标对象对应的属性
				Method writeMethod = targetPd.getWriteMethod();
				if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers()))
					writeMethod.setAccessible(true);
				writeMethod.invoke(target, new Object[] { value });
			} catch (Throwable ex) {
				throw new IllegalArgumentException("Could not copy properties from source to target", ex);
			}
		}
	}

	/**
	 * 利用反射获取指定对象里面的指定属性
	 *
	 * @param obj       目标对象
	 * @param fieldName 目标属性
	 * @return 目标字段
	 */
	private static Field getField(Object obj, String fieldName) {
		Field field = null;
		for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				field = clazz.getDeclaredField(fieldName);
				break;
			} catch (NoSuchFieldException e) {
				//这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。
			}
		}
		return field;
	}

	/**
	 * 获取对象字段的类型
	 *
	 * @param obj        目标对象
	 * @param fieldName  目标属性
	 */
	public static Class getFieldType(Object obj, String fieldName) {
		Class clz = null;
		try {
			Field field = ReflectionUtils.getField(obj, fieldName);
			if (field != null) {
				clz = field.getType();
			}
		} catch (IllegalArgumentException e) {
			logger.error("getFieldType  IllegalAccessException", e);
		}
		return clz;
	}

	/**
	 * reModelToMap: 反射将实体中的值都放到map中
	 * @param obj  实体
	 * @return Map<String,Object> map用来做查询条件
	 * @throws Exception Map<String,Object>
	 */
	public static Map<String, Object> reflectionModelToMap(Object obj) throws Exception {
		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Class<?> clazz = obj.getClass();
		for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
//				field = clazz.getDeclaredField(fieldName);
				Field[] fields = clazz.getDeclaredFields();
				for (int j = 0; j < fields.length; j++) {
					fields[j].setAccessible(true);
					// key == 字段名    value == 字段值
					map.put(fields[j].getName(), fields[j].get(obj));
				}
			} catch (Exception e) {
				//这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
				//如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
			}
		}
		return map;
	}
}
