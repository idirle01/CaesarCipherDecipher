class CaesarCipher {
    val map = mapOf<String, Int>("E" to 26, "T" to 25,
            "A" to 24, "O" to 23, "I" to 22, "N" to 21, "S" to 20,
            "H" to 19, "R" to 18, "D" to 17, "L" to 16, "C" to 15,
            "U" to 14, "M" to 13, "W" to 12, "F" to 11, "G" to 10,
            "Y" to 9, "P" to 8, "B" to 7, "V" to 6, "K" to 5, "J" to 4,
            "X" to 3, "Q" to 2, "Z" to 1)


    fun encipher(s: String, positions: Int): String {
        if (positions < 0 || positions > 25) {
            throw IllegalArgumentException()
        }
        output = StringBuilder()
        return encipherHelper(s, positions)

    }

    var output = StringBuilder()
    fun encipherHelper(s: String, positions: Int): String {
        if (s == "")
            return output.toString()
        else {
            output.append(rotateSingleCharacter(s[0], positions))
            return encipherHelper(s.substring(1), positions)
        }

    }

    fun rotateSingleCharacter(c: Char, positions: Int): Char {
        if (!c.isLetter())
            return c
        else {
            //return 's'
            val start = if (c.isUpperCase()) 'A' else 'a'
            val output = ((((c + positions) - start) % 26) + start.toInt()).toChar()
            return output
        }

    }

    fun decipher(s: String): String {
        if (s.isEmpty()) {
            return s
        }

        return decipherHelper(s)
    }


    fun decipherHelper(s: String): String {
        var highScore = 0
        var result = ""

        for (i in 0..25) {
            var cipheredString = encipher(s, i)
            println(cipheredString)
            var cipheredStringScore = checkScore(cipheredString)
            println(cipheredStringScore)
            if (cipheredStringScore > highScore) {
                highScore = cipheredStringScore
                result =  cipheredString
            }
        }
        return result
    }

    fun checkScore(s: String): Int {
        var result = 0
        for (ch in s) {
            if (ch.isLetter()) {
                result += map.getValue(ch.toUpperCase().toString())
            }
        }
        return result
    }


}