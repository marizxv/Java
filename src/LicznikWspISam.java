import java.util.Scanner;
//task 3

public class LicznikWspISam {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String toScan = scanner.nextLine();

        int vowels=0,consonants=0, specialS = 0;
        String referenceVowels = "aeioyuąóę";
        for (int i = 0; i< toScan.length(); i++){
            char currentVowel = toScan.toLowerCase().charAt(i);
            if ( referenceVowels.indexOf(currentVowel)!= -1){
                vowels++;
            }else{
                if(currentVowel >='a' && currentVowel <='z'){
                    consonants++;
                }else specialS++;
            }
        }
        System.out.println("Samogłoski:"+vowels);
        System.out.println("Spółgłoski: "+consonants);
        System.out.println("Inne symboli :"+specialS);

    }
}
