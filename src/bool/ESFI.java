package bool;
//5
import java.util.*;

public class ESFI {
    //Генерация вектора по n аргументам
    public static String generateVector(int n){
        String vec="";
        for(int i=0;i<Math.pow(2,n);i++)
            vec=Math.round(Math.random())+vec;
        return vec;
    }
    //Нахождение числа переменных по длинне вектора
    public static int numberOfArg(String vector){
        return (int)(Math.log(vector.length())/Math.log(2));
    }
    //нахождение фиктивных переменных в функции
    public static String defineFicVars(String vector){
        String result="";
        int argNum=numberOfArg(vector);
        for(int i=0;i<argNum;i++)
        {
            int step=(int)Math.pow(2,i);
            int check=0;
            for(int j=0;j<vector.length();j+=step*2)
                for(int k=0;k<step;k++)
                {
                    if(vector.charAt(j+k)!=vector.charAt(j+k+step))break;
                    else check++;
                }
            if(check==vector.length()/2)result=(argNum-i)+" "+result;
        }
        return result;
    }
    //игра
    public static void check(int n){
        String vec=generateVector(n);
        //int[] pocket=new int[numberOfArg(vec)];
        int checkdVar=0;
        Scanner in=new Scanner(System.in);
        System.out.println(vec);
        System.out.print("Введите номера фиктивных переменных: ");
        String[] progAns=defineFicVars(vec).split(" ");
        String[] userAns=in.nextLine().split(" ");
        if(userAns.length!=progAns.length){
            System.out.print("Ответ неверный. Правильный ответ: ");
            for(int i=0;i<progAns.length;i++)
                System.out.print(progAns[i]+" ");
        }
        else {
            for (int i = 0; i < progAns.length; i++) {
                for (int j = 0; j < userAns.length; j++) {
                    if (progAns[i].equals(userAns[j])) {
                        checkdVar++;
                        break;
                    }
                }
            }
            if(checkdVar!=progAns.length){
                System.out.print("Ответ неверный. Правильный ответ: ");
                for(int i=0;i<progAns.length;i++)
                    System.out.print(progAns[i]+" ");
            }
            else System.out.print("Ответ правильный.");
        }
    }
    public static void main(String[] args) {
        check(3);
    }
}
