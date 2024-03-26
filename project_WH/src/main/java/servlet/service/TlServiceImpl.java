package servlet.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import servlet.dao.SdDAO;
import servlet.dao.SggDAO;
import servlet.dto.SdDTO;
import servlet.dto.SggDTO;

@Service("TlService")
public class TlServiceImpl implements TlService{
	
	@Autowired
	private SdDAO sdDAO;
	
	@Autowired
	private SggDAO sggDAO;	
	
	@Override
	public List<SggDTO> selectSgg(String name) {
		return sggDAO.selectSgg(name);
	}

	@Override
	public List<SdDTO> selectSd() {
		return sdDAO.selectSd();
	}

	@Override
	public Map<String, Object> selectGeom(String name) {
		return sdDAO.selectGeom(name);
	}

	@Override
	public Map<String, Object> selectB(String name) {
		return sdDAO.selectB(name);
	}


}
