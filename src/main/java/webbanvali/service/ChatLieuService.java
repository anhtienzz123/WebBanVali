package webbanvali.service;

import java.util.List;

import webbanvali.dto.ChatLieuDTO;
import webbanvali.dto.MauSacDTO;

public interface ChatLieuService {
	List<ChatLieuDTO> getChatLieus();

	List<ChatLieuDTO> getChatLieusTheoTenChatLieu(String tenChatLieu);

	ChatLieuDTO getChatLieuTheoId(int id);

	ChatLieuDTO themChatLieu(String tenChatLieu);
	
	ChatLieuDTO capNhatChatLieu(Integer id, String tenChatLieu);

	boolean xoaChatLieuTheoId(int id);
}
