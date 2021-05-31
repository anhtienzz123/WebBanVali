package webbanvali.service;

import java.util.List;

import webbanvali.dto.BinhLuanDTO;
import webbanvali.dto.ValiCommentDTO;

public interface BinhLuanService {

	ValiCommentDTO getValiCommentTheoValiSlug(String valiSlug);
	
	List<BinhLuanDTO> getBinhLuans(String id);
	

	boolean xoaBinhLuanTheoValiIdVaNguoiDungId(Integer valiId,  Integer nguoiDungId);

	boolean themBinhLuan(String valiSlug, String noiDung, Integer soSao);
	
	
}
