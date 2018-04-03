/*
 * MySQLPaginationPlugin.java 2016年10月15日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.framework.mybatis.pageplugin;

import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * MySQLPaginationPlugin
 * @ClassName: MySQLPaginationPlugin 
 * @Description: TODO
 * @author jvbo
 * @date 2016年10月15日
 */
public class MySQLPaginationPlugin extends PluginAdapter {

    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        // add field, getter, setter for limit clause
        addPage(topLevelClass, introspectedTable, "page");
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }
 
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
            IntrospectedTable introspectedTable) {
        XmlElement page = new XmlElement("if");
        page.addAttribute(new Attribute("test", "page != null"));
        page.addElement(new TextElement("limit #{page.begin} , #{page.rows}"));
        element.addElement(page);
 
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }
 
    private void addPage(TopLevelClass topLevelClass, IntrospectedTable introspectedTable,
            String name) {
        topLevelClass.addImportedType(new FullyQualifiedJavaType(
                "com.jvbo.framework.mybatis.pageplugin.Page"));
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(new FullyQualifiedJavaType("com.jvbo.framework.mybatis.pageplugin.Page"));
        field.setName(name);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(new FullyQualifiedJavaType(
                "com.jvbo.framework.mybatis.pageplugin.Page"), name));
        method.addBodyLine("this." + name + "=" + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("com.jvbo.framework.mybatis.pageplugin.Page"));
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }
 
    public boolean validate(List<String> warnings) {
        return true;
    }

}
