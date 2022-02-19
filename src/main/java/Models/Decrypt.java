package Models;

import java.util.ArrayList;
import java.util.List;

public class Decrypt {

    private String wordToDecrypt;
    private int decryptFactor;

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

    public List<Character> charsToDecrypt(String encryptedWord){
        List <Character> decryptList = new ArrayList<>();
        char [] decryptArray = encryptedWord.toCharArray();
        for( char singleChar : decryptArray ){
            decryptList.add( singleChar );

        }
        return decryptList;
    }
}
