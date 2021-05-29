package webbanvali.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import webbanvali.dto.ChatLieuDTO;
import webbanvali.dto.MauSacDTO;
import webbanvali.dto.TinhNangDacBietDTO;
import webbanvali.service.ChatLieuService;

@Controller
@RequestMapping(value = "/admin/chat-lieu")
public class ChatLieuController {

	@Autowired
	private ChatLieuService chatLieuService;

	@GetMapping(value = "/trang-chu")
	public String trangChu(Model model) {
		model.addAttribute("chatLieus", chatLieuService.getChatLieus());
		return "trangChuChatLieuAdmin";
	}

	@GetMapping(value = "/api")
	public ResponseEntity<List<ChatLieuDTO>> getListTheoTen(@RequestParam("tenChatLieu") String tenChatLieu,
			Model model) {

		List<ChatLieuDTO> chatLieuDTOs = chatLieuService.getChatLieusTheoTenChatLieu(tenChatLieu);

		return ResponseEntity.ok(chatLieuDTOs);

	}

	@GetMapping(value = "/api/{chatLieuId}")
	public @ResponseBody ResponseEntity<ChatLieuDTO> getTheoId(@PathVariable("chatLieuId") int id) {

		ChatLieuDTO chatLieuDTO = chatLieuService.getChatLieuTheoId(id);

		if (chatLieuDTO == null)
			return new ResponseEntity<ChatLieuDTO>(HttpStatus.NOT_FOUND);

		return ResponseEntity.ok(chatLieuDTO);

	}

	// thêm
	@PostMapping(value = "/api")
	public @ResponseBody ResponseEntity<ChatLieuDTO> them(@RequestBody ChatLieuDTO chatLieuDTO1) {

		ChatLieuDTO chatLieuDTO = chatLieuService.themChatLieu(chatLieuDTO1.getTenChatLieu());
		if (chatLieuDTO == null)
			return new ResponseEntity<ChatLieuDTO>(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(chatLieuDTO);

	}

	@DeleteMapping(value = "/api/{chatLieuId}")
	public @ResponseBody ResponseEntity<?> xoa(@PathVariable("chatLieuId") int chatLieuId) {

		if (chatLieuService.xoaChatLieuTheoId(chatLieuId))
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	// cập nhật
	@PutMapping(value = "/api")
	public @ResponseBody ResponseEntity<ChatLieuDTO> capNhat(@RequestBody ChatLieuDTO chatLieuDTO1) {

		ChatLieuDTO chatLieuDTO = chatLieuService.capNhatChatLieu(chatLieuDTO1.getId(), chatLieuDTO1.getTenChatLieu());
		if (chatLieuDTO == null)
			return new ResponseEntity<ChatLieuDTO>(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(chatLieuDTO);

	}

}
