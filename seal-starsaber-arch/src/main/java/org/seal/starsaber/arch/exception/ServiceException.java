package org.seal.starsaber.arch.exception;

import lombok.Data;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Data
public class ServiceException extends RuntimeException {
    /**
     * 返回数据
     */
    private Object data;

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String message, Object data){
        super(message);
        this.data = data;
    }
}
