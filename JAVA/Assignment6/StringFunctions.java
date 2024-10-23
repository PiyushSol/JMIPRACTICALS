public class StringFunctions {
    private String text;

    //Constructor to initialise the String
    public StringFunctions(String text){
        setText(text);
    }

    //Method to set the text
    public void setText(String text){
        this.text = text;
    }

    //Method to get the count of characters in the String.
    public int getCharactersCount(){
        if(text.isEmpty()|| text==null)
            return 0;
        return  getText().length();
    }

    //Method to get the words count in the String.
    public int getWordsCount(){
        if(text== null || text.isEmpty()){
            return 0;
        }
        String words[] = text.trim().split("\\s+");
        return words.length;
    }

    //Method to get the count of number of lines in the String.
    public int getLines(){
        if(text== null || text.isEmpty()){
            return 0;
        }
        int no_of_lines=0;
        String lines[] = getText().split("\\r?\\n");
        no_of_lines = lines.length;
        return no_of_lines;
    }

    //Method to reverse each word in the given String.
    public String reverseWords(){
        String [] words= text.split(" ");
        String [] newWords = new String[words.length];
        //Intialising all the words to empty String
        for(int i=0;i< newWords.length;i++){
            newWords[i]="";
        }
        //Outer Loop to get and traverse each word in the string.
        for(int i=0;i<words.length;i++){
            //Character Array to store characters of each word in the given string
            char []word = words[i].toCharArray();
            //Loop to add the reverse word in the newWords array.
            for(int j=word.length-1;j>=0;j--){
                newWords[i]+=(word[j]);
            }
        }
        //Finally Joining the array back to produce the original string.
        String newText = String.join(" ",newWords);
        return newText;
    }
    public String getText(){
        return this.text;
    }

    //Method to make the String in the sentence case.
    public String makeSentenceCase(){
        String []lines = text.split("\\r?\\n");
        StringBuilder newLines = new StringBuilder();
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                newLines.append(Character.toUpperCase(line.charAt(0)))
                        .append(line.substring(1).toLowerCase())
                        .append("\n");
            }
        }
        return newLines.toString().trim();
    }

    //Method to print the entire String in the reverse order
    public StringBuilder reverseString(){
        StringBuilder newStr  = new StringBuilder();
        if(text.isEmpty() || text == null){
            return new StringBuilder(" ");
        }
        String []words = getText().split(" ");
        for(int i=words.length-1;i>=0;i--){
            newStr.append(words[i]);
            if (i > 0) {
                newStr.append(" ");
            }
        }
        return newStr;
    }
}
