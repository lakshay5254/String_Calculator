import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;


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

                throw new InvalidParameterException("Negative numbers "+i+" not allowed");
            }else if (numbers.startsWith("//")){


                String delimiter= Character.toString(numbers.charAt(2));
                String[] sequence=numbers.substring(4).split(delimiter);
                int[] seq=Arrays.stream(sequence).mapToInt(Integer::parseInt).filter(a->a<1000).toArray();

                if (seq.length == 1) {
                    return seq[0];
                } else {
                    return Arrays.stream(seq).sum();
                }

            }else {
                String[] sequence = numbers.split("\n|,");
                int[] seq=Arrays.stream(sequence).mapToInt(Integer::parseInt).filter(a->a<1000).toArray();


                if (seq.length == 1) {
                    return seq[0];
                } else {
                    return Arrays.stream(seq).sum();
                }
            }

        }
    }
}

