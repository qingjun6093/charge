package com.jiangjq.charge.leetcode.queueandstack;

/**
 * @author jiangjunqing
 * @date 2019/6/11
 * @desc 循环队列-使用固定大小的数组和两个指针来指示起始位置和结束位置。 目的是重用我们之前提到的被浪费的存储。
 *
 * 使用数组实现,包含:
 * 1.置空-setNull
 * 2.获取有效节点长度-getLength
 * 3.获取头节点getHead
 * 4.入队-enqueue
 * 5.出队-dequeue
 */
public class ArrayCycleQueue {

    private int[] data;
    /**
     * 队列头index
     */
    private int head;
    /**
     * 队列尾index
     */
    private int tail;

    private int size;

    public ArrayCycleQueue(int size) {
        data = new int[size];
        this.head = -1;
        this.tail = -1;
        this.size = size;
    }


    /**
     * 出队- 移除队首的一个元素
     * @return
     */
    public boolean dequeue(){
        if(isEmpty()){
            return false;
        }
        if (head == tail){
            head = -1;
            tail = -1;
            return true;
        }
        head = head + 1  < size ? head : -1;
        head++;
        return true;
    }

    /**
     * 入队-往队尾添加一个元素
     * @param element
     * @return
     */
    public boolean enqueue(int element){
        if (isFull()){
            return false;
        }
        if (isEmpty()){
            head = 0;
        }
        tail = tail + 1  < size ? tail : -1;
        data[tail+1] = element;
        tail++;
        return true;
    }

    /**
     * 循环队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return head == -1;

    }

    /**
     * 循环队列是是否满了
     * @return
     */
    public boolean isFull(){
        return ((tail + 1) % size) == head;
        //return  tail + head + 1 == size;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
