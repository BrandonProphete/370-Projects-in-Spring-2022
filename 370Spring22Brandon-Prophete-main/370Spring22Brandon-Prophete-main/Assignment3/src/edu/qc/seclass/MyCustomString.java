package edu.qc.seclass;

public class MyCustomString implements MyCustomStringInterface {
   
   private String inputString;
   
   public String getString() {
      
        if(inputString != null) {
           return inputString;
        }
        
        return null;
        
   }

  public void setString(String string) {
     
              this.inputString = string;
              
  }
  
  public int countNumbers() throws NullPointerException{
             int countNumber = 0;
             char[] charArray;
             
             if(inputString == null) {
                throw new NullPointerException();
             }
             
             if(inputString == null) {
                return 0;
             }
             
             charArray= inputString.toCharArray();
             if(charArray.equals("")||charArray.equals(null)) {
                return 0;
             }
           for(int a = 0; a < charArray.length; a++) {
              
               char c = charArray[a];
               if(Character.isDigit(c)) {
                  countNumber++;
                  for(int s = a + 1; s < charArray.length; s++) {
                     char ch = charArray[s];
                     if(!Character.isDigit(ch)) {
                        a = s - 1;
                        break;
                     }
                     if(Character.isDigit(ch) && (s ==(charArray.length - 1))){
                        return countNumber;
                     }
                  }
               }
           }
           return countNumber;
             
  }
  
public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) throws NullPointerException, IllegalArgumentException {
   
             StringBuilder newString = new StringBuilder();
             if(n <= 0) {
                throw new IllegalArgumentException();
             }
             else if(inputString == null) {
                 throw new NullPointerException();
             }
             else if(inputString.length() < n) {
                return "";
             }
             else {
                if(startFromEnd == false) {
                   char[] charArray = inputString.toCharArray();
                   
                   for(int b = n; b < inputString.length(); b = b + n) {
                      
                      newString.append(charArray[b-1]);
                   }
                }
                else {
                   String reversedString = new StringBuilder(inputString).reverse().toString();
                   char[] charArray = reversedString.toCharArray();
                   for(int b = n; b < inputString.length(); b = b + n) {
                      
                      newString.append(charArray[b-1]);
                   }
                   newString.reverse();
                }
             }
   
  return newString.toString();           
             
}

public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) throws MyIndexOutOfBoundsException, IllegalArgumentException, NullPointerException{
             
            if(inputString == null) {
               throw new NullPointerException();
            }
   
            if(startPosition > endPosition) {
               throw new IllegalArgumentException();
            }
            if(startPosition < 1 || endPosition > this.inputString.length()) {
               throw new MyIndexOutOfBoundsException();
            }
                 
           String newString = inputString.substring(startPosition-1, endPosition); 
           
           newString = newString.replaceAll("0","Zero");
           newString = newString.replaceAll("1","One");
           newString = newString.replaceAll("2","Two");
           newString = newString.replaceAll("3","Three");
           newString = newString.replaceAll("4","Four");
           newString = newString.replaceAll("5","Five"); 
           newString = newString.replaceAll("6","Six");
           newString = newString.replaceAll("7","Seven");
           newString = newString.replaceAll("8","Eight");
           newString = newString.replaceAll("9","Nine");
            
           
           this.inputString = inputString.substring(0, startPosition- 1) + newString  + inputString.substring(endPosition, inputString.length());
           
}


}


