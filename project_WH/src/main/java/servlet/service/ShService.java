package servlet.service;

import java.util.List;

import servlet.dto.ServletDTO;

public interface ShService {

	List<ServletDTO> selectid();

	List<ServletDTO> selectSgg(String test);

	List<ServletDTO> selectBjd(String test);

}
