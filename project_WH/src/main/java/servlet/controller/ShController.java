package servlet.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;
import servlet.dto.ServletDTO;
import servlet.service.MapService;
import servlet.service.ShService;


@Controller
public class ShController {
	

	@Resource(name="ShService")
	private ShService shService;
	
	@GetMapping(value="/sw.do")
	public String sw() {
		return "main/sw";
	}
	
	@PostMapping("sw.do")
	public String sd(Model model) {
		List<ServletDTO> list = shService.selectid();
		model.addAttribute("list", list);
		return "main/sw";
	}
	@PostMapping("/selectSgg.do")
	public @ResponseBody List<ServletDTO> selectSgg(@RequestParam("test") String test){
		
		List<ServletDTO> list = shService.selectSgg(test);
		System.out.println("시군구 : " + list);		
		return list;
	}
	@PostMapping("/selectBjd.do")
	public @ResponseBody List<ServletDTO> selectBjd(@RequestParam("test") String test){
		
		List<ServletDTO> list = shService.selectBjd(test);
		System.out.println("법정동 : " + list);		
		return list;
	}
}
