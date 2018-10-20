/*
 * TreeNode.java 2018年3月23日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.structure.tree.base;

/**
 * 树实现-数组
 * @ClassName: TreeNode 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月23日
 */
public class TreeNode {
    
    private Object data;// 存储的数据
    private int parentIndex;// 父节点下标
    
    public TreeNode(Object data, int parentIndex){
        this.data = data;
        this.parentIndex = parentIndex;
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
     * @return the parentIndex
     */
    public int getParentIndex() {
        return parentIndex;
    }

    /**
     * @param parentIndex the parentIndex to set
     */
    public void setParentIndex(int parentIndex) {
        this.parentIndex = parentIndex;
    }
    
    public static void main(String[] args) {
        //TreeNode[] arrayTree = new TreeNode[10]; 
    }
}
