package Models;

public class Decrypt {

    private String wordToDecrypt;

    public void setWordToDecrypt(String wordToDecrypt) {
        if(validDecryptString(wordToDecrypt)) {
            this.wordToDecrypt = wordToDecrypt;
        }
    }

    public String getWordToDecrypt() {
        return wordToDecrypt;
    }

    public boolean validDecryptString(String word){
        return word.matches("([a-zA-z]+|[a-zA-Z]+\\s[a-zA-Z]+)*");
    }
}
