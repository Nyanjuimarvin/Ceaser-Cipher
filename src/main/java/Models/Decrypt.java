package Models;

public class Decrypt {

    private String wordToDecrypt;
    private int decryptFactor;

    public void setWordToDecrypt(String wordToDecrypt) {
        if(validDecryptString(wordToDecrypt)) {
            this.wordToDecrypt = wordToDecrypt;
        }
    }

    public String getWordToDecrypt() {
        return wordToDecrypt;
    }

    public void setDecryptFactor(int decryptFactor) {
        if(decryptFactor > 0 && decryptFactor <= 26) this.decryptFactor = decryptFactor;
    }

    public int getDecryptFactor() {
        return decryptFactor;
    }

    public boolean validDecryptString(String word){
        return word.matches("([a-zA-z]+|[a-zA-Z]+\\s[a-zA-Z]+)*");
    }
}
