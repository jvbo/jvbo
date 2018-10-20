/*
 * LinkedTreeNode.java 2018年3月23日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.structure.tree.base;

/**
 * 树实现-链表
 * @ClassName: LinkedTreeNode 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月23日
 */
public class LinkedTreeNode {
    
    private Object data;// 数据
    private LinkedTreeNode parent;// 父节点的引用
    private LinkedTreeNode child;// 子节点的引用
    
    public LinkedTreeNode(Object data, LinkedTreeNode parent,
            LinkedTreeNode child){
        this.data = data;
        this.parent = parent;
    }
    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }
    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }
    /**
     * @return the parent
     */
    public LinkedTreeNode getParent() {
        return parent;
    }
    /**
     * @param parent the parent to set
     */
    public void setParent(LinkedTreeNode parent) {
        this.parent = parent;
    }
    /**
     * @return the child
     */
    public LinkedTreeNode getChild() {
        return child;
    }
    /**
     * @param child the child to set
     */
    public void setChild(LinkedTreeNode child) {
        this.child = child;
    }

    public static void main(String[] args) {
        //LinkedTreeNode[] linkedTree = new LinkedTreeNode[10];
    }

}
