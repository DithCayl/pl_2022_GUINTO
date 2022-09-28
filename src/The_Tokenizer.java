import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class The_Tokenizer {

    public static void main(String[] args) {
        String input;
        String regExPattern = "(\".+\\s*.*\")|;|=|(\\w+)";

        Scanner scanner = new Scanner(System.in);
        TypeRecognizer typeRecognizer = new TypeRecognizer();

        while(true){
            //Accept Input
            System.out.print("\nEnter Source Language: ");
            input = scanner.nextLine();

            //Sort Input
            List<String> sortedInput = new ArrayList<String>();

            Matcher matcher = Pattern.compile(regExPattern).matcher(input);

            while(matcher.find()){
                sortedInput.add(matcher.group());
            }
            //Determine Token
            List<String> tokenList = new ArrayList<String>();
            for(String lexeme: sortedInput){
                if(typeRecognizer.IsDataType(lexeme)){
                    tokenList.add("<data_type>");
                    continue;
                }
                if(typeRecognizer.IsIdentifier(lexeme)){
                    tokenList.add("<identifier>");
                    continue;
                }
                if(typeRecognizer.IsValueType(lexeme)){
                    tokenList.add("<value>");
                    continue;
                }
                if(lexeme.equals("=")){
                    tokenList.add("<assignment_operator>");
                    continue;
                }
                if(lexeme.equals(";")){
                    tokenList.add("<delimiter>");
                    continue;
                }
                tokenList.add("<unknown_lexeme>");
            }
            //Print Output
            String output = "Output is ";
            for(String tokens: tokenList){
                output += tokens +" ";
            }
            System.out.println(output);
        }

    }
}
class TypeRecognizer{

      public boolean IsDataType(String input){
          boolean bool = input.equals("int")||input.equals("double")||
                  input.equals("String")||input.equals("char");
          return bool;
      }
      public boolean IsIdentifier(String input){
          String regExPattern = "[a-zA-Z_]\\w*";
          boolean bool = Pattern.matches(regExPattern,input);
          return bool;
      }
      public boolean IsValueType(String input){
          String regExPattern = "(-*\\d+)|" +   //int
                  "(-*\\d+\\.*\\d*)|" +         //double
                  "(\".+\")|" +                 //String
                  "(\'.\')";                   //char
          boolean bool = Pattern.matches(regExPattern,input);
          return bool;
      }

}