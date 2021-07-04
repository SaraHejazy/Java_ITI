package pp;

import java.util.ArrayList;

public class MaxMin {
    public static int maxi(ArrayList<Integer> arr){
        return arr.stream().max((s1,s2)->s1.compareTo(s2)).get();
    }

    public static int mini(ArrayList<Integer> arr){
        return arr.stream().min((s1,s2)->s1.compareTo(s2)).get();
    }
}
