package org.seal.startsaber.sealstarsaberdemo.mytest;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.SimpleType;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.core.io.InputStreamSource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

public class ObjectMapperTest {

    public static void main5(String[] args) throws ClassNotFoundException, JsonProcessingException {
        SimpleModule module = new SimpleModule();
        module.addSerializer(new ClassStdSerializer(A.class));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);
        B d = new B();
        String val = objectMapper.writeValueAsString(d);

        System.out.println(val);
    }

    public static void main4(String[] args) throws JsonProcessingException {
        JavaType javaType = ReferenceType.constructUnsafe(C.class);

        SimpleModule module = new SimpleModule();
        module.addSerializer(new TypeStdSerializer(javaType));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);
        D b = new D();
        String val = objectMapper.writeValueAsString(b);
        System.out.println(val);
    }

    public static void main3(String[] args) throws JsonProcessingException {
        JavaType javaType = ReferenceType.constructUnsafe(A.class);

        SimpleModule module = new SimpleModule();
        module.addSerializer(new TypeStdSerializer(javaType));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);
        B b = new B();
        String val = objectMapper.writeValueAsString(b);
        System.out.println(val);
    }

    public static void main2(String[] args) throws ClassNotFoundException, JsonProcessingException {
        SimpleModule module = new SimpleModule();
        module.addSerializer(new ClassStdSerializer(Class.forName("java.io.File")));
        module.addSerializer(new ClassStdSerializer(Class.forName("java.lang.Integer")));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);

        String val = objectMapper.writeValueAsString(1);

        System.out.println(val);
    }

    public static void main(String[] args) throws JsonProcessingException {
        StdSerializer<B> objectStdSerializer = new StdSerializer<B>(B.class){

            @Override
            public void serialize(B value, JsonGenerator gen, SerializerProvider provider) throws IOException {
                System.out.println("B");
            }
        };

        StdSerializer<A> stdSerializer = new StdSerializer<A>(A.class){

            @Override
            public void serialize(A value, JsonGenerator gen, SerializerProvider provider) throws IOException {
                System.out.println("A");
            }
        };

        SimpleModule module = new SimpleModule();
        module.addSerializer(stdSerializer);
//        module.addSerializer(objectStdSerializer);


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(module);

//        File file = new File("d:/default");
//        String val = objectMapper.writeValueAsString(file);
        B a = new B();
        objectMapper.writeValueAsString(a);



//        System.out.println(val);


    }
}
class A{}
class B extends A{
    String name = "Class ";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface C{}
class D implements C{
    String name = "Class D";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ClassStdSerializer<T> extends StdSerializer<T>{

    public ClassStdSerializer(Class t) {
        super(t);
    }

    @Override
    public void serialize(T value, JsonGenerator gen, SerializerProvider provider) throws IOException {

    }
}
class TypeStdSerializer<T> extends StdSerializer<T>{


    protected TypeStdSerializer(JavaType type) {
        super(type);
    }

    @Override
    public void serialize(T value, JsonGenerator gen, SerializerProvider provider) throws IOException {

    }
}