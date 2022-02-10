package com.aws.rooney.web;

import com.aws.rooney.web.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/dto")
    public UserDto checkDto(@RequestParam("name") String name, @RequestParam("age") Integer age) {

        return new UserDto(name, age);
    }
}
