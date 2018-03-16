class CaesarCipher {

    /** associates each single letter with its relative frequency in English;
     * also keeps track of the frequencies of some commonly encountered
     * letter pairs,letter triples and quadruples
     */
    private val letterFrequencies = mapOf<String, Int>("E" to 26, "T" to 25,
            "A" to 24, "O" to 23, "I" to 22, "N" to 21, "S" to 20,
            "H" to 19, "R" to 18, "D" to 17, "L" to 16, "C" to 15,
            "U" to 14, "M" to 13, "W" to 12, "F" to 11, "G" to 10,
            "Y" to 9, "P" to 8, "B" to 7, "V" to 6, "K" to 5, "J" to 4,
            "X" to 3, "Q" to 2, "Z" to 1, "TH" to 26, "HE" to 25, "IN" to 24,
            "ER" to 23, "AN" to 22, "RE" to 21, "ND" to 20, "THE" to 26,
            "AND" to 25, "THA" to 24, "ENT" to 23, "ING" to 22, "THAT" to 50,
            "THER" to 45, "WITH" to 40, "TION" to 35, "HERE" to 30)


    /**
     * @param[s] the string we want to encipher
     * @param[positions] the number of positions each character
     * will be rotated by
     */
    fun encipher(s: String, positions: Int): String {
        if (positions < 0 || positions > 25) {
            throw IllegalArgumentException()
        }
        output = StringBuilder()
        return encipherHelper(s, positions)

    }

    var output = StringBuilder()
    /**
     * a helper function which does the bulk of
     * rotating each individual character
     * @param[s] the string we want to encipher
     * @param[positions] the number of positions each character
     * will be rotated by
     * @return the enciphered string
     */
    private fun encipherHelper(s: String, positions: Int): String {
        if (s == "")
            return output.toString()
        else {
            output.append(rotateSingleCharacter(s[0], positions))
            return encipherHelper(s.substring(1), positions)
        }

    }

    /**
     * @param[c] the individual character to be rotated
     * @param[positions] the number of positions each character will be rotated by
     * @return the rotated character relative to the ASCII alphabet
     */
    fun rotateSingleCharacter(c: Char, positions: Int): Char {
        if (!c.isLetter())
            return c
        else {
            val start = if (c.isUpperCase()) 'A' else 'a'
            val output = ((((c + positions) - start) % 26) + start.toInt()).toChar()
            return output
        }
    }

    /**
     * @param[s] the string we want to decipher
     */
    fun decipher(s: String): String {
        if (s.isEmpty()) {
            return s
        }

        return decipherHelper(s)
    }

    /**
     * a helper function which does the bulk of deciphering
     * a string by seeking the maximum character frequency score in our map
     * @param[s] the string we want to decipher
     * @return the deciphered string
     */
    private fun decipherHelper(s: String): String {
        var highScore = 0
        var result = ""

        for (i in 0..25) {
            var cipheredString = encipher(s, i)
            var cipheredStringScore = checkScore(cipheredString.toUpperCase())
            if (cipheredStringScore > highScore) {
                highScore = cipheredStringScore
                result = cipheredString
            }
        }
        return result
    }

    /**
     * a function which calculates the frequency score
     * for a given string
     * @param[s] the string we want to decipher
     * @return the letter frequency score associated with a given word
     */
    fun checkScore(s: String): Int {
        var result = 0

        for (check in letterFrequencies.entries) {
            result += (s.split(check.key).size - 1) * check.value
        }
        return result
    }

}