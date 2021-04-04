import java.util.Arrays;


public class StringCalculator {

    public int add(String numbers){
        if (numbers.equals("")){
            return 0;
        }else{
            if(numbers.matches(".*\\n,.*") || numbers.matches(".*,\\n.*")){
                System.out.println("Invalid input");
                return 0;
            }
            String[] a=numbers.split("\n|,");
            if (a.length==1){
                return Integer.parseInt(a[0]);
            }else {
                return Arrays.stream(a).mapToInt(Integer::parseInt).sum();
            }
        }
    }
}

