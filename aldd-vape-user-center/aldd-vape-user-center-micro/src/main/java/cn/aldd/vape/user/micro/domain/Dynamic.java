package cn.aldd.vape.user.micro.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	 * 发表地址
	 */
	@Column(nullable = true, length = 255, name = "address")
	private String address;
	/**
	 * 动态内容
	 */
	@Column(nullable = true, length = 255, name = "content")
	private String content;
	/**
	 * 创建人
	 */
	@Column(nullable = true, length = 36, name = "create_user_id")
	private String createUserId;
	/**
	 * 创建时间
	 */
	@Column(nullable = true, name = "create_time")
	private java.util.Date createTime;
	// ===================非数据库对应字段
	/**
	 * 动态图片
	 */
	@Transient
	List<String> images;
	/**
	 * 文件类型
	 */
	@Transient
	String type;

	// setter and getter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
