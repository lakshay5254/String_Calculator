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
                String delimiter="";
                String[] sequence=new String[numbers.length()];
                if (numbers.startsWith("//[")){
                    int i=4;
                    while (numbers.charAt(i)==numbers.charAt(3)){
                        i++;
                    }
                    delimiter= numbers.substring(3,i);
                    sequence=numbers.substring(i+2).split(Pattern.quote(delimiter));

                }else{
                    delimiter= Character.toString(numbers.charAt(2));
                    sequence=numbers.substring(4).split(Pattern.quote(delimiter));
                }

                return returnSum(sequence);

            }else {
                String[] sequence = numbers.split("\n|,");

                return returnSum(sequence);
            }

        }
    }

    public int returnSum(String[] sequence){
        int[] seq=Arrays.stream(sequence).mapToInt(Integer::parseInt).filter(a->a<1000).toArray();
        if (seq.length == 1) {
            return seq[0];
        } else {
            return Arrays.stream(seq).sum();
        }
    }
}

