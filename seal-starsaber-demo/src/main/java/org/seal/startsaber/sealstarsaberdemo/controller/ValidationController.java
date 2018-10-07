package org.seal.startsaber.sealstarsaberdemo.controller;

import org.seal.startsaber.sealstarsaberdemo.base.controller.BaseController;
import org.seal.startsaber.sealstarsaberdemo.entity.ValidationDemoEntity;
import org.seal.startsaber.sealstarsaberdemo.base.valid.DataValid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@RestController
@RequestMapping("/validation")
@Validated
public class ValidationController extends BaseController {

    @GetMapping("/methodValid")
    public void methodValid(@Max(value = 150)  Integer age){

        System.out.println(age);
    }

    @GetMapping("/objectValid")
    public void objectValid(@Valid ValidationDemoEntity entity){
        System.out.println(entity);
    }

    @GetMapping("/dataValid")
    public void dataValid(@DataValid String name){
        System.out.println(name);
    }
}
