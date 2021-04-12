package webbanvali.service;

import java.util.List;

import webbanvali.dto.ChatLieuDTO;

public interface ChatLieuService {
	List<ChatLieuDTO> getChatLieus();

	List<ChatLieuDTO> getChatLieusTheoTenChatLieu(String tenChatLieu);

	ChatLieuDTO getChatLieuTheoId(int id);

	ChatLieuDTO themChatLieu(String tenChatLieu);

	boolean xoaChatLieuTheoId(int id);
}
