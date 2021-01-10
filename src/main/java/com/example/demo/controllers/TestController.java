package com.example.demo.controllers;

import com.example.demo.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    TestService testService;

    @Autowired
    TestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(path = "/testList", method = RequestMethod.GET)
    public List<String> getTestList() {
        return testService.getTestService();
    }
}
