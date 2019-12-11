package com.jiangjq.charge.tree;

import com.jiangjq.charge.entity.Person;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/10/19
 * @desc 二叉树的简单定义
 */
public class TreeNode<T extends Comparable> {

    private T data;

    private TreeNode parent;

    private TreeNode root;

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



    public void afterOrder1(){
        if (this.root.left != null){
            this.root.left.afterOrder();
        }
        if (this.root.right != null){
            this.root.right.afterOrder();
        }
        System.out.println(this.root.getData());
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

    /**
     * 查找
     * @param t target
     * @return
     */
    public T find(T t){
        System.out.println(root);
       if (root == null){
           return null;
       }
       if (root.data.compareTo(t) > 0){
           root = root.right;
           return root == null ? null : find(t);
       }else if (root.data.compareTo(t) < 0){
           root = root.left;
           return root == null ? null : find(t);
       }else {
           return t;
       }
    }

    /**
     * 红黑树的插入(非递归)
     * @param t target
     * @return
     */
    public void insert(T t){
        if (t == null){
            return ;
        }
        TreeNode tn = new TreeNode(t, null, null, null);
        if (root == null){
            root = tn;
        }else {
            TreeNode cn = root;
            TreeNode parent;
            for(;;){
                parent = cn;

                if (parent.data.compareTo(t) < 0){
                    //放左边
                    cn = parent.left;
                    if (cn == null){
                        parent.left = tn;
                        return;
                    }
                }else if (parent.data.compareTo(t) > 0){
                    //往右放
                    cn = parent.right;
                    if (cn == null){
                        parent.right = tn;
                        return;
                    }
                }else {
                    //do nothing
                }
            }
        }
    }

    //getter and setter

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

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data.toString() +
                '}';
    }
}
