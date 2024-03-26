package servlet.dao;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import servlet.dto.SdDTO;

@Repository
public class SdDAO{
	
	@Autowired
	private SqlSession sqlSession;

	public List<SdDTO> selectSd() {
		return sqlSession.selectList("SdMapper.selectSd");
	}

	public Map<String, Object> selectGeom(String name) {
		return sqlSession.selectOne("uploadFile.selectGeom", name);
	}

	public Map<String, Object> selectB(String name) {
		return sqlSession.selectOne("uploadFile.selectB",name);
	}
	


	
	
	
}
