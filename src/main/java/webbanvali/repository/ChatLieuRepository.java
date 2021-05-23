package webbanvali.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import webbanvali.entity.ChatLieu;


public interface ChatLieuRepository extends JpaRepository<ChatLieu, Integer> {
	boolean existsByTenChatLieu(String tenChatLieu);
	List<ChatLieu> findByTenChatLieuContainingIgnoreCase(String tenChatLieu);
	
	boolean existsByTenChatLieuAndIdNot(String tenChatLieu, Integer id);

	ChatLieu findByTenChatLieu(String tenChatLieu);
}
