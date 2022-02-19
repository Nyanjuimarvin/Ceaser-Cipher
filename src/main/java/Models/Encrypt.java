package Models;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Encrypt {

    private String wordToEncrypt;
    private int shiftFactor;
    private final char [] encryptCharArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public void setWordToEncrypt(String wordToEncrypt) {
        if(validEncryptString(wordToEncrypt)) {
            this.wordToEncrypt = wordToEncrypt;
        }

    }

    public String getWordToEncrypt() {
        return wordToEncrypt;
    }

    public void setShiftFactor(int shiftFactor) {
        this.shiftFactor = shiftFactor;
    }

    public int getShiftFactor() {
        return shiftFactor;
    }

    public boolean validEncryptString(String word){
        return word.matches("([a-zA-z]+|[a-zA-Z]+\\s[a-zA-Z]+)*");
    }
//Alphabet as List
    public List<Character> alphabetLetters(){
        List<Character> charsToShift = new ArrayList<>();
        for(char letter: encryptCharArray){
            charsToShift.add(letter);
        }
        return charsToShift;
    }

    public List<Character> collectCharacters(String word){
        String capWord = word.toUpperCase();
        List<Character> enteredWords = new ArrayList<>();
        for( char capChar:capWord.toCharArray()){
            enteredWords.add(capChar);
        }
     return enteredWords;
    }
   //Encryption Method
    public char encryptCharacters(char initialLetter,int shift){
        return alphabetLetters().get( ( alphabetLetters().indexOf(initialLetter) + shift ) % 26 );
    };

    //Encrypted Character List
    public List<Character> encryptedWordList(List<Character>wordList,int shift){

        List<Character> encryptedChars = new ArrayList<>();
        for(char newChar:wordList) {
            if(newChar == ' ') encryptedChars.add(' ');
            for(char alphabetLetter:alphabetLetters()){
                if( alphabetLetter == newChar){
                    encryptedChars.add(encryptCharacters(alphabetLetter,shift));
                }
            }
        }
        return encryptedChars;
    }

}
