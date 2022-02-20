import Models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Encrypt encrypt = new Encrypt();
        Decrypt decrypt = new Decrypt();
        BufferedReader buffer = new BufferedReader( new InputStreamReader(System.in) );
        Scanner scanner = new Scanner(System.in);
        String continues  = "cont";
        String quit = "quit";

        System.out.println(" ____________________________________________________________________________");
        System.out.println("|                                                                            |");
        System.out.println("|                                                                            |");
        System.out.println("+              HELLO THERE ( ͡° ͜ʖ ͡°).WELCOME TO CEASER CIPHER                 +");
        System.out.println("|                                                                            |");
        System.out.println("|_____________________________________________________ VERSION 1.0 __________|");
        System.out.println("|                                                                            |");
        System.out.println("|                           HOW TO PLAY:                                     |");
        System.out.println("*                            ---------                                       *");
        System.out.println("|                     1: Continue ( enter cont )                             |");
        System.out.println("|                     2: Exit ( enter quit )                                 |");
        System.out.println("+                                                                            +");
        System.out.println("|                              RULES                                         |");
        System.out.println("|                              ------                                        |");
        System.out.println("*   i: VALID WORDS: [ Any word without a symbol/Character or punctuation ]   *");
        System.out.println("|  ii: VALID SHIFT FACTOR : [ Any number within Range ( 1 - 26 ) ]           |");
        System.out.println("|                                                                            |");
        System.out.println("|_______________________________ENJOY________________________________________|");
        System.out.println();

        //Prompt For Word
        try {
            System.out.println("******************************************************************************");
            System.out.println(": Enter the word/words you wish to encrypt:");
            String enteredWord = buffer.readLine() ;
            System.out.println("\n------------------------------------------------------------------------------");

            System.out.println(": Enter Shift Factor");
            int enteredFactor = scanner.nextInt();
            System.out.println("\n-------------------------------------------------------------------------------");

            encrypt.setWordToEncrypt(enteredWord);
            encrypt.setShiftFactor( enteredFactor );
            System.out.printf("=> You Entered      : %s %n", encrypt.getWordToEncrypt() );
            System.out.printf("=> Encrypted Word(s): %s %n", encrypt.encryptedString() );

            decrypt.setWordToDecrypt( encrypt.encryptedString() );
            decrypt.setDecryptFactor( encrypt.getShiftFactor() );
            System.out.printf("=> Decrypted Word(s): %s %n",decrypt.decryptedWord() );

            System.out.println("_______________________________________________________________________________");


            System.out.println("\n\n                            Select an Option                                ");
            System.out.println("                            -------------                                       ");
            System.out.println("         Continue ( cont )                   quit( quit )                       ");
            String choice = buffer.readLine();

            while( choice.equals(continues) ){
                System.out.println("******************************************************************************");
                System.out.println(": Enter the word/words you wish to encrypt:");
                String newWord = buffer.readLine() ;
                System.out.println("\n------------------------------------------------------------------------------");

                System.out.println(": Enter Shift Factor");
                int newFactor = scanner.nextInt();
                System.out.println("\n-------------------------------------------------------------------------------");

                encrypt.setWordToEncrypt(newWord);
                encrypt.setShiftFactor( newFactor );
                System.out.printf("=> You Entered      : %s %n", encrypt.getWordToEncrypt() );
                System.out.printf("=> Encrypted Word(s): %s %n", encrypt.encryptedString() );

                decrypt.setWordToDecrypt( encrypt.encryptedString() );
                decrypt.setDecryptFactor( encrypt.getShiftFactor() );
                System.out.printf("=> Decrypted Word(s): %s %n",decrypt.decryptedWord() );

                System.out.println("_______________________________________________________________________________");


                System.out.println("\n\n                            Select an Option                               ");
                System.out.println("                            -------------                                      ");
                System.out.println("        Continue ( cont )                   quit( quit )                       ");
                String newChoice = buffer.readLine();
                if( newChoice.equals("cont")){
                    newChoice = continues;
                }else{
                    break;
                }
            }
            System.out.println(  "*****************************************************************************");
            System.out.println();
            System.out.println("                 βｙё♪ Bye (( ヾ( ^-^)ゞ  Have A Great Day                      ");
            System.out.println();
        }catch ( IOException ex){
            ex.printStackTrace();
        }

    }
}
