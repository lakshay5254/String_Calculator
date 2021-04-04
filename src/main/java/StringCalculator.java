import java.util.Arrays;


public class StringCalculator {

    public int add(String numbers){
        if (numbers.equals("")){
            return 0;
        }else{
            String[] a=numbers.split(",");
            if (a.length==1){
                return Integer.parseInt(a[0]);
            }else {
                return Arrays.stream(a).mapToInt(Integer::parseInt).sum();
            }
        }
    }
}

