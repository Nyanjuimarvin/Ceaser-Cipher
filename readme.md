# CEASER CIPHER
## Description
A console application that encrypts and decrypts words using a shift factor. The encryption technique used is the Ceaser Cipher.
## Technologies used
- Intelli j
- Gradle
- Junit


## Behavior Driven Development
A strict set of rules is followed from the point of entering a word to the process of encryption and decryption. The behavior driven development used is as follows:  
| Behavior                            | Input                                                      | Expected Output                                                         |
|-------------------------------------|------------------------------------------------------------|-------------------------------------------------------------------------|
| Encrypt a Word using a shift Factor | A string of words 2 and a shifting factor                  | A word whose letters are encrypted using the given shift factor         |
| Decrypt the encrypted word          | The encrypted word from the first step,the shifting factor | A word or string of words decrypted using the shift factor from before. |
|                                     |                                                            |                                                                         |

## Test Driven Development
The methods that handle encryption and decryption go through a series of tests before they return the desired output. These tests are written with the help of jUnit.

## Setup
### Prerequisites
- Java Runtime Environment
- Java Development Kit ( JDK 11 + )
- Gradle

### Install

Clone the repository using the following command:  
```git clone https://github.com/Nyanjuimarvin/Ceaser-Cipher.git```

### Run
Open the project directory in the terminal and navigate to the java directory using:  
```cd src/main/java```  
After navigation, compile the files using:  
```javac *.java```  
And finally run the app using:  
```java App```


## Contact
For any issues, additional requests or compliments, reach out to me using:
* E-mail - marnyanjui@gmail.com



## License and Copyright

Copyright 2022 Marvin Nyanjui

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.