package org.seal.starsaber.sealstarsaberinitializer;

import org.junit.Test;

import java.io.File;

/**
 * @author seal
 * @version v1.0
 * @description
 * @createTime 2018-09-30 17:06
 * @email
 */
public class FileListTest {

    @Test
    public void fileListTest(){
        File file = new File("E:\\idea\\seal-env\\seal-env-service\\seal-starsaber-initializer\\src\\main\\resources\\templates");
        File[] files = file.listFiles();
        for(File file1 : files){
            System.out.println(file1.getName());
        }
    }
}
