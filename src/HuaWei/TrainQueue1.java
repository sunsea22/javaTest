package HuaWei;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 火车进站问题
 *
 * 函数值传递和引用传递问题：java函数的参数默认是引用传递，即在函数内部改变参数的值会对函数外部的变量产生影响
 * 为了实现值传递就要进行相应处理，因为在出入之前要进行一些操作，而又不希望这些操作影响到原来变量，所以先复制，处理后传入函数
 *
 * 对于queue，如果内容为空调用peek()时返回null，而对于stack，如果内容为空调用peek()时会抛出EmptyStackException错误
 *
 * queue出队用poll()，而stack出栈用pop()
 */


public class TrainQueue1{
    public static void main(String[] args)	{
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        Queue<Integer> trainWait=new LinkedList<Integer>();//准备进站的火车队列
        Stack<Integer> trainIn=new Stack<Integer>();//站中的火车
        StringBuilder trainOut=new StringBuilder(); //已经出站的火车
        // 准备好要进站的火车队列
        for(int i=0;i<num;i++)	{
            trainWait.add(sc.nextInt());
        }
        stationDispatch(trainWait, trainIn, trainOut);
        sc.close();
    }
    public static void stationDispatch(Queue<Integer> trainWait,Stack<Integer> trainIn,StringBuilder trainOut)	{
    //查看是否还有要进站的火车和站中是否还有火车
        boolean hasWaitTrain=true;
        boolean hasParkTrain=true;
        //对于队列如果没有元素peek函数返回null
        if(trainWait.peek()==null)	{
            hasWaitTrain=false;
        }
        //对于栈如果没有元素则抛出EmptyStackException
        try {
            trainIn.peek();
        } catch (EmptyStackException e) {
            hasParkTrain=false;
        }
            //处理
            // 情况1:即没有要进站的火车，站中也没有火车，则直接输出结果
            if(!hasWaitTrain&&!hasParkTrain)
            {
                String out=trainOut.toString();
                System.out.println(out.substring(0,out.length()-1)); //多余一个空格，所以要substring
                return;
            }
            //情况2：有要出站的火车可以出站
            if(hasParkTrain) {
            //复制个参数的值
                Queue<Integer> trainWaitTmp = new LinkedList<Integer>(trainWait);
                Stack<Integer> trainInTmp = (Stack<Integer>)trainIn.clone();
                StringBuilder trainOutTmp = new StringBuilder(trainOut);
                trainOutTmp.append(trainInTmp.pop().toString()+" ");
                //递归调用函数
                stationDispatch(trainWaitTmp, trainInTmp, trainOutTmp);
            }
            //情况3：有要进站的火车可以进站
            if(hasWaitTrain) {
            //复制个参数的值
                Queue<Integer> trainWaitTmp=new LinkedList<Integer>(trainWait);
                Stack<Integer> trainInTmp=(Stack<Integer>)trainIn.clone();
                StringBuilder trainOutTmp=new StringBuilder(trainOut);
                trainInTmp.push(trainWaitTmp.poll());
                //递归调用函数
                stationDispatch(trainWaitTmp, trainInTmp, trainOutTmp);
            }
    }
}
