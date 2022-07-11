package webbanvali.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadProcessor {

	public static final String URL_IMAGE = "D:/DuAn/WebBanVali-SpringMVC/WebBanVali/WebBanVali/src/main/webapp/resources/image/vali";
	public static final String URL_IMAGE_BANNER = "D:/DuAn/WebBanVali-SpringMVC/WebBanVali/WebBanVali/src/main/webapp/resources/image/banner";

	public String saveFile(MultipartFile multipartFile) {

		String fileName = RandomStringUtils.randomAlphanumeric(6) + HamDungChung.toSlug(multipartFile.getOriginalFilename())+".jpg";

		File pathFile = new File(URL_IMAGE);

		if (!pathFile.exists()) {
			pathFile.mkdir();
		}

		pathFile = new File(URL_IMAGE, fileName);

		try {
			multipartFile.transferTo(pathFile);

			System.out.println("pathFile: " + pathFile.toString());
			return fileName;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean deleteFile(String tenAnh) {

		File file = new File(URL_IMAGE, tenAnh);

		if (file.exists()) {
			return file.delete();
		}

		return false;

	}
	
	public String saveBannerFile(MultipartFile multipartFile) {

		String fileName = RandomStringUtils.randomAlphanumeric(6) + HamDungChung.toSlug(multipartFile.getOriginalFilename()) + ".jpg";

		File pathFile = new File(URL_IMAGE_BANNER);

		if (!pathFile.exists()) {
			pathFile.mkdir();
		}

		pathFile = new File(URL_IMAGE_BANNER, fileName);

		try {
			multipartFile.transferTo(pathFile);

			System.out.println("pathFile: " + pathFile.toString());
			return fileName;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean deleteBannertFile(String tenAnh) {

		File file = new File(URL_IMAGE_BANNER, tenAnh);

		if (file.exists()) {
			return file.delete();
		}

		return false;

	}

}
