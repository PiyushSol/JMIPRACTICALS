import java.util.Random;

public class Password {
    //Declarations of all the sets needed for password.
    private static final char[] specialChars = {'!','\"','#','$','%','&','\'','(',')','*','+','-','.','/',':',';','<','=','>','?','@','[',']','^','_',
            '`','{','|','}','~'};
    private static final char[] lowerLetters ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private static final char[] upperLetters ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private static final char[] digits={'0','1','2','3','4','5','6','7','8','9'};

    private Random random = new Random();

    public String generatePassword(){
        StringBuilder password = new StringBuilder();
        password.append(specialChars[random.nextInt(specialChars.length)]);
        password.append(lowerLetters[random.nextInt(lowerLetters.length)]);
        password.append(upperLetters[random.nextInt(upperLetters.length)]);
        password.append(digits[random.nextInt(digits.length)]);

        int length = random.nextInt(8,16);
        char[][] chars = new char[][]{specialChars,lowerLetters,upperLetters,digits};

        for(int i=4;i<length;i++){
               int index = random.nextInt(0,4);
               int el;
                if(index == 0){
                     el= random.nextInt(specialChars.length);
                    password.append(chars[index][el]);
                }
                if(index ==1){
                    el= random.nextInt(lowerLetters.length);
                    password.append(chars[index][el]);
                }
                if(index ==2){
                    el= random.nextInt(upperLetters.length);
                    password.append(chars[index][el]);
                }
                if(index == 3){
                    el= random.nextInt(digits.length);
                    password.append(chars[index][el]);
                }

        }

        return shuffle(password.toString());
    }

    //Shuffling the password to ensure the random occuring of characters
    private String shuffle(String pass){
        char[] chars = pass.toCharArray();
        for(int i=chars.length-1;i>0;i--){
            int j = random.nextInt(i + 1);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
