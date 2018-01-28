package cn.aldd.vape.user.micro.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "dynamic_reward")
public class DynamicReward implements Serializable {

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
	 * 动态id
	 */
	@Column(nullable = false,length = 36, name = "dynamic_id")
	private String dynamicId;
	/**
	 * 打赏数量
	 */
	@Column(nullable = false,length = 255, name = "reward_num")
	private String rewardNum;
	/**
	 * 创建人
	 */
	@Column(nullable = false,length = 36, name = "create_user_id")
	private String createUserId;
	/**
	 * 创建时间
	 */
	@Column(nullable = false, name = "create_time")
	private java.util.Date createTime;

// setter and getter
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public String getDynamicId(){
		return dynamicId;
	}
	
	public void setDynamicId(String dynamicId){
		this.dynamicId = dynamicId;
	}
	public String getRewardNum(){
		return rewardNum;
	}
	
	public void setRewardNum(String rewardNum){
		this.rewardNum = rewardNum;
	}
	public String getCreateUserId(){
		return createUserId;
	}
	
	public void setCreateUserId(String createUserId){
		this.createUserId = createUserId;
	}
	public java.util.Date getCreateTime(){
		return createTime;
	}
	
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
}
