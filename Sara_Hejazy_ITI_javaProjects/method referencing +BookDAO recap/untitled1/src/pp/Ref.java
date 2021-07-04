package pp;

public class Ref {
    public static String evenCheck(int n){
        String result;
        if (n%2==0){
            result="even";
        }
        else{
            result="odd";
        }
            return result;
    }
    public static String positiveCheck(int n){
        String result;
        if(n>0){
            result="positive";

        }
        else if (n<0){
            result="negative";
        }
        else{
            result="niether positive nor negative";
        }
        return result;
    }

    }
