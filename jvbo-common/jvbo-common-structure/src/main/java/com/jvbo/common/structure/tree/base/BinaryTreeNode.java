/*
 * BinaryTreeNode.java 2018年3月23日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.structure.tree.base;

/**
 * 二叉树实现-递归节点法/左右链表示法
 * @ClassName: BinaryTreeNode 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月23日
 */
public class BinaryTreeNode {
    
    private int data;// 数据
    private BinaryTreeNode leftChild;// 左子引用
    private BinaryTreeNode rightChild;// 右子引用
    
    public BinaryTreeNode(){}
    
    public BinaryTreeNode(int data, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     * @return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return the leftChild
     */
    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    /**
     * @param leftChild the leftChild to set
     */
    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * @return the rightChild
     */
    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    /**
     * @param rightChild the rightChild to set
     */
    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }
    
}
