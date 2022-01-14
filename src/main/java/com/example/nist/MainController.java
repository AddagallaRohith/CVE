package com.example.nist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {
    @Autowired
    private MainService mainService;

    @GetMapping("/start/{value}")
    public String start(@PathVariable String value) throws InterruptedException {
        System.out.println("cpmong");
        Map<String, List<Object>> map = new HashMap<>();

        map.put("resultsPerPage",Arrays.asList(20));
        map.put("startIndex",Arrays.asList(0));
        mainService.getDetails(map);
        return "success";
    }
}
