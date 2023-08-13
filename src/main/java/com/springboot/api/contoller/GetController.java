package com.springboot.api.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    //@RequestMapping으로 구현하기
    //http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
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
    
}
