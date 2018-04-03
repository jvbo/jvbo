/*
 * BinarySortTree.java 2018年3月23日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.structure.tree;

/**
 * 二叉排序树(二叉查找树:BinarySearchTree)(B树)
 * @ClassName: BinarySortTree 
 * @Description: TODO
 * @author jvbo
 * @date 2018年3月23日
 */
public class BinarySortTree {
    /**
     * 性质:
     * 1. 若左子树不空,则左子树上所有节点的值均小于它的根节点的值;
     * 2. 若右子树不空,则右子树上所有节的值均大于或等于它的根节点的值;
     * 3. 左,右子树也分别为二叉排序树
     * 
     * 查找(二分查找) {@link #search(int)} : 
     * 1. 先比较它与根节点,相等就返回;根节点若为空,则树为空,直接返回
     * 2. 如果它比根节点小,就从根节点的左子树里进行查找;
     * 3. 如果他比根节点大,就从根节点的右子树里进行查找;
     * 
     * 插入(注意除了设置数据,还需要和父节点绑定) {@link #insert(int)}}:
     * 1. 先查找有没有整个元素,有的话就不用插入了,直接返回;
     * 2. 没有就插入到之前查到(对比)好的合适位置;
     * 
     * 删除 {@link #delete(int)}} :
     * 1. 如果删除的节点正好是叶子节点,直接删除;
     * 2. 如果要删除的节点还有子节点,就需要建立父子节点的关系;
     *      a. 如果只有左孩子或者右孩子,直接把这个孩子上移放到要删除的位置;
     *      b. 如果有两个孩子,就需要选一个合适的孩子节点作为新的根节点,该节点称为继承节点;
     *      注:这里如果新节点要求比所有左子树大,比所有右子树小的话,可以从右子树里找最小的或者左子树里找最大的;
     */
    
    private BinaryTreeNode root;

