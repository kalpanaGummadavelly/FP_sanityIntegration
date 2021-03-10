package com.qa.utils;

import java.util.HashMap;

public class TestUtil {
	
	public static int PAGE_LOAD_TIMEOUT =20;
	public static int IMPLICIT_WAIT =50;

	
	public static HashMap<Integer,String> getIncomeInd() {
		HashMap<Integer,String> income_map = new HashMap<Integer,String>();
		income_map.put(1, "< $ 88K");
		income_map.put(2, "$ 88K to $ 111K");
		income_map.put(3, "$ 111K to $ 138K");
		income_map.put(4, "$ 138K to $ 165K");
		income_map.put(5, "$ 165K to $ 500K");
		income_map.put(6, ">$ 500K");
		return income_map;
	}
	
	public static HashMap<Integer,String> getIncomeFamily() {
		HashMap<Integer,String> income_map1 = new HashMap<Integer,String>();
		income_map1.put(1, "< $ 176K");
		income_map1.put(2, "$ 176K to $ 222K");
		income_map1.put(3, "$ 222K to $ 276K");
		income_map1.put(4, "$ 276K to $ 330K");
		income_map1.put(5, "$ 330K to $ 750K");
		income_map1.put(6, ">$ 750K");
		return income_map1;
	}
}
