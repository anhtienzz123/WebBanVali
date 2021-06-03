package webbanvali.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import webbanvali.dto.BannerDTO;

public interface BannerService {

	List<BannerDTO> getBanners();
	BannerDTO themBanner(String tieuDe, MultipartFile file);
	boolean xoaBannerTheoId(int id);
	
}
