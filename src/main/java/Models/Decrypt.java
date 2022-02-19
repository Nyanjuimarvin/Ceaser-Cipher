package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Decrypt {

    private String wordToDecrypt;
    private int decryptFactor;
    private final char [] alphabetArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public void setWordToDecrypt(String wordToDecrypt) throws InvalidStringException {
        if(validDecryptString(wordToDecrypt)) {
            this.wordToDecrypt = wordToDecrypt;
        }else {
            throw new InvalidStringException
                    ("Invalid String Input: Valid Example (\"What the Dog Doing\")" +
                            "::->Without Punctuation/Special Symbols");
        }
    }

    public String getWordToDecrypt() {
        return wordToDecrypt;
    }

    public void setDecryptFactor(int decryptFactor) throws OutOfRangeException {
        if(decryptFactor > 0 && decryptFactor <= 26) {
            this.decryptFactor = decryptFactor;
        }else {
            throw new OutOfRangeException("Invalid Decrypt Factor Range: Valid Range [ 1 <-> 26 ]");
        }
    }

    public int getDecryptFactor() {
        return decryptFactor;
    }

    public boolean validDecryptString(String word){
        return word.matches("([a-zA-z]+|[a-zA-Z]+\\s[a-zA-Z]+)*");
    }

    public List <Character> alphabetList(){
        List <Character> alphaList = new ArrayList<>();
        for( char letter : alphabetArray ){
            alphaList.add(letter);
        }
        return alphaList;
    }

    public List<Character> charsToDecrypt(String encryptedWord){
        List <Character> decryptList = new ArrayList<>();
        for( char singleChar : encryptedWord.toCharArray() ){
            decryptList.add( singleChar );
        }
        return decryptList;
    }

    public char decrypt( char encryptedChar, int factor ){
        return alphabetList().get( Math.abs( alphabetList().indexOf( encryptedChar ) + ( 26 - factor) ) % 26 );
    }

    public List <Character> decryptedChars(List <Character>encryptedChars , int decryptShift ){
        List <Character> decryptedCharsList = new ArrayList<>();
        for( char encryptedChar : encryptedChars ){
            if( encryptedChar == ' ' )
                decryptedCharsList.add(' ');

            for( char alphaLetter : alphabetList() ){
                if( alphaLetter == encryptedChar)
                    decryptedCharsList.add(decrypt( alphaLetter, decryptShift));
            }
        }

        return decryptedCharsList;
    }

    public String decryptedWord (){

        return decryptedChars( charsToDecrypt( getWordToDecrypt() ), getDecryptFactor() )
                .stream().map(Object::toString)
                .collect(Collectors.joining());
    }
}
