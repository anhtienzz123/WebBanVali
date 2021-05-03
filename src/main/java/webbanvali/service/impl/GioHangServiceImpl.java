package webbanvali.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanvali.converter.BienTheValiConverter;
import webbanvali.dto.BienTheValiDTO;
import webbanvali.dto.CartBienTheValiDTO;
import webbanvali.dto.CartBienTheValiItemDTO;
import webbanvali.dto.CartDTO;
import webbanvali.dto.CartItemDTO;
import webbanvali.repository.BienTheValiRepository;
import webbanvali.service.GioHangService;

@Service
@Transactional
public class GioHangServiceImpl implements GioHangService {

	@Autowired
	private BienTheValiRepository bienTheValiRepository;
	
	@Autowired
	private BienTheValiConverter bienTheValiConverter;

	@Override
	public CartBienTheValiDTO convertCartDTOToCartBienTheValiDTO(CartDTO cartDTO) {

	
		List<CartBienTheValiItemDTO> cartBienTheValiItemDTOs = new ArrayList<>();

		for (CartItemDTO cartItemDTO : cartDTO.getCartItemDTOs()) {

			
			BienTheValiDTO bienTheValiDTO = bienTheValiConverter.toBienTheValiDTO(bienTheValiRepository.findByValiSlugAndKichThuocCodeAndMauSacCode(
					cartItemDTO.getSlug(), cartItemDTO.getKichThuocCode(), cartItemDTO.getMauSacCode()));

			CartBienTheValiItemDTO cartBienTheValiItemDTO = new CartBienTheValiItemDTO(bienTheValiDTO,
					cartItemDTO.getSoLuong());

			cartBienTheValiItemDTOs.add(cartBienTheValiItemDTO);
		}

		return new CartBienTheValiDTO(cartBienTheValiItemDTOs);
	}

	

}
