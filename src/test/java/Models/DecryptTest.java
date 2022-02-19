package Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DecryptTest {
    Decrypt myDecrypt;

    @BeforeEach
    public void setUp(){
        myDecrypt = new Decrypt();
    }
    @Test
    @DisplayName("Object Instantaited")
    public void Decrypt_areObjectsInstantiated(){
        assertTrue(myDecrypt instanceof Decrypt);
    }

    @Test
    @DisplayName("Decrypt String Matches Regex")
    public void setWordToEncrypt_doesTheStringMatch() throws InvalidStringException {
        myDecrypt.setWordToDecrypt("Les Enfants TeRriBles");
        assertTrue(myDecrypt.validDecryptString( myDecrypt.getWordToDecrypt() ) );
    }

    @Test
    @DisplayName("Returns List of Encrypted Characters")
    public void charsToDecrypt_ReturnListOfCharacters() throws InvalidStringException {
        myDecrypt.setWordToDecrypt("Shalashaska");
        List<Character> testList = new ArrayList<>();
        char [] testChars = myDecrypt.getWordToDecrypt().toCharArray();
        for( char testChar : testChars ){
            testList.add(testChar);
        }
        assertEquals(testList,myDecrypt.charsToDecrypt(myDecrypt.getWordToDecrypt()));

    }

    @Test
    @DisplayName("Decrypted Characters As A List")
    public void decryptedChars_DecryptsCharactersInList_ArrayList() throws InvalidStringException {
        List <Character> testList = new ArrayList<>();
        myDecrypt.setWordToDecrypt("AHAT");

        for( char encryptedChar : myDecrypt.charsToDecrypt(myDecrypt.getWordToDecrypt()) ){
            if( encryptedChar == ' ') testList.add(' ');
                for( char alphaLetter : myDecrypt.alphabetList() ){
                    if( alphaLetter == encryptedChar )
                        testList.add(myDecrypt.decrypt( encryptedChar, 5) );
                }
        }
        assertEquals(testList,myDecrypt.decryptedChars( myDecrypt.charsToDecrypt
                ( myDecrypt.getWordToDecrypt() ) ,5) );
    }
}