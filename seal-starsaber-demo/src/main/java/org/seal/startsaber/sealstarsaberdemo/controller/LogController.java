package org.seal.startsaber.sealstarsaberdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.seal.startsaber.sealstarsaberdemo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Slf4j
@RestController
@RequestMapping("/logcontroller")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/controllerLog")
    public void controllerLog(){
        log.info("controllerLog");
    }

    @GetMapping("/controllerExceptionLog")
    public void controllerExceptionLog(){
        log.info("controllerExceptionLog");
        int a = 1/0;
        System.out.println(a);
    }

    @GetMapping("/serviceExceptionLog")
    public void serviceExceptionLog(){
        log.info("serviceExceptionLog");
        logService.serviceExceptionLog();

    }

}
