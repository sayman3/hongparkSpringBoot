package com.example.hongparkSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("hi")
    public String niceToMeetYou(Model model){
        model.addAttribute("username","태완"); //username이라는 변수안에 홍팍이라는 값을 추가한다.
        return "greetings"; //templates폴더 안에 greetings라는 파일을 찾아서 브라우저로 전송.
    }

    @GetMapping("bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname","taewan");
        return "goodbye";
    }
}
