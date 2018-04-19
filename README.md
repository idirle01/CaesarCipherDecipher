# SDP Assignment Two Caesar Decipher – Pairs Assignment


# Authors
- bkyle02 (captainrobertnorman) Brett Kyle
- idirle01                      Iulia Dirleci

# Method
This code was largely written in the SDP class in week 9 (Thursday, 08-03-2018) as part of the SDP coursework portfolio, 
using the guidelines detailed on the SDP website. 
We followed a TDD approach throughout, ensuring the code passed all the tests we had written before.

# Frequency Count Approach
For single letters, we used the monogram frequencies detailed at https://en.wikipedia.org/wiki/Letter_frequency, assigning the
highest score (26) to E, the highest next score (25) to the next most commonly encountered letter in English (T), and so on. 

We also took into account an adapted version of bigram, trigrams and quadgram frequencies from
http://practicalcryptography.com/cryptanalysis/letter-frequencies-various-languages/english-letter-frequencies/

# Results
Our cipher and decipher methods have been tested and they work. However, because we have only included the most frequently used 
bigrams,trigrams and quadgrams, a more fine - grained decipher method would need to include more letter frequencies in the future.  
