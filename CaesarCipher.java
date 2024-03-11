/**
 * Implementation of Caesar Cipher
 *
 * @author Shibam Mukhopadhyay
 */
public class CaesarCipher {
    /**
     * main function
     * @param args
     * @throws Exception
     */
  public static void main (String[] args) throws Exception {
    if (args.length != 2) {              // checking if there are 2 arguments inputted
    System.err.println("Incorrect number of parameters");
    System.exit(2);           // exit code for incorrect number of parameters
    }
    
    String instruct = args[0];
    String inputStr = args[1];
    
    if (!(instruct.equals("encode") || instruct.equals("decode"))) { //checks whether instruction is encode or decode
      System.err.println("Valid options are \"encode\" or \"decode\"");
      System.exit(1);         // exit code for invalid instruction
    }
            
    
    java.io.PrintWriter pen;
    pen = new java.io.PrintWriter(System.out, true);
    
    if (instruct.equals("encode")){ 
      for (int i = 0; i < 26; i++){               // prints out all encryptions of the input
        pen.println("n = "+ i + ": " + encode(inputStr, i)); // helper function called
      }
    }
      else {
        for (int i = 0; i < 26; i++){                // prints out all decryptions of the input
          pen.println("n = "+ i + ": " + decode(inputStr, i));  // helper function called
        }
      }
    } //main(String [])
    
  /**
   * shifts inputChar using key
   * @param inputChar
   * @param key
   * @return char
   */
  public static char code(char inputChar, int key) {
    int shift;
    int base = (int) 'a';
    shift = (((int) inputChar + key - base)+26) % 26;
    return (char) (shift + base);
    } //code(char inputChar, int key)

  /** 
   * encode encodes the inputStr with key, returns encoded version of inputStr
   * @param inputStr
   * @param key
   * @return String
   */
  public static String encode(String inputStr, int key) {
    char[] arr;
    char letter;
    
    arr = new char[inputStr.length()];   // sets the length of char[] arr to that of inputStr
    for (int i = 0; i < inputStr.length(); i++) {
      letter = inputStr.charAt(i);
      arr[i] = code(letter, key);
    }
    return new String(arr);
  }//encode(String inputStr, int key)

  /**
   * decode decodes the inputStr with key, returns decoded version of inputStr
   * @param inputStr
   * @param key
   * @return String
   */
  public static String decode(String inputStr, int key) {
    return encode(inputStr, -key);
  }//decode(String inputStr, int key)
} // class CaesarCipher
    