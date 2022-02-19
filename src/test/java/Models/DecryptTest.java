package Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    public void setWordToEncrypt_doesTheStringMatch() {
        myDecrypt.setWordToDecrypt("Les Enfants TeRriBles");
        assertTrue(myDecrypt.validDecryptString( myDecrypt.getWordToDecrypt() ) );
    }
}