package bool;

import java.math.*;
import java.util.*;
//2
public class Residual {
    public static void Println(Object a){System.out.println(a.toString());}
    public static void Print(Object a){System.out.print(a.toString());}

    public static String residual(String Vector,int res,int argNum){
        StringBuffer result = new StringBuffer();
        StringBuffer vec = new StringBuffer(Vector);
        int step=vec.length() / (int)Math.pow(2,argNum);
        if(res==0) for(int i = 0; i < vec.length(); i += step*2)
                result.append(vec.substring(i, i + step));
        if(res==1) for(int i = step; i < vec.length(); i += step*2)
                result.append(vec.substring(i, i + step));
        return result.toString();
    }
    public static void main(String[] args) {
        Println(residual("01011010",0,3));
    }
}
