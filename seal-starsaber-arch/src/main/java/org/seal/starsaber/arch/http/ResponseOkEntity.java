package org.seal.starsaber.arch.http;

import lombok.Data;
import org.springframework.http.HttpStatus;


/**
 * @author seal
 * @version v1.0.0
 * @description 正确信息返回
 * @createTime 2018-10-01 09:03:07
 */
@Data
public class ResponseOkEntity<T> {

    public static <T> ResponseOkEntity<T> create(T data){
        ResponseOkEntity entity = new ResponseOkEntity();
        entity.setCode(HttpStatus.OK.getReasonPhrase());
        entity.setStatus(HttpStatus.OK.value());
        entity.setData(data);
        entity.setMessage("success");
        return entity;
    }

    public static <T> ResponseOkEntity<T> create(String message, T data){
        ResponseOkEntity entity = new ResponseOkEntity();
        entity.setCode(HttpStatus.OK.getReasonPhrase());
        entity.setStatus(HttpStatus.OK.value());
        entity.setData(data);
        entity.setMessage(message);
        return entity;
    }

    private String code;
    private Integer status;
    private T data;
    private String message;
}
