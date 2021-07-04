package pp;
@FunctionalInterface
interface lamda1{
    boolean betterString(String s1,String s2);
}
@FunctionalInterface
interface lamda2{
    boolean isAlphabetL(String s);
}


public class Main {
    public static void main(String[] args) {
        lamda1 l;
        lamda2 l2;
        String s1="just a String";
        String s2="also a String but LOOOOOOOOOOONGER";
        System.out.println("longer String: "+StringUtils.betterString(s1,s2,((a1,a2)->a1.length()>a2.length())));
        System.out.println("first string: "+StringUtils.betterString(s1,s2,((a1,a2)->true)));
        System.out.println("longer first string using method referncing: "+StringUtils.betterString(s1,s2,StringUtils::forReference));
        System.out.println("using normal method: is this string \"onlyletters\" all alphabet: "+isAlphabet("onlyletters"));
        System.out.println("using normal method: is this string \"letterswith1number\" all alphabet: "+isAlphabet("letterswith1number"));


        l2=Main::isAlphabet;
        System.out.println("using static method referencing: is this string \"onlyletters\" all alphabet: "+l2.isAlphabetL("letters"));
        System.out.println("using static method referencing: is this string \"letterswith1number\" all alphabet: "+l2.isAlphabetL("letterswith1number"));




    }
    public static boolean isAlphabet(String s){
        for(char c:s.toCharArray()){
            if(Character.isLetter(c)){
            }
            else{
                return false;
            }
        }
        return true;
    }


}
