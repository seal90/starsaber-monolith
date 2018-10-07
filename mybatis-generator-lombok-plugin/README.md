# MyBatis Generator Lombok plugin and Comment

## 实现的功能

- 主要整合了lombok插件实现getter/setter等通用方法的自动生成，同时自定义实现了一个注释生成器，
通过抓取数据库表里面的注释作为实体类的注释内容。

## 插件的用法

- 如果你想在你的maven中使用,就直接`git clone`这个项目到你的IDEA，然后使用`maven clean install`将这个项目添加到Maven仓库里去。
之后你只要在你的要使用这个插件的项目的pom.xml中加入如下内容便可：

```xml

<plugin>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-maven-plugin</artifactId>
    <version>1.3.2</version>
    <configuration>
        <overwrite>true</overwrite>
    </configuration>
    <dependencies>
        <dependency>
            <groupId>com.chrm</groupId>
            <artifactId>mybatis-generator-lombok-plugin</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
</plugin>

```

同时添加配置文件`generatorConfig.xml`,使用的时候请根据项目需要自行修改对应配置

```xml


<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
		PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
		"http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
	<classPathEntry
			location="E:/Maven/LocalRepository/mysql/mysql-connector-java/5.1.34/mysql-connector-java-5.1.34.jar" />
	<context id="MysqlTables" targetRuntime="MyBatis3" defaultModelType="flat">

		<property name="javaFileEncoding" value="UTF-8"/>
		<!-- 分页相关 -->
		<plugin type="org.mybatis.generator.plugins.RowBoundsPlugin" />
		<!-- 带上序列化接口 -->
		<plugin type="org.mybatis.generator.plugins.SerializablePlugin" />
		<!-- 自定义的注释生成插件-->
		<plugin type="com.chrm.mybatis.generator.plugins.CommentPlugin">
			<!-- 抑制警告 -->
			<property name="suppressTypeWarnings" value="true" />
			<!-- 是否去除自动生成的注释 true：是 ： false:否 -->
			<property name="suppressAllComments" value="false" />
			<!-- 是否生成注释代时间戳-->
			<property name="suppressDate" value="true" />
		</plugin>
		<!-- 整合lombok-->
		<plugin type="com.chrm.mybatis.generator.plugins.LombokPlugin" >
			<property name="hasLombok" value="true"/>
		</plugin>

		<jdbcConnection driverClass="com.mysql.jdbc.Driver"
						connectionURL="jdbc:mysql://localhost:3306/sf-quiz?useUnicode=true&amp;characterEncoding=UTF-8"
						userId="root" password="362427gg">
		</jdbcConnection>

		<javaTypeResolver>
			<property name="forceBigDecimals" value="false" />
		</javaTypeResolver>

		<!-- 实体生成目录配置 -->
		<javaModelGenerator targetPackage="com.chrm.inforsServer.dataobject"
							targetProject="src/main/java">
			<property name="enableSubPackages" value="false" />
			<property name="trimStrings" value="true" />
		</javaModelGenerator>

		<!-- mapper.xml接口生成目录配置 -->
		<sqlMapGenerator targetPackage="sqlmap/com/chrm/inforsServer.mapper" targetProject="src/main/resources">
			<property name="enableSubPackages" value="true" />
		</sqlMapGenerator>

		<!-- mapper接口生成目录配置 -->
		<javaClientGenerator type="XMLMAPPER"
							 targetPackage="com.chrm.inforsServer" targetProject="src/main/java">
			<property name="enableSubPackages" value="true" />
		</javaClientGenerator>

		<!--表格实体配置-->
		<table tableName="award" domainObjectName="AwardDo">
			<generatedKey column="award_id" sqlStatement="JDBC" identity="true" />
		</table>

	</context>
</generatorConfiguration>


```

## Author
- GuoGuiRong 你的孤独 虽败犹荣

