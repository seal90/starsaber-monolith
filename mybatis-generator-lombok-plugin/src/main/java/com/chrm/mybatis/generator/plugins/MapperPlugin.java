package com.chrm.mybatis.generator.plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
public class MapperPlugin extends PluginAdapter {

    private Set<FullyQualifiedJavaType> dataAnnotations;

    public MapperPlugin() {
        dataAnnotations = new HashSet<FullyQualifiedJavaType>(2);
        dataAnnotations.add(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper"));
        dataAnnotations.add(new FullyQualifiedJavaType("org.springframework.stereotype.Repository"));
    }
    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        interfaze.addImportedTypes(dataAnnotations);
        interfaze.addAnnotation("@Repository");
        interfaze.addAnnotation("@Mapper");
        return true;
    }

}
