package org.seal.startsaber.sealstarsaberdemo.controller;

import org.seal.starsaber.arch.exception.ServiceException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@RestController
@RequestMapping("/exceptiondemo")
public class ExceptionDemoController {

    @GetMapping("/zeroException")
    public void zeroException(){
        int a = 1/0;
    }

    @GetMapping("/serviceException")
    public void serviceException(){
        throw new ServiceException("service exception");
    }
}
