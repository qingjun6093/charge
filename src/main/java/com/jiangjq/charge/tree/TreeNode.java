package com.jiangjq.charge.tree;

import com.jiangjq.charge.entity.Person;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/10/19
 * @desc 二叉树的简单定义
 */
public class TreeNode<T> {

    private T data;

    private TreeNode parent;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(T data, TreeNode parent, TreeNode left, TreeNode right) {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    /**
     * 前序遍历--先输出父节点,再输出左节点然后输出右节点
     * @return
     */

    public void preOrder(){
        System.out.println(this.getData().toString());
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历--先输出左节点,再输出父节点然后输出右节点
     * @return
     */

    public void midOrder(){
        if (this.left != null){
            this.left.midOrder();
        }
        System.out.println(this.getData().toString());
        if (this.right != null){
            this.right.midOrder();
        }

    }

    /**
     * 后序遍历--先输出左节点,再输出右节点然后输出父节点
     * @return
     */

    public void afterOrder(){
        if (this.left != null){
            this.left.afterOrder();
        }
        if (this.right != null){
            this.right.afterOrder();
        }
        System.out.println(this.getData());
    }

    /**
     * 后续遍历查找
     * @param t
     * @return
     */
    public T afterOrderSearch(T t){
        if (this.left != null){
            this.left.afterOrderSearch(t);
        }
        if (this.right != null){
            this.right.afterOrderSearch(t);
        }
        T data = this.getData();
        if (data.equals(t)){
            return t;
        }
        return null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data.toString() +
                '}';
    }
}
