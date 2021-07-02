import edu.duke.*;
/**
 * クラス CaesarCipher2 の注釈をここに書きます.
 * 
 * @author Taiga Shiga
 * @version 2021/07/2
 */
public class CaesarCipher2 {
    
    // check ch is lower or not
    public boolean isLower(char ch){
        boolean lowerOr = false;
        if(Character.isLowerCase(ch)){
            lowerOr = true;
        }
        return lowerOr;
    }
    
    // encrypt 
    /**
     * encrypt(“First Legion”, 23);
     * Cfopq Ibdflk”
     * 
     * encrypt method be able to handle both uppercase and lowecase letters
     */
    public String encrypt(String input, int key){
         // first input is make 
         StringBuilder encrypted = new StringBuilder(input);
         String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
         // if key = 3 D....ABC
         String shiftedAlphabet = alphabet.substring(key)+
         alphabet.substring(0,key);
         int idx = 0;
         for(int i=0; i < encrypted.length(); i++){
            // ch = F i r s t I e g i o n 
            char ch = encrypted.charAt(i);
            // check uppercase or lowercase
            if(isLower(ch)){
                // is lower true 
                char toUpperCh = Character.toUpperCase(ch);
                idx = alphabet.indexOf(toUpperCh);
            }else{
                idx = alphabet.indexOf(ch);
            }
            
 
            if( idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                if(isLower(ch)){
                     char newChar = shiftedAlphabet.charAt(idx);
                     newChar = Character.toLowerCase(newChar);
                     encrypted.setCharAt(i, newChar);
                }else{
                     char newChar = shiftedAlphabet.charAt(idx);
                     encrypted.setCharAt(i, newChar);
                }
            }
        }
         String result = encrypted.toString();
         return result;
    }
    
    
    /**
     * "First legion"
     *  01234 5678910
     * 
     */
    public String enryptTwoKeys(String input, int key1, int key2){
         StringBuilder encrypted = new StringBuilder(input);
         String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
         
         String shiftedAlphabet1 = alphabet.substring(key1)+
         alphabet.substring(0,key1);
        
         String shiftedAlphabet2 = alphabet.substring(key2)+
         alphabet.substring(0,key2);
         int idx = 0;
         for(int i=0; i<encrypted.length(); i++){
            char ch = encrypted.charAt(i);
            // check uppercase or lowercase
            if(isLower(ch)){
                // is lower true 
                char toUpperCh = Character.toUpperCase(ch);
                idx = alphabet.indexOf(toUpperCh);
            }else{
                idx = alphabet.indexOf(ch);
            }
            
            if(idx != -1 && i%2==0){
                if(isLower(ch)){
                     char newChar = shiftedAlphabet1.charAt(idx);
                     newChar = Character.toLowerCase(newChar);
                     encrypted.setCharAt(i, newChar);
                }else{
                     char newChar = shiftedAlphabet1.charAt(idx);
                     encrypted.setCharAt(i, newChar);
                    }
            }else if(idx != -1 && i%2==1){
                if(isLower(ch)){
                     char newChar = shiftedAlphabet2.charAt(idx);
                     newChar = Character.toLowerCase(newChar);
                     encrypted.setCharAt(i, newChar);
                }else{
                     char newChar = shiftedAlphabet2.charAt(idx);
                     encrypted.setCharAt(i, newChar);
                    }
            }
           
        }
        return encrypted.toString();
    }
    
    public void testTwoEncrypted(){
       int key1 = 8;
       int key2 = 21;
       String words = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
       String enryptTwoKeys = enryptTwoKeys(words, key1,key2);
       System.out.println(enryptTwoKeys);
    }
    
    
    public void testCaesar(){
       /**
       FileResource fr = new FileResource();
       String message = fr.asString();
       System.out.println(message);
       */
       int key = 15;
       String words = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
       String encrypted = encrypt(words, key);
       System.out.println("key is " + key + "\n" + encrypted);
    }
}
