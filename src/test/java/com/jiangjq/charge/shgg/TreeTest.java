package com.jiangjq.charge.shgg;

import com.jiangjq.charge.ChargeApplicationTests;
import com.jiangjq.charge.entity.Person;
import com.jiangjq.charge.tree.TreeNode;
import org.junit.Test;

/**
 * @author jjq
 * @version 1.0
 * @date 2019/10/19
 * @desc
 */
public class TreeTest extends ChargeApplicationTests {

    @Test
    public void preOrder(){
        initSanguoTree().preOrder();
    }

    @Test
    public void midOrder(){
        initSanguoTree().midOrder();
    }

    @Test
    public void afterOrder(){
        initSanguoTree().afterOrder();
    }

    @Test
    public void afterOrderSearch(){
        Person liubei  = new Person("刘备", 90);
        Person person = initSanguoTree().afterOrderSearch(liubei);
        System.out.println("result:"+ person);
    }


    /**
     * 初始化一棵树
     */
    private  static TreeNode<Person> initSanguoTree(){
        Person liubei  = new Person("刘备", 9);
        Person zhaoyun = new Person("赵云", 7);
        Person guanyu = new Person("关羽", 6);
        Person guanxing = new Person("关左兴", 3);
        Person guanbao = new Person("关右苞", 4);
        TreeNode<Person> guanbaoN= new TreeNode<>(guanbao, null, null, null);
        TreeNode<Person> guanxingN= new TreeNode<>(guanxing, null, null, null);
        TreeNode<Person> guanyuN= new TreeNode<>(guanyu, null, guanxingN, guanbaoN);
        TreeNode<Person> zhaoyunN= new TreeNode<>(zhaoyun, null, null, null);
        TreeNode<Person> liubeiN= new TreeNode<>(liubei, null, zhaoyunN, guanyuN);

        return liubeiN;
    }
}
