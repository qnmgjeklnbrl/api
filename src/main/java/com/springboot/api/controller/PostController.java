package com.springboot.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.MemberDto;

import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
    //@RequestMapping 으로 구현하기
    //http://localhost:8080/api/v1/post-api/domain
    @RequestMapping(value="/domain", method=RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }
    //@RequestBody를 활용한 POST 메소드 구현
    //http://localhost:8080/api/v1/post-api/member
    @PostMapping(value="/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n"); 
        });

        return sb.toString();
    }
    //DTO 객체를 활용한 POST API 구현
    //http://localhost:8080/api/v1/post-api/member2
    @PostMapping(value="/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

}
        

        
        
