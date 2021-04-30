package webbanvali.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import webbanvali.entity.NguoiDung;
import webbanvali.repository.NguoidungRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private NguoidungRepository nguoidungRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// lấy người dùng có user là có username
		NguoiDung nguoiDung = nguoidungRepository.findByEmailAndTrangThai(username, true);

		if (nguoiDung == null)
			throw new UsernameNotFoundException("Tài khoản email không tồn tại");

		CustomUserDetails customUserDetails = new CustomUserDetails(nguoiDung);
		
		return customUserDetails;
	}

}
