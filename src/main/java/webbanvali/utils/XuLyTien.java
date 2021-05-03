package webbanvali.utils;

import java.text.DecimalFormat;

public class XuLyTien {

	public static String dinhDangTien(double tien) {
		DecimalFormat df = new DecimalFormat("###,###,###");
		return df.format(tien) + " đ";
		
	}
	
}
