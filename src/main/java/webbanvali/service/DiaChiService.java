package webbanvali.service;

import java.util.List;
import java.util.Map;

public interface DiaChiService {

    List<Map<String, String>> getDanhSachThanhPho();
    List<Map<String,String>> getDanhSachQuanHuyenTheoMaThanhPho(String maThanhPho);
    List<Map<String,String>> getDanhSachPhuongXaTheoMaQuanHuyen(String maQuanHuyen);
    
    String getTenPhuongXaTheoMa(String maPhuongXa);
    String getTenQuanHuyenTheoMa(String maQuanHuyen);
    String getTenTinhThanhPhoTheoMa(String maThanhPho);
    

    
}
