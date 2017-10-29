
package ontop;

 /**
 *
 * @author ryahiaoui
 */
 public class URLEncoder {
    
              
    public static String encode(String input) {
        
        StringBuilder resultStr = new StringBuilder() ;
        
        for (char ch : input.toCharArray()) {
            
            if (isUnsafe(ch)) {
                
                resultStr.append('%')            ;
                resultStr.append(toHex(ch / 16)) ;
                resultStr.append(toHex(ch % 16)) ;
                
            } else {
                resultStr.append(ch);
            }
        }
        
        return resultStr.toString() ;
    }
    
    private static char toHex(int ch) {
        return (char) (ch < 10 ? '0' + ch : 'A' + ch - 10) ;
    }
    
    private static boolean isUnsafe(char ch) {
        return " %".indexOf(ch) >= 0 ;
    }
 }
