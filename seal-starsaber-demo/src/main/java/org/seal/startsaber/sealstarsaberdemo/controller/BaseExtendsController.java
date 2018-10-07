package org.seal.startsaber.sealstarsaberdemo.controller;

import org.seal.starsaber.arch.exception.ServiceException;
import org.seal.starsaber.arch.http.ResponseOkEntity;
import org.seal.startsaber.sealstarsaberdemo.base.controller.BaseController;
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
@RequestMapping("/baseExtends")
public class BaseExtendsController extends BaseController {

    @GetMapping("/okResponse")
    public ResponseOkEntity<String> okResponse(){
        return ok("hello world");
    }

    @GetMapping("/exceptionResponse")
    public ResponseOkEntity<String> exceptionResponse(){
        serviceException("hello exception");
//        throw new ServiceException("hello error");
        return ok("hello world");
    }
}
