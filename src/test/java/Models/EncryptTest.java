package Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class EncryptTest {
    Encrypt myTestEncrypt;

    @BeforeEach
    public void setUp(){
        myTestEncrypt = new Encrypt();
    }

    @Test
    @DisplayName("Are Objects Instantiated")
    public void Encrypt_ObjectsAreInstantiatedCorrectly() {
        assertTrue( myTestEncrypt instanceof  Encrypt );
    }

    @Test
    @DisplayName("Encrypt String Matches Regex")
    public void setWordToEncrypt_StringMatchesRegex() throws InvalidStringException{
        try {
            myTestEncrypt.setWordToEncrypt("Hey there how are you doing");
            assertTrue( myTestEncrypt.validEncryptString( myTestEncrypt.getWordToEncrypt() ) );
        }catch (InvalidStringException ex){
            ex.printStackTrace();
        }

    }

    @Test
    @DisplayName("Collect Characters")
    public void collectCharacters_CharactersAreCollectedInList_ArrayList() throws Exception {
        List <Character> testCharacters = new ArrayList<>();
        myTestEncrypt.setWordToEncrypt("Whats Happening People");
        for ( int i = 0; i < myTestEncrypt.getWordToEncrypt().length(); i++ ) {
            testCharacters.add( myTestEncrypt.getWordToEncrypt().toUpperCase().charAt(i) );
        }
        assertEquals( testCharacters, myTestEncrypt.collectCharacters( myTestEncrypt.getWordToEncrypt() ) );

    }

    @Test
    @DisplayName("Encrypted List")
    public void encryptedCharList_EncryptedCharactersAreCollectedInList_ArrayList() throws  Exception {
        List <Character> encryptedList = new ArrayList<>();
        myTestEncrypt.setWordToEncrypt("Ozum Jora Bishmelek Gurpgork");

        for( char collectedChar:myTestEncrypt.collectCharacters( myTestEncrypt.getWordToEncrypt() ) ){
            if( collectedChar == ' ' )  encryptedList.add(' ');
            for (char alphabetChar:myTestEncrypt.alphabetLetters() ) {
                if( alphabetChar == collectedChar ){
                    encryptedList.add( myTestEncrypt.encryptCharacters( collectedChar, 3 ) );
                }
            }
        }
        assertEquals(encryptedList, myTestEncrypt.encryptedCharList (myTestEncrypt.collectCharacters(myTestEncrypt.getWordToEncrypt()),3));
    }

    @Test
    @DisplayName("Returns String From List")
    void encryptedString_ReturnStringFromList_String() throws Exception {
        myTestEncrypt.setWordToEncrypt("Wer Rastet Der Rostet");
        myTestEncrypt.setShiftFactor(3);
        List <Character> myEncryptionList = myTestEncrypt.collectCharacters(myTestEncrypt.getWordToEncrypt());
        String myEncryptedString = myTestEncrypt.encryptedCharList(myEncryptionList,myTestEncrypt.getShiftFactor()).stream()
                                  .map(Objects::toString).collect(Collectors.joining());

        assertEquals( myEncryptedString, myTestEncrypt.encryptedString() );

    }
}