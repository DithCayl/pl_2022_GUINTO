import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheSemantic {

    public static void main(String[] args) {

        String input;
        String regExPattern = "(('|\").*\\s*.*(\"|'))|;|=|(-|\\+)*(\\.*\\w+\\.*\\w*)";
        Scanner scanner = new Scanner(System.in);
        while(true){
            boolean isValueAssign = false;
            DataType dataValue = DataType.error;
            String value="";
            System.out.print("Enter Expression: ");
            input = scanner.nextLine();
            Matcher matcher = Pattern.compile(regExPattern).matcher(input);

            while(matcher.find()){
                if(matcher.group().equals("=")) {
                    isValueAssign=true;
                    continue;
                }
                if(IsDataType(matcher.group())){
                    dataValue = GetDataType(matcher.group());
                    continue;
                }
                if(isValueAssign && IsValueType(matcher.group())){
                    value = matcher.group();
                    break;
                }
            }
            if(!isValueAssign|IsTypeMatched(value,dataValue)){
                System.out.println("Semantically  Correct!\n");
            }
            else {
                System.out.println("Semantically  Incorrect!\n");
            }
        }
    }
    static boolean IsDataType(String input){
        boolean bool = input.equals("int")||input.equals("double")||
                input.equals("String")||input.equals("char");
        return bool;
    }
    static DataType GetDataType(String input){
        switch(input){
            case"String":
                return DataType.StringType;
            case"char":
                return DataType.charType;
            case"int":
                return DataType.intType;
            case"double":
                return DataType.doubleType;
            default:
                return DataType.error;
        }
    }

    static boolean IsValueType(String input){
        String regExPattern = "(-*\\d+)|" +   //int
                "(\\d+\\.*\\d*)|" +         //double
                "(\".+\")|" +                 //String
                "('.')";                   //char
        Matcher matcher = Pattern.compile(regExPattern).matcher(input);
        return matcher.find();
    }
    static boolean IsTypeMatched(String input, DataType dataType){
        String charPatternValue ="((\'.{1}\'))";
        String stringPatternValue ="(\".*\")";
        String intPatternValue ="(-|\\+)?\\d+";
        String doublePatternValue ="((-|\\+)?((\\d+)|(\\d+\\.*\\d*)|(\\d*\\.*\\d+)))";
        String regExValue;

        switch(dataType){
            case StringType:
                regExValue = stringPatternValue;
                break;
            case charType:
                regExValue = charPatternValue;
                break;
            case intType:
                regExValue = intPatternValue;
                break;
            case doubleType:
                regExValue = doublePatternValue;
                break;
            default:
                regExValue = null;
        }
        if(regExValue==null)return false;
        Matcher matcher = Pattern.compile(regExValue).matcher(input);
        return matcher.matches();
    }

    enum DataType{
        StringType,charType,intType,doubleType,error
    }
}
