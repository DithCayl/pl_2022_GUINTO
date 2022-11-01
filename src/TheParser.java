import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheParser {

    public static void main(String[] args) {
        String pattern1 ="<data_type><identifier><assignment_operator><value><delimiter>";
        String pattern2 ="<data_type><identifier><delimiter>";
        String pattern3 ="<identifier><assignment_operator><value><delimiter>";
        String input = "<data_type> <identifier> <assignment_operator> <value> <delimiter>";
        List<PatternHolder> patternList = new ArrayList<PatternHolder>();

        PatternHolder patternHolder1 = new PatternHolder(pattern1);
        PatternHolder patternHolder2 = new PatternHolder(pattern2);
        PatternHolder patternHolder3 = new PatternHolder(pattern3);
        patternList.add(patternHolder1);
        patternList.add(patternHolder2);
        patternList.add(patternHolder3);

        Scanner scanner = new Scanner(System.in);

        outerloop:
        while(true){

            System.out.print("Enter Tokens: ");
            input = scanner.nextLine();
            input = input.replaceAll("\\s","");
            PatternHolder inputHolder = new PatternHolder(input);

            for(PatternHolder pHolder: patternList){
                if(inputHolder.isEqualPattern(pHolder)){
                    ProgramPrint(true);
                    continue outerloop;
                }
            }
            ProgramPrint(false);
        }
    }
    static void ProgramPrint(boolean isSuccess){
        if(isSuccess) System.out.println("Syntax is Correct!\n");
        else System.out.println("Syntax is Error!\n");
    }
}
class PatternHolder{
    public String pattern;
    public PatternHolder(String pattern){
        this.pattern =pattern;
    }
    public boolean isEqualPattern(PatternHolder obj){
        return(pattern.equals(obj.pattern));
    }
}


