package cn.aldd.vape.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpUtil {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("D:\\123.png");
		InputStream input = new FileInputStream(file);
		uploadFile("47.95.2.132", 21, "ftpUser", "qwer1234", "images", "123.png", input);
	}

	public static String uploadFile(String host, int port, String username, String password, String filePath,
			String filename, InputStream input) {
		filename = Utils.getUUID() + filename.substring(filename.lastIndexOf("."), filename.length());
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(host, port);// 连接FTP服务器
			// 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return filename;
			}
			// 切换到上传目录
			if (!ftp.changeWorkingDirectory(filePath)) {
				// 如果目录不存在创建目录
				String[] dirs = filePath.split("/");
				String tempPath = "";
				for (String dir : dirs) {
					if (null == dir || "".equals(dir))
						continue;
					tempPath += "/" + dir;
					if (!ftp.changeWorkingDirectory(tempPath)) {
						if (!ftp.makeDirectory(tempPath)) {
							return filename;
						} else {
							ftp.changeWorkingDirectory(tempPath);
						}
					}
				}
			}
			// 设置上传文件的类型为二进制类型
			ftp.setFileType(FTP.BINARY_FILE_TYPE);

			// 上传文件
			if (!ftp.storeFile(filename, input)) {
				return filename;
			}
			input.close();
			ftp.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return filename;
	}

}
