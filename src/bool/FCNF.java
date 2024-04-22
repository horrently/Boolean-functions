package bool;
//9
public class FCNF {
    public static String buildFCNF(String vector){
        StringBuffer result=new StringBuffer(),sample=new StringBuffer("(");
        int argNum=(int)(Math.log(vector.length())/Math.log(2));
        //Строим шаблон терма
        for(int i=0;i<argNum;i++){
            sample.append("X"+(i+1)+"V");
        }
        sample.deleteCharAt(sample.length()-1);
        sample.append(')');

        //A kind of magic
        for(int i=0;i<vector.length();i++){
            if(vector.charAt(i)=='0'){
                StringBuffer term=new StringBuffer(sample);

                //Строим двоичную запись нидекса и дополняем её ведущими нулями
                String f=Integer.toString(i,2);
                while(f.length()!=argNum){
                    f=0+f;
                }

                //расставляем отрицания
                int x=argNum,j=term.length()-3;
                while(x>0){
                    if(f.charAt(x-1)=='1')
                        term.insert(j,'¬');
                    x--;j-=3;
                }

                //получившийся терм добавляем в результат
                result.append(term);
                result.append("&");
            }
        }
        result.deleteCharAt(result.length()-1);

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(buildFCNF("10010001"));
    }
}
