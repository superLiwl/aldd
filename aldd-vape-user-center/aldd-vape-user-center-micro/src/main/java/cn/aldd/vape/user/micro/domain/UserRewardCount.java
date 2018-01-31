package cn.aldd.vape.user.micro.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_reward_count")
public class UserRewardCount implements Serializable {

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
	 * 用户id
	 */
	@Column(nullable = true,length = 36, name = "user_id")
	private String userId;
	/**
	 * 拥有打赏次数
	 */
	@Column(nullable = true,length = 20, name = "have_reward_count")
	private String haveRewardCount;
	/**
	 * 已经打赏次数
	 */
	@Column(nullable = true,length = 20, name = "used_reward_count")
	private String usedRewardCount;
	/**
	 * 创建时间
	 */
	@Column(nullable = true, name = "create_time")
	private java.util.Date createTime;

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
	public String getHaveRewardCount(){
		return haveRewardCount;
	}
	
	public void setHaveRewardCount(String haveRewardCount){
		this.haveRewardCount = haveRewardCount;
	}
	public String getUsedRewardCount(){
		return usedRewardCount;
	}
	
	public void setUsedRewardCount(String usedRewardCount){
		this.usedRewardCount = usedRewardCount;
	}
	public java.util.Date getCreateTime(){
		return createTime;
	}
	
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
}
