package webbanvali.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanvali.entity.PhuongXa;
import webbanvali.entity.QuanHuyen;
import webbanvali.entity.TinhThanhPho;
import webbanvali.repository.PhuongXaRepository;
import webbanvali.repository.QuanHuyenRepository;
import webbanvali.repository.TinhThanhPhoRepository;
import webbanvali.service.DiaChiService;

@Service
public class DiaChiServiceImpl implements DiaChiService {

	@Autowired
	private TinhThanhPhoRepository tinhThanhPhoRepository;

	@Autowired
	private QuanHuyenRepository quanHuyenRepository;

	@Autowired
	private PhuongXaRepository phuongXaRepository;

	@Override
	public List<Map<String, String>> getDanhSachThanhPho() {

		List<Map<String, String>> thanhPhos = new ArrayList<>();

		List<TinhThanhPho> result = tinhThanhPhoRepository.findAll();

		for (TinhThanhPho tinhThanhPho : result) {

			Map<String, String> tempt = new HashMap<>();

			tempt.put("maThanhPho", tinhThanhPho.getMaThanhPho());
			tempt.put("tenThanhPho", tinhThanhPho.getTen());

			thanhPhos.add(tempt);
		}

		return thanhPhos;
	}

	@Override
	public List<Map<String, String>> getDanhSachQuanHuyenTheoMaThanhPho(String maThanhPho) {
		List<Map<String, String>> quanHuyens = new ArrayList<>();

		List<QuanHuyen> result = quanHuyenRepository.findAllByMaThanhPho(maThanhPho);

		for (QuanHuyen quanHuyen : result) {

			Map<String, String> tempt = new HashMap<>();

			tempt.put("maQuanHuyen", quanHuyen.getMaQuanHuyen());
			tempt.put("tenQuanHuyen", quanHuyen.getTen());

			quanHuyens.add(tempt);
		}

		return quanHuyens;
	}

	@Override
	public List<Map<String, String>> getDanhSachPhuongXaTheoMaQuanHuyen(String maQuanHuyen) {
		List<Map<String, String>> phuongXas = new ArrayList<>();

		List<PhuongXa> result = phuongXaRepository.findAllByMaQuanHuyen(maQuanHuyen);

		for (PhuongXa phuongXa : result) {

			Map<String, String> tempt = new HashMap<>();

			tempt.put("maPhuongXa", phuongXa.getMaPhuongXa());
			tempt.put("tenPhuongXa", phuongXa.getTen());

			phuongXas.add(tempt);
		}

		return phuongXas;
	}

	@Override
	public String getTenPhuongXaTheoMa(String maPhuongXa) {

		String tenPhuongXa = null;

		Optional<PhuongXa> tempt = phuongXaRepository.findById(maPhuongXa);

		if (tempt.isPresent()) {
			tenPhuongXa = tempt.get().getTen();
		}

		return tenPhuongXa;

	}

	@Override
	public String getTenQuanHuyenTheoMa(String maQuanHuyen) {
		String tenQuanHuyen = null;

		Optional<QuanHuyen> tempt = quanHuyenRepository.findById(maQuanHuyen);

		if (tempt.isPresent()) {
			tenQuanHuyen = tempt.get().getTen();
		}

		return tenQuanHuyen;
	}

	@Override
	public String getTenTinhThanhPhoTheoMa(String maThanhPho) {
		
		String tenThanhPho = null;
		Optional<TinhThanhPho> tempt = tinhThanhPhoRepository.findById(maThanhPho);

		if (tempt.isPresent()) {
			tenThanhPho = tempt.get().getTen();
		}

		return tenThanhPho;
	}

}
