package com.springboot.api.controller;

import java.util.Map;

import org.slf4j.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.MemberDto;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);
    //@RequestMapping으로 구현하기
    //http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        LOGGER.info("getHello 메소드가 호출되었습니다.");
        return "Hello World";
    }
    //매개변수가 없는 GET메소드 구현
    //http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName() {
        return "Flature";
    }
    //@PathVariable을 활용한 GET 메소드 구현
    //http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        LOGGER.info("@Pathvariable을 통해 들어온 값 : {}", variable);
        return variable;
    }
    //규칙: @GetMapping 어노테이션 값으로 URL을 입력할 때 중괄호를 사용해 어느 위치에서 값을 받을지 지정해야한다.
    //또한 메소드의 매개변수와 그 값을 연결하기 위해 3번 줄과 같이 @PathVariable을 명시하며, @GetMapping 어노테이션과
    //@PathVariabl에 지정된 변수의 이름을 동일하게 맞춰야 한다.
    //만약 변수명을 다르게 하려면 아래와 같이 작성한다.

    //http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }
    
    //@RequestParam을 활용한 GET메소드 구현
    //URI에서 '?'를 기준으로 우측에 '{키}={값}'
    //http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @ApiOperation(value = "GET 메소드 예제", notes = "@RequestParam을 활용한 GET Method")//Swagger 사용 어노테이션
    @GetMapping(value = "/request1")
    public String getRequestParam1(
       @ApiParam(value = "이름", required = true) @RequestParam String name,/*@ApiParam => Swagger 사용 어노테이션*/
       @ApiParam(value = "이메일", required = true) @RequestParam String email,
       @ApiParam(value = "회사", required = true) @RequestParam String organization
    ) {
        return name + " " + email + " " + organization;
    }
    //만약 쿼리스트링에 어떤 값이 들어올지 모른다면 Map 객체를 활용할 수도 있다
    //예를 들어 회원가입 관련 API에서 사용자는 회원가입을 하면서 ID같은 필수항목이 아닌 취미 같은 선택 항목에 대해서는 값을 기입하지
    //않는 경우가 있다. 이런 경우에는 매개변수의 항목이 일정하지 않을 수 있어 Map 객체로 받는 것이 효율적이다.
    //http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value="/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        }); 
        return sb.toString();
    }
    //DTO 객체를 활용한 GET메소드 구현
    //http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
    @GetMapping(value="/request3")
    public String getMethodName(MemberDto memberDto) {
        return memberDto.toString();
    }
    
}
