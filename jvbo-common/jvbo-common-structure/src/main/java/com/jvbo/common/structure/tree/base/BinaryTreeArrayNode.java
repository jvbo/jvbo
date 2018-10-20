/*
 * BinaryTreeArrayNode.java 2018年3月23日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.structure.tree.base;

/**
 * 二叉树实现-数组下标表示法
 * @ClassName: BinaryTreeArrayNode 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月23日
 */
public class BinaryTreeArrayNode {
    
    private Object data;// 数据
    private int leftChild;// 左子下标
    private int rightChild;// 右子下标
    
    public BinaryTreeArrayNode(Object data, int leftChild, int rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
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
     * @return the leftChild
     */
    public int getLeftChild() {
        return leftChild;
    }

    /**
     * @param leftChild the leftChild to set
     */
    public void setLeftChild(int leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * @return the rightChild
     */
    public int getRightChild() {
        return rightChild;
    }

    /**
     * @param rightChild the rightChild to set
     */
    public void setRightChild(int rightChild) {
        this.rightChild = rightChild;
    }
}
