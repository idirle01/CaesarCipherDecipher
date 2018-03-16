import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class CipherTest {
    val cipher = CaesarCipher()

    @Test
    fun test25Limit () {
        assertFails {
            (cipher.encipher("abcd",33))
            (cipher.encipher("abcd",-1))
        }
    }

    @Test
     fun returnSameIfNotLetter() {
        assertEquals('@', cipher.rotateSingleCharacter('@',3))

    }

    @Test
    fun returnCipheredLowercase() {
        assertEquals('y', cipher.rotateSingleCharacter('x', 1))
    }

    @Test
    fun returnCipheredUppercase() {
        assertEquals('Y', cipher.rotateSingleCharacter('X', 1))
    }

    @Test
    fun testIfReturnsItself() {
        assertEquals("", cipher.encipher("",5))
    }

    @Test
    fun testIfEnciphers() {
        assertEquals("bcde", cipher.encipher("abcd",1))
        assertEquals("BCDE", cipher.encipher("ABCD",1))
    }

    @Test
    fun `Deciphering an empty string should return an empty string`() {
        assertEquals("", cipher.decipher(""))
    }

    @Test
    fun `Should decipher all given strings`() {
        assertEquals("Hello World!", cipher.decipher("Ifmmp Xpsme!"))
        assertEquals("Caesar cipher? I prefer Caesar salad.",
                cipher.decipher("Bzdrzq bhogdq? H oqdedq Bzdrzq rzkzc."))

    }

    @Test
    fun `testScore`() {
        assertEquals (75, cipher.checkScore("ETA"))
    }


}