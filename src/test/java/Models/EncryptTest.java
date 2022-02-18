package Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}