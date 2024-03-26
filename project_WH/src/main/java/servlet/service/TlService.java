package servlet.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import servlet.dto.SdDTO;
import servlet.dto.SggDTO;

@Service
public interface TlService {

	List<SggDTO> selectSgg(String name);
	
	List<SdDTO> selectSd();

	Map<String, Object> selectGeom(String name);

	Map<String, Object> selectB(String name);

}
