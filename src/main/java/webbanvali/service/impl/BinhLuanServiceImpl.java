package webbanvali.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanvali.converter.CommentConverter;
import webbanvali.dto.ValiCommentDTO;
import webbanvali.entity.Vali;
import webbanvali.repository.ValiRepository;
import webbanvali.service.BinhLuanService;

@Service
@Transactional
public class BinhLuanServiceImpl implements BinhLuanService {

	@Autowired
	private ValiRepository valiRepository;

	@Autowired
	private CommentConverter commonConverter;


	@Override
	public ValiCommentDTO getValiCommentTheoValiSlug(String valiSlug) {

		Optional<Vali> valiOpt = valiRepository.findBySlug(valiSlug);
		
		if (!valiOpt.isPresent())
			return null;

		return commonConverter.convertValiToValiCommentDTO(valiOpt.get());
	}

}
