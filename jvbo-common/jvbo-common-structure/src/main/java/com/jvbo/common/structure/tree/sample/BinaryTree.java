/*
 * BinaryTree.java 2018年3月23日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.structure.tree.sample;

import com.jvbo.common.structure.tree.base.BinaryTreeNode;

/**
 * 二叉树
 * @ClassName: BinaryTree 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月23日
 */
public class BinaryTree {
	/**
	 * 定义:二叉树是有限个节点的集合,这个集合可以是空集,也可以是一个根节点和至多两个二叉树组成的集合,
	 * 其中一棵树叫做根的左子树,另一棵叫做根的右子树;
	 */

    /**
     * 主要方法:
     * 1. 创建;
     * 2. 添加;
     * 3. 删除;
     * 4. 清空;
     * 5. 遍历(先序遍历,中序遍历,后序遍历);这里先序,中序,后序指的是根节点相对左右子树的遍历顺序
     * 6. 获取树高度;
     * 7. 获取树节点数;
     * 8. 获取某节点的父节点;
     * ...
     */
    
    private BinaryTreeNode root;// 根节点
    
    public BinaryTree(){}
    
    public BinaryTree(BinaryTreeNode root){
        this.root = root;
    }

    /**
     * @return the root
     */
    public BinaryTreeNode getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }
    
    /**
     * 添加为左子树
     * @Description: TODO
     * @param @param child   
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public void insertAsLeftChild(BinaryTreeNode child){
        checkTreeEmpty();
    }

    /**
     * 添加为右子树
     * @Description: TODO
     * @param @param child   
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public void insertAsRightChild(BinaryTreeNode child){
        
    }
    
    /**
     * 删除
     * @Description: TODO
     * @param @param node   
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public void deleteNode(BinaryTreeNode node){
        checkTreeEmpty();
        if(node == null)// 递归出口
            return;
        deleteNode(node.getLeftChild());
        deleteNode(node.getRightChild());
        node = null;
    }
    
    /**
     * 清空
     * @Description: TODO
     * @param    
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public void clear(){
        if(root != null)
            deleteNode(root);
    }
    
    /**
     * 获得树高度
     * @Description: TODO
     * @param    
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public int getTreeHeight(){
        return getHeight(root);
    }
    
    /**
     * 获取指定节点的度
     * @Description: TODO
     * @param @param node
     * @param @return   
     * @return int  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public int getHeight(BinaryTreeNode node) {
        if(node == null)
            return 0;
        int leftChildHeight = getHeight(node.getLeftChild());
        int rightChildHeight = getHeight(node.getRightChild());
        int max = Math.max(leftChildHeight, rightChildHeight);
        return max + 1;// 自己本身
    }
    
    /**
     * 获取二叉树的节点数
     * @Description: TODO
     * @param @return   
     * @return int  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public int size(){
        return getChildSize(root);
    }
    
    /**
     * 获取指定节点的子节点数
     * @Description: TODO
     * @param @param root2
     * @param @return   
     * @return int  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public int getChildSize(BinaryTreeNode node) {
        if(node == null)
            return 0;
        int leftChildSize = getChildSize(node.getLeftChild());
        int rightChildSize = getChildSize(node.getRightChild());
        return leftChildSize + rightChildSize + 1;
    }
    
    /**
     * 获取指定节点的父节点
     * @Description: TODO
     * @param @param node
     * @param @return   
     * @return BinaryTreeNode  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public BinaryTreeNode getParent(BinaryTreeNode node){
        // 思考: 从根节点自顶向下遍历各个子树,若该子树的根节点的孩子就是目标节点,返回该节点,否则遍历其左右子树
        if(root == null || root == node)// 空树或者node就是root,返回null
            return null;
        else
            return getParent(root, node);// 递归查找父节点
    }
    
    /**
     * 递归对比:节点的孩子节点与指定节点是否一致
     * @Description: TODO
     * @param @param subTreeRoot 子树的根节点
     * @param @param node 指定节点
     * @param @return   
     * @return BinaryTreeNode  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public BinaryTreeNode getParent(BinaryTreeNode subTreeRoot, BinaryTreeNode node) {
        // 如果子树为空,则没有父节点;
        // 递归出口1
        if(subTreeRoot == null)
            return null;
        // 正好这个根节点的左右孩子之一与目标节点一致;
        // 递归出口2
        if(subTreeRoot.getLeftChild() == node || subTreeRoot.getRightChild() == node)
            return subTreeRoot;
        // 遍历这个节点的左右子树
        BinaryTreeNode parent = null;
        if((parent = getParent(subTreeRoot.getLeftChild(), node)) != null)// 左子树节点就是指定节点
            return parent;
        else
            return getParent(subTreeRoot.getRightChild(), node);// 右子树节点就是指定节点
    }
    
    /**
     * 先序遍历:先根,再左,后右,退出
     * @Description: TODO
     * @param @param node   
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public static void preOrder(BinaryTreeNode node){
        if(node == null)
            return;
        operate(node);
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());
    }

    /**
     * 中序遍历:先左,再根,后右,退出
     * @Description: TODO
     * @param @param node   
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public static void inOrder(BinaryTreeNode node){
        if(node == null)
            return;
        inOrder(node.getLeftChild());
        operate(node);
        inOrder(node.getRightChild());
    }
    
    /**
     * 后序遍历:先左,再右,后根,退出
     * @Description: TODO
     * @param @param node   
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public static void postOrder(BinaryTreeNode node){
        if(node == null)
            return;
        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        operate(node);
    }
    
    /**
     * 模拟操作
     * @Description: TODO
     * @param @param node   
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public static void operate(BinaryTreeNode node) {
        if(node == null)
            return;
        System.out.print(node.getData() + ",");
    }

    /**
     * 检查根节点是否为空
     * @Description: TODO
     * @param    
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    private void checkTreeEmpty() {
        if(root == null){
            throw new IllegalStateException("root为空");
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
}
