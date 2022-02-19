package Models;

import java.util.ArrayList;

public class Encrypt {

    private String wordToEncrypt;

    public void setWordToEncrypt(String wordToEncrypt) {
        if(validEncryptString(wordToEncrypt)) {
            this.wordToEncrypt = wordToEncrypt;
        }

    }

    public String getWordToEncrypt() {
        return wordToEncrypt;
    }

    public boolean validEncryptString(String word){
        return word.matches("([a-zA-z]+|[a-zA-Z]+\\s[a-zA-Z]+)*");
    }

}
