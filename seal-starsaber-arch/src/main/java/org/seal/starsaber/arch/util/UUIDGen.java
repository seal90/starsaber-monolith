package org.seal.starsaber.arch.util;

import java.util.UUID;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
public class UUIDGen {

    public static String genNextId(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }
}
