package cn.aldd.vape.user.micro.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "dynamic")
public class Dynamic implements Serializable {

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
	 * 创建人
	 */
	@Column(nullable = false, length = 36, name = "user_id")
	private String userId;
	/**
	 * 动态内容
	 */
	@Column(nullable = false, length = 500, name = "content")
	private String content;
	/**
	 * 发表地址
	 */
	@Column(nullable = false, length = 100, name = "address")
	private String address;
	/**
	 * 创建时间
	 */
	@Column(nullable = false, length = 19, name = "create_time")
	private java.util.Date createTime;
	/**
	 * 更新时间
	 */
	@Column(nullable = false, length = 19, name = "update_time")
	private java.util.Date updateTime;

// setter and getter
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public String getUserId(){
		return userId;
	}
	
	public void setUserId(String userId){
		this.userId = userId;
	}
	public String getContent(){
		return content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	public java.util.Date getCreateTime(){
		return createTime;
	}
	
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	public java.util.Date getUpdateTime(){
		return updateTime;
	}
	
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
}
