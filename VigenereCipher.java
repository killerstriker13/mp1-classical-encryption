/**
 * Implementation of Vigenere Cipher
 * 
 * @author Shibam Mukhopadhyay
 */
public class VigenereCipher {
    /**
     * main function
     * @param args
     * @throws Exception
     */
  public static void main (String[] args) throws Exception {
    if (args.length != 3) {                   // checking if there are 3 arguments inputted
      System.err.println("Incorrect number of parameters");
      System.exit(2);                // exit code for incorrect number of parameters
    }
    
    String instruct = args[0];
    String inputStr = args[1];
    String key = args[2];
    
    java.io.PrintWriter pen;
    pen = new java.io.PrintWriter(System.out, true);
    
    if (!(instruct.equals("encode") || instruct.equals("decode"))) {  //checks whether instruction is encode or decode
      System.err.println("Valid options are \"encode\" or \"decode\"");
      System.exit(1);                 // exit code for invalid instruction
    }
    if (inputStr.equals("") || (key.equals(""))) { //if inputStr or key is empty
      pen.println(inputStr);
    } else if (instruct.equals("encode")){
      pen.println(encode(inputStr, key, 1)); //helper function called
    }
    else {
      pen.println(decode(inputStr, key));            //helper function called
    }
  }//main(String [])
    /**
     * code shifts inputChar based on given key
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
     * encode returns encoded version of inputStr using key
     * @param inputStr
     * @param key
     * @param encrypt
     * @return String
     */
    public static String encode(String inputStr, String key, int encrypt) {
      char[] arr;
      int actualKey;
      char letter;
      int base = (int) 'a';
      int keylen = key.length();
      arr = new char[inputStr.length()];

      for (int i = 0; i < inputStr.length(); i++) {
        letter = inputStr.charAt(i);
        actualKey = (int) key.charAt(i%keylen) - base;
        if (encrypt == 1){
          arr[i] = code(letter, actualKey);
        } else {
          arr[i] = code(letter, -actualKey);
        }
      }
      return new String(arr);
    }//encode(String inputStr, String key, int encrypt)
    /**
     * decode using encode function with given inputStr and key
     * @param inputStr
     * @param key
     * @return
     */
    public static String decode(String inputStr, String key) {
      return encode(inputStr, key, -1);
    }//decode(String inputStr, String key)
}// class VigenereCipher
    
    