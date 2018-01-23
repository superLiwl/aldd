package cn.aldd.vape.user.micro.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(unique = true, nullable = false, length = 36, name = "id")
	private String id;

	/**
	 * 登录名
	 */
	@Column(nullable = false, length = 50, name = "login_name")
	private String loginName;

	/**
	 * 密码
	 */
	@Column(nullable = false, length = 255, name = "password")
	private String password;
	/**
	 * 创建时间
	 */
	@Column(nullable = true, name = "create_time")
	private java.util.Date createTime;
	/**
	 * 更新时间
	 */
	@Column(nullable = true, name = "update_time")
	private java.util.Date updateTime;
	/**
	 * 头像
	 */
	@Column(nullable = true, length = 200, name = "head_portrait_img")
	private String headPortraitImg;
	/**
	 * 昵称
	 */
	@Column(nullable = true, length = 50, name = "nick_name")
	private String nickName;
	/**
	 * 性别
	 */
	@Column(nullable = true, length = 50, name = "gender")
	private String gender;
	/**
	 * 地址
	 */
	@Column(nullable = true, length = 100, name = "address")
	private String address;
	/**
	 * 年龄
	 */
	@Column(nullable = true, length = 50, name = "age")
	private String age;
	/**
	 * 代号
	 */
	@Column(nullable = true, length = 50, name = "code")
	private String code;
	/**
	 * 技能
	 */
	@Column(nullable = true, length = 200, name = "skill")
	private String skill;
	/**
	 * 爱好
	 */
	@Column(nullable = true, length = 200, name = "hobby")
	private String hobby;
	/**
	 * 个人签名
	 */
	@Column(nullable = true, length = 200, name = "signature")
	private String signature;
	/**
	 * 我的口粮
	 */
	@Column(nullable = true, length = 50, name = "ration")
	private String ration;
	/**
	 * 我的设备
	 */
	@Column(nullable = true, length = 200, name = "equipment")
	private String equipment;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getHeadPortraitImg() {
		return headPortraitImg;
	}

	public void setHeadPortraitImg(String headPortraitImg) {
		this.headPortraitImg = headPortraitImg;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getRation() {
		return ration;
	}

	public void setRation(String ration) {
		this.ration = ration;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

}
