package com.bin.study.changelog.dynamicchangeloglevel.controller;

import com.bin.study.changelog.dynamicchangeloglevel.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private ComputeService service;
    @RequestMapping(value="/test")
    public  String  test(String name ){


        return "Hi world is finished!"+name;
    }

    @RequestMapping(value="/compute")
    public  Integer compute(int a )
    {

    return service.compute(a);

    }

    /**
     *
     *
     * @param className:需要带包名
     * @param level  10000  Debug;20000 Info;30000 Warn ;40000 Error
     * @return
     */
    @RequestMapping(value="/changeLevel")
    public  String changeLevel(String className,int  level)  //className
    {

        return service.changeLevel(className,level);

    }

}
