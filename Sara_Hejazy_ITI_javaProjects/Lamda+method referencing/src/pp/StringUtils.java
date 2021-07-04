package pp;

public class StringUtils {
    public static String betterString(String s1,String s2,lamda1 l){
        if(l.betterString(s1,s2)){
            return s1;
        }
        else {
            return s2;
        }
    }

    public static boolean forReference(String s1,String s2){
        return (s1.length()>s2.length());


    }
}
