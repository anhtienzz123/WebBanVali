package webbanvali.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanvali.dto.BannerDTO;
import webbanvali.entity.Banner;
import webbanvali.repository.BannerRepository;
import webbanvali.service.BannerService;
import webbanvali.utils.HamDungChung;

@Service
public class BannerServiceImpl implements BannerService {

	@Autowired
	private BannerRepository bannerRepository;

	@Override
	public List<BannerDTO> getBanners() {
		List<Banner> banners = bannerRepository.findAll();
		return banners.stream().map(s -> new BannerDTO(s.getId(), s.getTenAnh(), s.getTieuDe(), s.getNoiDung()))
				.collect(Collectors.toList());
	}

	@Override
	public List<BannerDTO> getBannersTheoTenAnh(String tenAnh) {
		List<Banner> banners = bannerRepository.findByTenAnhContainingIgnoreCase(tenAnh);

		return banners.stream().map(s -> new BannerDTO(s.getId(), s.getTenAnh(), s.getTieuDe(), s.getNoiDung()))
				.collect(Collectors.toList());
	}

	@Override
	public BannerDTO getBannerTheoId(int id) {
		BannerDTO bannerDTO = bannerRepository.findById(id)
				.map(s -> new BannerDTO(s.getId(), s.getTenAnh(), s.getTieuDe(), s.getNoiDung())).orElse(null);

		return bannerDTO;
	}

	@Override
	public BannerDTO themBanner(String tenAnh) {
		if (bannerRepository.existsByTenAnh(tenAnh))
			return null;

		String tieuDe = HamDungChung.toSlug(tenAnh);
		String noiDung = HamDungChung.toSlug(tenAnh);
		Banner bannerResult = bannerRepository.save(new Banner(tenAnh, tieuDe, noiDung));
		return new BannerDTO(bannerResult.getId(), bannerResult.getTenAnh(), bannerResult.getTieuDe(),
				bannerResult.getNoiDung());
	}

	@Override
	public BannerDTO capNhatBanner(Integer id, String tenAnh) {

		if (bannerRepository.existsByTenAnhAndIdNot(tenAnh, id)) {
			return null;
		}

		String tieuDe = HamDungChung.toSlug(tenAnh);
		String noiDung = HamDungChung.toSlug(tenAnh);
		Banner bannerResult = bannerRepository.save(new Banner(id, tenAnh, tieuDe, noiDung));
		return new BannerDTO(bannerResult.getId(), bannerResult.getTenAnh(), bannerResult.getTieuDe(),
				bannerResult.getNoiDung());
	}

	@Override
	public boolean xoaBannerTheoId(int id) {
		if (!bannerRepository.existsById(id))
			return false;

//		mauSacRepository.delete(mauSacRepository.findById(id).get());
		bannerRepository.deleteById(id);

		return true;
	}

}
