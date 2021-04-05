import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringCalculator {

    public int add(String numbers){

        if (numbers.equals("")){
            return 0;
        }else{
            if(numbers.contains("\n,") || numbers.contains(",\n")){
                throw  new InvalidParameterException("Invalid input");
            }else if (numbers.matches("(.*)-[0-9](.*)")) {

                Matcher matcher = Pattern.compile("-[0-9]").matcher(numbers);
                String i="";
                while (matcher.find()) {
                    i=i.concat(matcher.group());
                }
                System.out.println(i);
                throw new InvalidParameterException("Negative numbers "+i+" not allowed");
            }else if (numbers.startsWith("//")){

                String delimiter= Character.toString(numbers.charAt(2));
                String[] sequence=numbers.substring(4).split(delimiter);
                if (sequence.length == 1) {
                    return Integer.parseInt(sequence[0]);
                } else {
                    return Arrays.stream(sequence).mapToInt(Integer::parseInt).sum();
                }

            }else {
                String[] sequence = numbers.split("\n|,");
                if (sequence.length == 1) {
                    return Integer.parseInt(sequence[0]);
                } else {
                    return Arrays.stream(sequence).mapToInt(Integer::parseInt).sum();
                }
            }

        }
    }
}

