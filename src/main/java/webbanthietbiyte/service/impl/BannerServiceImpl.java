package webbanvali.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import webbanvali.dto.BannerDTO;
import webbanvali.entity.Banner;
import webbanvali.repository.BannerRepository;
import webbanvali.service.BannerService;
import webbanvali.utils.FileUploadProcessor;

@Service
public class BannerServiceImpl implements BannerService {

	@Autowired
	private BannerRepository bannerRepository;
	
	@Autowired
	private FileUploadProcessor fileUploadProcessor;

	@Override
	public List<BannerDTO> getBanners() {
		List<Banner> banners = bannerRepository.findAll();
		return banners.stream().map(s -> new BannerDTO(s.getId(), s.getTenAnh(), s.getTieuDe(), s.getNoiDung()))
				.collect(Collectors.toList());
	}

	
	@Override
	public BannerDTO themBanner(String tieuDe, MultipartFile file) {
		
	
		String tenAnh = fileUploadProcessor.saveBannerFile(file);
		Banner bannerResult = bannerRepository.save(new Banner(tenAnh, tieuDe, ""));
		
		return new BannerDTO(bannerResult.getId(), bannerResult.getTenAnh(), bannerResult.getTieuDe(),
				bannerResult.getNoiDung());
	}

	

	@Override
	public boolean xoaBannerTheoId(int id) {
		if (!bannerRepository.existsById(id))
			return false;

		Banner banner = bannerRepository.findById(id).get();
		
		fileUploadProcessor.deleteBannertFile(banner.getTenAnh() );
		
		
		bannerRepository.deleteById(id);

		return true;
	}

}
