package webbanvali.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanvali.dto.ChatLieuDTO;
import webbanvali.dto.MauSacDTO;
import webbanvali.dto.TinhNangDacBietDTO;
import webbanvali.entity.ChatLieu;
import webbanvali.entity.MauSac;
import webbanvali.entity.TinhNangDacBiet;
import webbanvali.repository.ChatLieuRepository;

import webbanvali.service.ChatLieuService;

import webbanvali.utils.HamDungChung;

@Service
public class ChatLieuServiceImpl implements ChatLieuService {

	@Autowired
	private ChatLieuRepository chatLieuRepository;

	@Override
	public List<ChatLieuDTO> getChatLieus() {
		List<ChatLieu> chatLieus = chatLieuRepository.findAll();

		return chatLieus.stream().map(s -> new ChatLieuDTO(s.getId(), s.getTenChatLieu(), s.getCode()))
				.collect(Collectors.toList());
	}

	@Override
	public List<ChatLieuDTO> getChatLieusTheoTenChatLieu(String tenChatLieu) {
		// TODO Auto-generated method stub
		List<ChatLieu> chatLieus = chatLieuRepository.findByTenChatLieuContainingIgnoreCase(tenChatLieu);

		return chatLieus.stream().map(s -> new ChatLieuDTO(s.getId(), s.getTenChatLieu(), s.getCode()))
				.collect(Collectors.toList());
	}

	@Override
	public ChatLieuDTO getChatLieuTheoId(int id) {
		// TODO Auto-generated method stub

		ChatLieuDTO chatLieuDTO = chatLieuRepository.findById(id)
				.map(s -> new ChatLieuDTO(s.getId(), s.getTenChatLieu(), s.getCode())).orElse(null);

		return chatLieuDTO;

	}

	@Override
	public ChatLieuDTO themChatLieu(String tenChatLieu) {
		// TODO Auto-generated method stub
		// nếu như đã tồn tại rồi
		if (chatLieuRepository.existsByTenChatLieu(tenChatLieu))
			return null;

		String code = HamDungChung.toSlug(tenChatLieu);
		ChatLieu chatLieuResult = chatLieuRepository.save(new ChatLieu(tenChatLieu, code));
		return new ChatLieuDTO(chatLieuResult.getId(), chatLieuResult.getTenChatLieu(), chatLieuResult.getCode());

	}

	@Override
	public boolean xoaChatLieuTheoId(int id) {
		// TODO Auto-generated method stub
		if (!chatLieuRepository.existsById(id))
			return false;

		chatLieuRepository.delete(chatLieuRepository.findById(id).get());

		return true;

	}

	@Override
	public ChatLieuDTO capNhatChatLieu(Integer id, String tenChatLieu) {
		// TODO Auto-generated method stub
		if (chatLieuRepository.existsByTenChatLieuAndIdNot(tenChatLieu, id)) {
			return null;
		}

		String code = HamDungChung.toSlug(tenChatLieu);
		ChatLieu chatLieuResult = chatLieuRepository.save(new ChatLieu(id, tenChatLieu, code));
		return new ChatLieuDTO(chatLieuResult.getId(), chatLieuResult.getTenChatLieu(), chatLieuResult.getCode());
	}

}
