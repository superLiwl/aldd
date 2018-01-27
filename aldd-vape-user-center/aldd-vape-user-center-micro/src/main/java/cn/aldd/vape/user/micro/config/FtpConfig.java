package cn.aldd.vape.user.micro.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FtpConfig {

	/**
	 * 地址
	 */
	@Value("${ftp.host}")
	private String host;
	/**
	 * 端口
	 */
	@Value("${ftp.port}")
	private Integer port;
	/**
	 * 用户名
	 */
	@Value("${ftp.user}")
	private String user;
	/**
	 * 密码
	 */
	@Value("${ftp.pwd}")
	private String pwd;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
