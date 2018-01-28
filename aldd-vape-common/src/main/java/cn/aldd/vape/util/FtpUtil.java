package cn.aldd.vape.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FtpUtil {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("D:\\123.png");
		InputStream input = new FileInputStream(file);
		System.out.println(uploadFile(input, "123.png", "473894728"));
	}

	public static String uploadFile(InputStream inputStream, String fileName, String userId) {
		fileName = Utils.getUUID() + fileName.substring(fileName.lastIndexOf("."), fileName.length());
		OutputStream os = null;
		try {
			String path = "C:\\ftp\\images\\" + userId + "\\";
			// 2、保存到临时文件
			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流保存到本地文件
			File tempFile = new File(path);
			if (!tempFile.exists()) {
				tempFile.mkdirs();
			}
			os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
			// 开始读取
			while ((len = inputStream.read(bs)) != -1) {
				os.write(bs, 0, len);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 完毕，关闭所有链接
			try {
				os.close();
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return userId + "/" + fileName;
	}

}
