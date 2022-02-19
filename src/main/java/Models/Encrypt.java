package Models;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Encrypt {

    private String wordToEncrypt;
    private int shiftFactor;
    private final char [] encryptCharArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public void setWordToEncrypt(String wordToEncrypt) throws InvalidStringException {
        if( validEncryptString(wordToEncrypt) ) {
            this.wordToEncrypt = wordToEncrypt;
        }else {
            throw new InvalidStringException
                    ("Invalid String: Valid Example(\"I am a Sentence\") " +
                            "::-> Without Whitespace at Beginning and Punctuation/Special Symbols");
        }
    }

    public String getWordToEncrypt() {
        return wordToEncrypt;
    }

    public void setShiftFactor( int shiftFactor ) throws OutOfRangeException {
        if( shiftFactor > 0 && shiftFactor < 26 ){
            this.shiftFactor = shiftFactor;
        }else {
            throw new OutOfRangeException("Invalid Shift Factor Range: Valid Range[ 1- 26 ]");
        }
    }

    public int getShiftFactor() {
        return shiftFactor;
    }

    public boolean validEncryptString( String word ){
        return word.matches( "([a-zA-z]+|[a-zA-Z]+\\s[a-zA-Z]+)*" );
    }

    //Alphabet as List
    public List <Character> alphabetLetters(){
        List <Character> charsToShift = new ArrayList<>();
        for( char letter: encryptCharArray ){
            charsToShift.add( letter );
        }
        return charsToShift;
    }

    public List <Character> collectCharacters(String word){
        String capWord = word.toUpperCase();
        List <Character> enteredWords = new ArrayList<>();
        for( char capChar:capWord.toCharArray() ){
            enteredWords.add( capChar );
        }
     return enteredWords;
    }

   //Encryption Method
    public char encryptCharacters( char initialLetter, int shift ){
        return alphabetLetters().get( ( alphabetLetters().indexOf( initialLetter ) + shift ) % 26 );
    };

    //Encrypted Character List
    public List <Character> encryptedCharList( List <Character> wordList, int shift ){

        ArrayList <Character> encryptedChars = new ArrayList<>();
        for( char newChar:wordList ) {
            if( newChar == ' ' ) encryptedChars.add(' ');
            for( char alphabetLetter:alphabetLetters() ){
                if( alphabetLetter == newChar ){
                    encryptedChars.add( encryptCharacters(alphabetLetter,shift) );
                }
            }
        }
        return encryptedChars;
    }

    //Return Encrypted Characters As a String
    public String encryptedString(){
        String encryptedWord = encryptedCharList( collectCharacters( getWordToEncrypt() ), getShiftFactor() )
                                                .stream().map(Object::toString)
                                                .collect(Collectors.joining());
        return encryptedWord;
    }

}
