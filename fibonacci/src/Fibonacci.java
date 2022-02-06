import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {

    public static void main(String[] args) {
        int smallerNumbers = 59;
        System.out.println(getFibonacciList(smallerNumbers));
    }

    // "number" sayısından küçük fibonacci sayılarını verir
    private static List<Integer> getFibonacciList(Integer number) {
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 1));
        for (int i = 2; i < list.size(); i++) {
            int tempInt;
            tempInt = list.get(i) + list.get(i - 1);
            if (number > tempInt) {
                list.add(tempInt);
            }
        }
        return list;
    }

}
