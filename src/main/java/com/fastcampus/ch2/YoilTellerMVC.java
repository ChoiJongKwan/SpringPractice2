package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC {
    @RequestMapping("/getYoilMVC") // http://localhost:8080/ch2/getYoil?year=2021&month=10&day=1
    	public String main( int year, int month,int day, Model model) throws IOException {
        // 1. 유효성 검사
    	if(!isValid(year, month, day)) {
    		return "yoilError";
    	}
        // 2. 요청 계산
       char yoil= getYoil(year, month, day);
        
       //3. 계산한 결과를 model에 저장
       model.addAttribute("year",year);
       model.addAttribute("month",month);
       model.addAttribute("day",day);
       model.addAttribute("yoil",yoil);
       
       
       
        return "yoil";// jsp 파일  WEB-INF/views/yoil.jsp
        
    }

	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
       return " 일월화수목금토".charAt(dayOfWeek);
	}
}