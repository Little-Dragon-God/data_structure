package com.xls.arr;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SparseArr {
    public static void main(String[] args) throws IOException {
        //创建二维数组
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        //输出原始二维数组
        System.out.println("原始二维数组");
        for (int[] rows : chessArr) {//遍历行数
            for (int data : rows) {//遍历值
                System.out.printf("%d\t", data);
            }
            System.out.println();//每打一行换行
        }

        //遍历二维数组,得到非零个数和sum
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0)
                    sum++;
            }
        }
        //根据sum创建稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历二维数组，将非零值存放到稀疏数组中
        int count = 0;//记录第几个非零数
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;//行数
                    sparseArr[count][1] = j;//列数
                    sparseArr[count][2] = chessArr[i][j];//二维数组值
                }
            }
        }
        //遍历输出稀疏数组
        System.out.println("稀疏数组");
        for (int i = 0; i < sparseArr.length ; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();


        //稀疏数组变为二维数组
        //根据稀疏数组第一行创建二维数组
        int chessArr2[][] =  new int[sparseArr[0][0]][sparseArr[0][1]];
        //遍历读取后几行稀疏数组后，将值给二维数组
        for (int i = 1; i < sparseArr.length ; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("还原后稀疏数组");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }


}
