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
	 * wx的openId
	 */
	@Column(nullable = true, length = 255, name = "open_id")
	private String openId;
	/**
	 * 地址
	 */
	@Column(nullable = true, length = 255, name = "address")
	private String address;
	/**
	 * 经度
	 */
	@Column(nullable = true, length = 255, name = "longitude")
	private String longitude;
	/**
	 * 纬度
	 */
	@Column(nullable = true, length = 255, name = "latitude")
	private String latitude;
	/**
	 * 年龄
	 */
	@Column(nullable = true, length = 255, name = "age")
	private String age;
	/**
	 * 编号
	 */
	@Column(nullable = true, length = 255, name = "code")
	private String code;
	/**
	 * 性别
	 */
	@Column(nullable = true, length = 255, name = "gender")
	private String gender;
	/**
	 * 头像
	 */
	@Column(nullable = true, length = 255, name = "head_portrait_img")
	private String headPortraitImg;
	/**
	 * 爱好
	 */
	@Column(nullable = true, length = 255, name = "hobby")
	private String hobby;
	/**
	 * 用户状态（1：启用 2：冻结）
	 */
	@Column(nullable = true, length = 255, name = "status")
	private String status;
	/**
	 * 登录名
	 */
	@Column(nullable = true, length = 255, name = "login_name")
	private String loginName;
	/**
	 * 密码
	 */
	@Column(nullable = true, length = 255, name = "password")
	private String password;
	/**
	 * 昵称
	 */
	@Column(nullable = true, length = 255, name = "nick_name")
	private String nickName;
	/**
	 * 口粮
	 */
	@Column(nullable = true, length = 255, name = "ration")
	private String ration;
	/**
	 * 技能
	 */
	@Column(nullable = true, length = 255, name = "skill")
	private String skill;
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

	// setter and getter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHeadPortraitImg() {
		return headPortraitImg;
	}

	public void setHeadPortraitImg(String headPortraitImg) {
		this.headPortraitImg = headPortraitImg;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRation() {
		return ration;
	}

	public void setRation(String ration) {
		this.ration = ration;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
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

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

}
