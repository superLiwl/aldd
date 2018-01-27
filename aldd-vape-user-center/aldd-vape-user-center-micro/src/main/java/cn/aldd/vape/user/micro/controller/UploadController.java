package cn.aldd.vape.user.micro.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.aldd.vape.user.micro.config.FtpConfig;
import cn.aldd.vape.util.FtpUtil;

@RestController
public class UploadController {
	@Autowired
	FtpConfig ftpConfig;

	@RequestMapping(method = RequestMethod.POST, value = "/fileUpload/{type}")
	public String uploadFile(@RequestPart("file") MultipartFile file, @PathVariable("type") String type)
			throws IOException {
		String result = FtpUtil.uploadFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUser(),
				ftpConfig.getPwd(), type, file.getOriginalFilename(), file.getInputStream());
		return result;
	}
}
