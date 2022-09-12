import java.util.Scanner;

public class DFA_Equivalent {
    public static void main(String[] args) {
        String currentState="q0";
        String inputs;

        States states = new States();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("\nInput the String: ");
            inputs = scanner.nextLine();
            boolean invalidInput = false;

            for(char input: inputs.toCharArray()){
                if(input !='1'&input!='0'){
                    System.out.print("Invalid Input!\n");
                    invalidInput = true;
                    break;
                }
                if(currentState.equals("q0")){
                    currentState = states.StateQ0(input);
                    continue;
                }
                if(currentState.equals("q1")){
                    currentState = states.StateQ1(input);
                    continue;
                }
                currentState = states.StateQ2(input);
            }
            if(!invalidInput){
                if(currentState.equals("q2"))System.out.println("String accepted");
                else System.out.println("String not accepted");
            }

        }
    }
}
class States{
    String StateQ0(char input){
        if(input == '1') return "q0";
        return "q1";
    }
    String StateQ1(char input){
        if(input == '0') return "q1";
        return "q2";
    }
    String StateQ2(char input){
        if(input =='0') return "q1";
        return "q0";
    }
}
