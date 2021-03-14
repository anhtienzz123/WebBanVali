package webbanvali.utils;

import webbanvali.entity.BienTheVali_PK;

public class MainTest {

	public static void main(String[] args) {
	
		BienTheVali_PK bienTheVali_PK = new BienTheVali_PK(1, 2, 3);
		BienTheVali_PK bienTheVali_PK1 = new BienTheVali_PK(1, 2, 3);
		
		System.out.println(bienTheVali_PK.equals(bienTheVali_PK1));
	}
}
