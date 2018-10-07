package org.seal.startsaber.sealstarsaberdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.seal.starsaber.arch.http.ResponseOkEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Api(value ="api ui demo 类", tags = {"api ui demo tag 标签"})
@RestController
@RequestMapping("/apiui")
public class ApiUiController {


    @GetMapping("/responseString")
    public ResponseEntity<String> responseString(){
        ResponseEntity<String> responseEntity = new ResponseEntity<>("hello entity", HttpStatus.OK);
        return responseEntity;
    }

    @ApiOperation("获取响应")
    @GetMapping("/responseEntity")
    public ResponseEntity<ResponseEntityDemo> responseEntity(){
        ResponseEntityDemo responseEntityDemo = new ResponseEntityDemo();
        responseEntityDemo.setAge(new Date());
        responseEntityDemo.setName("hello");
        responseEntityDemo.setLocalDateTime(LocalDateTime.now());
        ResponseEntity<ResponseEntityDemo> responseEntity = new ResponseEntity<>(responseEntityDemo, HttpStatus.OK);
        return responseEntity;
    }

    @Data
    @ApiModel(value="ApiModel value 描述",description="ApiModel description 描述")
    class ResponseEntityDemo {

        @ApiModelProperty(value="姓名 value",name="姓名 name",required=true)
        String name;
        Date age;
        LocalDateTime localDateTime;
    }

    @ApiOperation(value = "获取响应 Value", tags = {"获取响应 Tag"}, notes = "获取响应 notes")
    @GetMapping("/responseOkEntity")
    public ResponseOkEntity<ResponseEntityDemo> responseOkEntity(){
        ResponseEntityDemo responseEntityDemo = new ResponseEntityDemo();
        responseEntityDemo.setAge(new Date());
        responseEntityDemo.setName("hello");
        responseEntityDemo.setLocalDateTime(LocalDateTime.now());
        ResponseOkEntity<ResponseEntityDemo> responseEntity = new ResponseOkEntity<>();
        responseEntity.setData(responseEntityDemo);
        return responseEntity;
    }
}
