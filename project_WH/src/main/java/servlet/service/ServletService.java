package servlet.service;

import java.util.List;
import java.util.Map;

public interface ServletService {
	
	String addStringTest(String str) throws Exception;

	void uploadFile(List<Map<String, Object>> list);

}
