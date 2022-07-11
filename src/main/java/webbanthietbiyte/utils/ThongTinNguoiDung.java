package webbanvali.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class ThongTinNguoiDung {

	public static String getUsername() {
		
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
