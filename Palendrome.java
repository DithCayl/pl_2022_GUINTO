import java.util.*;

public class Palendrome {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Palendrome Checker\n\n");

        while(true) {

            String input="";
            while(input.isEmpty()) {
                System.out.print("Enter word/phrase: ");
                input = scan.nextLine();
            }
            PalendromeChecker pCheck = new PalendromeChecker();
            System.out.print(pCheck.PalendromeCheck(input));
        }
    }
}
class PalendromeChecker {

    String input="";
    String inputAccepted="";
    String inputPalendrome="";

    public String PalendromeCheck(String inpt) {

        input = inpt;
        //Accept Input
        String loweredString = input.toLowerCase();
        for(char letter: loweredString.toCharArray()){
            if(letter !=' ' & Character.isLetter(letter)) {
                inputAccepted+=letter;
            }
        }
        //Reverse the input
        for(int i = inputAccepted.length()-1; i >=0; i-- ) {
            inputPalendrome+=inputAccepted.charAt(i);
        }

        if(inputAccepted.equals(inputPalendrome))
            return input +" is a palendrome\n\n";

        return input +" is NOT a palendrome\n\n";

    }
}
