package webbanvali.service;

import webbanvali.dto.CartBienTheValiDTO;
import webbanvali.dto.CartDTO;

public interface GioHangService {

	
	CartBienTheValiDTO convertCartDTOToCartBienTheValiDTO(CartDTO cartDTO);
	
	boolean datHang(CartDTO cartDTO);
}
