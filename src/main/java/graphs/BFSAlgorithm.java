package main.java.graphs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Joseph on 2017/6/10.
 *  广度优先搜索
 *  读一个文本文件，包含了一个矩阵，该矩阵是图的转化
 */
public class BFSAlgorithm {

    private static final int MATRIX_MAX = 6;

    static int[][] matrix = new int[MATRIX_MAX][MATRIX_MAX];
    private static int[] queue = new int[MATRIX_MAX];
    static int[] visted = new int[MATRIX_MAX];

    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream inputStream = new FileInputStream("F:\\matrix.txt");
        int i = 0,j = 0,k = 0;
        try {
            while ((i=inputStream.read())!=-1){
                if((char)i=='0' || (char)i=='1'){
                    matrix[j][k] = i;
                    k++;
                }else if((char)i=='\n'){
                    j++;
                    k=0;
                }
            }

//            for(i=0; i<MATRIX_MAX; i++){
//                for(j=0; j<MATRIX_MAX; j++){
//                    System.out.print((char)matrix[i][j]+"  ");
//                }
//            }
            bfsSearch(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bfsSearch(int start){
        int head=0,tail=0;
        queue[tail++]=start;
        while(head != tail){
            int t = queue[head++];
            System.out.println(t+1);
            visted[t] = 1;
            //查找该节点的临节点
            for(int i=0; i<MATRIX_MAX; i++){
                if((char)matrix[t][i] == '1'){
                    //如果没被访问
                    if(visted[i] == 0){
                        //入队
                        queue[tail++] = i;
                        visted[i] = 1;
                    }
                }
            }
        }
    }
}
