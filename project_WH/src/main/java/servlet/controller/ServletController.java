package servlet.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import servlet.service.ServletService;

@Controller
public class ServletController {
	@Resource(name = "ServletService")
	private ServletService servletService;
	
	@RequestMapping(value = "/main.do")
	public String mainTest(ModelMap model) throws Exception {
		System.out.println("sevController.java - mainTest()");
		
		String str = servletService.addStringTest("START! ");
		model.addAttribute("resultStr", str);
		
		return "main/main";
	}
	
	   @RequestMapping(value= "/mapTest.do")
	      public String mapTest(){
	         return "main/mapTest";
	      }
	   @RequestMapping(value= "/test.do")
	      public String test(){
	         return "main/test";
	      }
	   
	   
	   @GetMapping(value= "/readfile.do")
	   public String readfile() throws IOException {
		   return "/main/readfile";
	   }
	   
	   
	   
	   
	   @PostMapping(value= "/readfile.do")
	   public @ResponseBody String readfile2(@RequestParam("upFile") MultipartFile upFile) throws IOException {
		   System.out.println(upFile.getName()); System.out.println(upFile.getContentType()); System.out.println(upFile.getSize());
		   List<Map<String, Object>> list = new ArrayList<>();
		   Map<String, Object> m = new HashMap<>();
		   InputStreamReader isr = new InputStreamReader(upFile.getInputStream()); BufferedReader br = new BufferedReader(isr);
		   String line = null;
		   while ((line = br.readLine()) != null) {
		    }
		   String[] lineArr = line.split("\\|");
		   m.put("date", lineArr[0]); //사용_년월 date
		   m.put("addr", lineArr[1]); //대지_위치 addr m.put("newAddr", lineArr[2]); //도로명_대지_위치 newAddr m.put("sigungu", lineArr[3]); //시군구_코드 sigungu m.put("bubjungdong", lineArr[4]); //법정동_코드 bubjungdong m.put("addrCode", lineArr[5]); //대지_구분_코드 addrCode m.put("bun", lineArr[6]); //번 bun
		   m.put("si", lineArr[7]); //지 si
		   m.put("newAddrCode", lineArr[8]); //새주소_일련번호 newAddrCode m.put("newAddr", lineArr[9]); //새주소_도로_코드 newAddr m.put("newAddrUnder", lineArr[10]);//새주소_지상지하_코드newAddrUnder m.put("newAddrBun", lineArr[11]); //새주소_본_번 newAddrBun m.put("newAddrBun2", lineArr[12]); //새주소_부_번 newAddrBun2 m.put("usekwh", lineArr[13]); //사용_량(KWh) usekwh
		   list.add(m);
		   System.out.println("종료 : " + list); br.close();
		   isr.close();
		   return "main/readfile";
	   }
	   
}
