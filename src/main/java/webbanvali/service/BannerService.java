package webbanvali.service;

import java.util.List;

import webbanvali.dto.BannerDTO;

public interface BannerService {

	List<BannerDTO> getBanners();

	List<BannerDTO> getBannersTheoTenAnh(String tenAnh);

	BannerDTO getBannerTheoId(int id);

	BannerDTO themBanner(String tenAnh);

	BannerDTO capNhatBanner(Integer id, String tenAnh);

	boolean xoaBannerTheoId(int id);
	
}
