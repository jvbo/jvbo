/*
 * App.java 2018年3月23日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.structure.tree;

public class App {
    
    /**
     * 概念
     * 1. 根节点,父节点,孩子节点,叶子节点;
     * 2. 节点的度,树的度,节点的层次,树的高度,树的深度;
     * 
     * 常见的树
     * 1. 二叉树;
     * 2. 平衡二叉树;
     * 3. B树(二叉排序树);
     * 4. B+树;
     * 5. 哈夫曼树;
     * 6. 堆;
     * 7. 红黑树;
     */
    
    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree(null);
        binarySortTree.insert(8);
        binarySortTree.insert(3);
        binarySortTree.insert(1);
        binarySortTree.insert(6);
        binarySortTree.insert(4);
        binarySortTree.insert(7);
        binarySortTree.insert(10);
        binarySortTree.insert(13);
        binarySortTree.insert(14);
        
        // 先序遍历
        BinaryTree.preOrder(binarySortTree.getRoot());
        System.out.println();
        // 中序遍历
        BinaryTree.inOrder(binarySortTree.getRoot());
        System.out.println();
        // 后序遍历
        BinaryTree.postOrder(binarySortTree.getRoot());
        System.out.println("\n");
        // 删除
        binarySortTree.delete(3);
        // 先序遍历
        BinaryTree.preOrder(binarySortTree.getRoot());
        System.out.println();
        // 中序遍历
        BinaryTree.inOrder(binarySortTree.getRoot());
        System.out.println();
        // 后序遍历
        BinaryTree.postOrder(binarySortTree.getRoot());
        System.out.println();
    }
}
