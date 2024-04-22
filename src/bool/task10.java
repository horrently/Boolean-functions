package bool;

import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;

public class task10 {
    public static String generateVector(int n){
        String vec="";
        for(int i=0;i<Math.pow(2,n);i++)
            vec=Math.round(Math.random())+vec;
        return vec;
    }
    public static boolean checkT0(String vec){
        if(vec.charAt(0)=='0')return true;
        return false;
    }
    public static boolean checkT1(String vec){
        if(vec.charAt(vec.length()-1)=='1')return true;
        return false;
    }
    public static boolean checkS(String vec){
        for(int i=0;i<vec.length()/2;i++)
            if(vec.charAt(i)==vec.charAt(vec.length()-1-i))
                return false;
        return true;
    }
    public static boolean checkM(String vec){
        for(int i=0;i<vec.length();i++){
            if (i % 2 == 0 && i!= vec.length()- 1){
                if(vec.charAt(i+1)<vec.charAt(i))
                    return false;
            }
            for(int j=i;j<vec.length();j++){
                int h=j-i,g=1;
                while( Math.pow(2,g) < h)
                    g += 1;
                if (Math.pow(2,g) == h)
                    if(vec.charAt(j)<vec.charAt(i))
                        return false;
            }
        }
        return true;
    }
    public static boolean checkL(String vec){
        int[][] palJig=new int[vec.length()][];
        for(int i=0;i<vec.length();i++){
            palJig[i]=new int[vec.length()-i];
            palJig[i][0]=((int)vec.charAt(i))-48;
        }
        for(int i=1;i<vec.length();i++) {
            for (int j = 0; j < palJig[i].length; j++)
                palJig[j][i] =( palJig[j][i - 1] + palJig[j + 1][i-1])%2;
        }
        for(int i=1;i<palJig[0].length;i++)
            if(palJig[0][i]==1)
                if(Integer.bitCount(i)!=1)
                    return false;
        return true;
    }
    public static void check(int n){
        Scanner in=new Scanner(System.in);
        int userCheck=0,progCheck=0;
        String vector = generateVector(n);
        System.out.println(vector);

        boolean[] progAns= new boolean[5];
        if(checkT0(vector))progAns[0]=true;
        if(checkT1(vector))progAns[1]=true;
        if(checkS(vector))progAns[2]=true;
        if(checkM(vector))progAns[3]=true;
        if(checkL(vector))progAns[4]=true;
        for(int i=0;i<5;i++)
            if(progAns[i])progCheck++;

        String[] userStringAns=in.nextLine().split(" ");
        boolean[] userAns= new boolean[5];
        for(int i=0;i<userStringAns.length;i++){
            switch (userStringAns[i]){
                case("T0"):{userAns[0]=true;break;}
                case("T1"):{userAns[1]=true;break;}
                case("S"):{userAns[2]=true;break;}
                case("M"):{userAns[3]=true;break;}
                case("L"):{userAns[4]=true;break;}
            }
        }

        for(int i=0;i<5;i++)
            if(userAns[i])userCheck++;
        if(userCheck==progCheck)System.out.println("Ответ правильный.");
        else System.out.println("Ответ неверный.");
    }

    public static void main(String[] args) {
        check(3);
    }
}
