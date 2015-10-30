package zz.com.passwordsecuritylevel.util;

/**
 * Created by neil on 15/10/30.
 */
public class StringUtils {


    public static boolean isEmpty(String str) {
        return (null == str || str.length() == 0);
    }


    public static int getPasswordStrongth(String password){
        int e =0;
        int b = password.length();
        for(int i=0;i<b;i++){
            e|=charMode(password.charAt(i));
        }
        e=new Double((bitTotal(e)/4.0*100)).intValue();
        if(e>=60){
            return 2;
        }
        else if(e>=35){
            return 1;
        }
        else{
            return 0;
        }
    }
    private static int charMode(char b){
        if(b>=48 && b<=57){
            return 1;
        }
        else{
            if(b>=65 && b<=90){
                return 2;
            }else{
                if(b>=97 && b<=122){
                    return 4;
                }else{
                    return 8;
                }
            }
        }
    }
    private static int bitTotal(int b)
    {
        int d = 0;
        for (int c = 0; c < 4; c++) {
            if ((b & 1) >0) {
                d++;
            }
            b >>>= 1;
        }
        return d;
    }
}
