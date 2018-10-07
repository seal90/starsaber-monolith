package org.seal.starsaber.arch.service;

import org.seal.starsaber.arch.exception.ServiceException;
import org.seal.starsaber.arch.util.UUIDGen;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
public abstract class StarSaberService {

    protected void serviceException(String message){
        throw new ServiceException(message);
    }

    protected <T> void serviceException(String message, T data){
        throw new ServiceException(message, data);
    }

    protected String genId(){
        return UUIDGen.genNextId();
    }
}
