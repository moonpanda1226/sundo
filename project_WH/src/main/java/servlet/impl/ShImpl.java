package servlet.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import servlet.dto.ServletDTO;
import servlet.service.ShService;

@Service("ShService")
public class ShImpl extends EgovAbstractServiceImpl implements ShService{
	
	@Resource(name="ShDAO")
	private ShDAO shdao;

	@Override
	public List<ServletDTO> selectid() {
		return shdao.selectid();
	}

	@Override
	public List<ServletDTO> selectSgg(String test) {
		return shdao.selectSgg(test);
	}

	@Override
	public List<ServletDTO> selectBjd(String test) {
		return shdao.selectBjd(test);
	}
}
