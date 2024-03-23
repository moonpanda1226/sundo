package servlet.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import servlet.dto.ServletDTO;

@Repository("ShDAO")
public class ShDAO extends EgovComAbstractDAO {

	@Autowired
	private SqlSession session;

	public List<ServletDTO> selectid() {
		return session.selectList("servlet.suhyun");
	}

	public List<ServletDTO> selectSgg(String test) {
		return session.selectList("servlet.zzang9", test);
	}

	public List<ServletDTO> selectBjd(String test) {
		return session.selectList("servlet.suryeon", test);
	}
}
