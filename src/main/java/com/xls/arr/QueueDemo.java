package com.xls.arr;

import java.util.ArrayList;
import java.util.Scanner;

public class QueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.show();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.showHead();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}

class ArrayQueue {
    private int maxSize;
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//存放数据，模拟队列

    //创建队列构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1;//指向队列尾，指向队列的最后一个元素
    }

    //判断队列是否满了
    public boolean isFull() {
        //当队列尾为数组长度时，队列就满了
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        //头尾相等时，队列为空
        return front == rear;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满了
        if (isFull())
            System.out.println("队列满了，不能添加");
        rear++;//没满，队尾索引加1
        arr[rear] = n;
    }

    //出队列，获取队列数据
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty())
            throw new RuntimeException("队列空，不能取数据");
        //出队列，头先出
        front++;
        return arr[front];
    }

    // 显示队列的所有数据
    public void show() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            System.out.println(isEmpty());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示队列的头数据
    public int showHead() {
        if (isEmpty())
            throw new RuntimeException("队列空的，没有数据~~");
        return arr[front + 1];
    }
}
