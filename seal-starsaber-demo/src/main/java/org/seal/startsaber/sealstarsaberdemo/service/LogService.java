package org.seal.startsaber.sealstarsaberdemo.service;

import org.springframework.stereotype.Service;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@Service
public class LogService {

    public void serviceExceptionLog() {
        int a = 1/0;
        System.out.println(a);
    }
}
