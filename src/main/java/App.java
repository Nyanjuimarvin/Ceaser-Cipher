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

        System.out.println(" ____________________________________________________________________________");
        System.out.println("|                                                                            |");
        System.out.println("|                                                                            |");
        System.out.println("+              HELLO THERE ( ͡° ͜ʖ ͡°).WELCOME TO CEASER CIPHER                 +");
        System.out.println("|                                                                            |");
        System.out.println("|_____________________________________________________ VERSION 1.0 __________|");
        System.out.println("|                                                                            |");
        System.out.println("|                           HOW TO PLAY:                                     |");
        System.out.println("*                            ---------                                       *");
        System.out.println("|                     1: Continue ( enter c )                                |");
        System.out.println("|                     2: Exit ( enter q )                                    |");
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
            System.out.println(">>Enter the word you wish to encrypt:\n");
            String enteredWord = buffer.readLine();
            System.out.println(">>Enter Shift Factor");
            int enteredFactor = scanner.nextInt();

            encrypt.setWordToEncrypt(enteredWord);
            encrypt.setShiftFactor( enteredFactor );
            System.out.printf("You Entered: %s %n", encrypt.getWordToEncrypt() );
            System.out.printf("Encrypted: %s %n", encrypt.encryptedString() );

            decrypt.setWordToDecrypt( encrypt.encryptedString() );
            decrypt.setDecryptFactor( encrypt.getShiftFactor() );
            System.out.printf("Decrypted: %s %n",decrypt.decryptedWord() );

        }catch ( IOException ex){

        }

    }
}
