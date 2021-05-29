package webbanvali.service;

import java.util.List;

import webbanvali.dto.BinhLuanDTO;

import webbanvali.dto.ValiCommentDTO;
import webbanvali.entity.NguoiDung;
import webbanvali.entity.Vali;

public interface BinhLuanService {

	ValiCommentDTO getValiCommentTheoValiSlug(String valiSlug);
	
	List<BinhLuanDTO> getBinhLuans(String id);
	

	boolean xoaBinhLuanTheoValiIdVaNguoiDungId(Integer valiId,  Integer nguoiDungId);

	BinhLuanDTO themBinhLuan(NguoiDung nguoiDung, Vali vali, String cmt, Integer soSao);
}