    public BinarySortTree(BinaryTreeNode root) {
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
     * 在整个树中查找数据
     * @Description: TODO
     * @param @param data
     * @param @return   
     * @return BinaryTreeNode  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public BinaryTreeNode search(int data){
        return search(root, data);
    }
    
    /**
     * 在指定二叉排序树中查找数据
     * @Description: TODO
     * @param @param node
     * @param @param data
     * @param @return   
     * @return BinaryTreeNode  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public BinaryTreeNode search(BinaryTreeNode node, int data) {
        if(node == null || node.getData() == data)// 节点为空或者相等,直接返回该节点
            return node;
        if(data < node.getData())//比节点小,就从左子树里递归查找
            return search(node.getLeftChild(), data);
        else// 从右子树查找
            return search(node.getRightChild(), data);
    }
    
    /**
     * 插入到整个树中
     * @Description: TODO
     * @param @param data   
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public void insert(int data){
        if(root == null){// 如果是空树,创建一个
            root = new BinaryTreeNode();
            root .setData(data);
            return;
        }
        searchAndInsert(null, root, data);// 根节点的父节点为null
    }
    
    /**
     * 先查找,后插入
     * @Description: TODO
     * @param @param object
     * @param @param root2
     * @param @param data   
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public BinaryTreeNode searchAndInsert(BinaryTreeNode parent, BinaryTreeNode node, int data) {
        if(node == null){// 当前比较节点为空,说明之前没有这个数据,直接新建,插入;
            node = new BinaryTreeNode();
            node.setData(data);
            if(parent != null)//父节点不为空,绑定关系
                if(data < parent.getData())
                    parent.setLeftChild(node);
                else
                    parent.setRightChild(node);
            return node;
        }
        // 对比的节点不为空
        if(data == node.getData())//已经有了,不用插入了
            return node;
        else if(data < node.getData())// 比节点小,从左子树里查找,插入
            return searchAndInsert(node, node.getLeftChild(), data);
        else// 从右子树查找,插入
            return searchAndInsert(node, node.getRightChild(), data);
    }
    
    /**
     * 删除
     * @Description: TODO
     * @param @param data   
     * @return void  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public void delete(int data){
        if(root == null || root.getData() == data){//根节点为空或者要删除的就是根节点,直接删掉
            root = null;
            return;
        }
        BinaryTreeNode parent = searchParent(data);
        if(parent == null)// 如果父节点为空,说明这个树是空树,直接返回
            return;
        
        // 查找要删除的节点
        BinaryTreeNode deleteNode = search(parent, data);
        if(deleteNode == null)//树中找不到要删除的节点
            return;
        //删除节点4种情况
        // 1. 左右子树都为空,说明是叶子节点,直接删除
        if(deleteNode.getLeftChild() == null && deleteNode.getRightChild() == null){
            // 删除节点
            deleteNode = null;
            // 重置父节点的孩子状态,父节点没有这个子节点了
            if(parent.getLeftChild() != null && parent.getLeftChild().getData() == data)
                parent.setLeftChild(null);
            else
                parent.setRightChild(null);
            return;
        }else if(deleteNode.getLeftChild() != null && deleteNode.getRightChild() == null){
            // 2. 要删除的节点只有左子树,左子树要继承位置
            if(parent.getLeftChild() != null && parent.getLeftChild().getData() == data)
                parent.setLeftChild(deleteNode.getLeftChild());
            else
                parent.setRightChild(deleteNode.getLeftChild());
            deleteNode = null;
            return;
        }else if(deleteNode.getRightChild() != null && deleteNode.getLeftChild() == null){
            // 3. 要删除的节点只有右子树,右子树要继承位置
            if(parent.getLeftChild() != null && parent.getLeftChild().getData() == data)
                parent.setLeftChild(deleteNode.getRightChild());
            else
                parent.setRightChild(deleteNode.getRightChild());
            deleteNode = null;
            return;
        }else{
            // 4. 要删除的的节点儿女双全,既有左子树又有右子树,需要选一个合适的节点继承,这里使用右子树中最左节点
            BinaryTreeNode copyOfDeleteNode = deleteNode;// 要删除节点的副本,指向继承节点的父节点
            BinaryTreeNode heresNode = deleteNode.getRightChild();// 要继承位置的节点,初始为要删除节点的右子树的树根
            // 右子树没有左孩子了,他就是最小的,直接上移
            if(heresNode.getLeftChild() == null){
                // 上移后,兄弟变成了孩子
                heresNode.setLeftChild(deleteNode.getLeftChild());
            }else{// TODO 这个过程需要确认
                // 右子树有左孩子,循环找到最左的,即最小的
                while(heresNode.getLeftChild() != null){
                    copyOfDeleteNode = heresNode;// copyOfDeleteNode指向继承节点的父节点
                    heresNode = heresNode.getLeftChild();
                }
                // 找到了继承节点,继承节点的右子树(如果有的话)要上移一位
                copyOfDeleteNode.setLeftChild(heresNode.getRightChild());
                // 继承节点先继承,把自己左右孩子编程要删除节点的孩子;
                heresNode.setLeftChild(deleteNode.getLeftChild());
                heresNode.setRightChild(deleteNode.getRightChild());
            }
            // 最后确认位置,让要删除节点的父节点重新认识新的子节点
            if(parent.getLeftChild() != null && parent.getLeftChild().getData() == data)
                parent.setLeftChild(heresNode);
            else
                parent.setRightChild(heresNode);
        }
        
    }
    
    /**
     * 在整个树中,查找指定数据节点的父节点
     * @Description: TODO
     * @param @param data
     * @param @return   
     * @return BinaryTreeNode  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public BinaryTreeNode searchParent(int data) {
        return searchParent(null, root, data);
    }

    /**
     * 在指定节点下,查找指定数据节点的父节点
     * @Description: TODO
     * @param @param parent 当前比较节点的父节点
     * @param @param node 当前比较的节点
     * @param @param data 查找的数据
     * @param @return   
     * @return BinaryTreeNode  
     * @throws
     * @author jvbo
     * @date 2018年3月23日
     */
    public BinaryTreeNode searchParent(BinaryTreeNode parent, BinaryTreeNode node, int data) {
        if(node == null)// 比较的节点为空,返回空
            return null;
        if(data == node.getData())// 找到了目标节点,返回父节点
            return parent;
        else if(data < node.getData())// 数据比当前节点小,左子树中递归查找
            return searchParent(node, node.getLeftChild(), data);
        else
            return searchParent(node, node.getRightChild(), data);
    }
}
