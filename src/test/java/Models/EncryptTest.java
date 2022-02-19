package Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class EncryptTest {
    Encrypt myTestEncrypt;

    @BeforeEach
    public void setUp(){
        myTestEncrypt = new Encrypt();
    }

    @Test
    @DisplayName("Are Objects Instantiated")
    public void Encrypt_areObjectsInstantiated() {
        assertTrue(myTestEncrypt instanceof  Encrypt);
    }

    @Test
    @DisplayName("Encrypt String Matches Regex")
    public void setWordToEncrypt_doesTheStringMatch() {
        myTestEncrypt.setWordToEncrypt("Hey there how are you doing");
        assertTrue(myTestEncrypt.validEncryptString(myTestEncrypt.getWordToEncrypt()));
    }

    @Test
    @DisplayName("Collect Characters")
    public void collectCharacters_areCharactersCollectedInALIst_ArrayList() {
        List<Character> testCharacters = new ArrayList<>();
        myTestEncrypt.setWordToEncrypt("Whats Happening People");
        for (int i = 0; i < myTestEncrypt.getWordToEncrypt().length(); i++) {
            testCharacters.add(myTestEncrypt.getWordToEncrypt().toUpperCase().charAt(i));
        }
        assertEquals(testCharacters,myTestEncrypt.collectCharacters(myTestEncrypt.getWordToEncrypt()));

    }

    @Test
    @DisplayName("Encrypted List")
    public void EnctyptedList_areEncryptedCharactersCollectedInALIst_ArrayList() {
        List<Character> encryptedList = new ArrayList<>();
        myTestEncrypt.setWordToEncrypt("What are you");

        for(char collectedChar:myTestEncrypt.collectCharacters(myTestEncrypt.getWordToEncrypt())){
            if( collectedChar == ' ' )  encryptedList.add(' ');
            for (char alphabetChar:myTestEncrypt.alphabetLetters() ) {
                if( alphabetChar == collectedChar ){
                    encryptedList.add(myTestEncrypt.encryptCharacters(collectedChar,3));
                }
            }
        }
        assertEquals(encryptedList,myTestEncrypt.encryptedWordList(myTestEncrypt.collectCharacters(myTestEncrypt.getWordToEncrypt()),3));
    }
}