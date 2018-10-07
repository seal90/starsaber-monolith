package org.seal.starsaber.arch.controller;

import org.seal.starsaber.arch.exception.ServiceException;
import org.seal.starsaber.arch.http.ResponseOkEntity;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
public abstract class StarSaberController {

    protected ResponseOkEntity<String> ok(){
        return ResponseOkEntity.create("success");
    }

    protected <T> ResponseOkEntity<T> ok(T data){
        return ResponseOkEntity.create(data);
    }

    protected <T> ResponseOkEntity<T> ok(String message,T data){
        return ResponseOkEntity.create(message, data);
    }

    protected void serviceException(String message){
        throw new ServiceException(message);
    }

    protected <T> void serviceException(String message, T data){
        throw new ServiceException(message, data);
    }
}
