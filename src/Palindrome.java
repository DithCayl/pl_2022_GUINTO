import java.util.*;

public class Palindrome {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Palindrome Checker\n");

        while(true) {

            String input="";
            while(input.isEmpty()) {
                System.out.print("Enter word/phrase: ");
                input = scan.nextLine();
            }
            PalindromeChecker pCheck = new PalindromeChecker();
            System.out.print(pCheck.PalindromeCheck(input));
        }
    }
}
class PalindromeChecker {

    String input="";
    String inputAccepted="";
    String inputPalindrome ="";

    public String PalindromeCheck(String inpt) {

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
            inputPalindrome +=inputAccepted.charAt(i);
        }

        if(inputAccepted.equals(inputPalindrome))
            return input +" is a palindrome\n\n";

        return input +" is NOT a palindrome\n\n";

    }
}
