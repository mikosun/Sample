public class Main {
    public static char code[] = {'A','B','C','D','E','F','G','H','I'};
    
    public static boolean isNum(String num){
        try{
            Integer.parseInt(num);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static char encode(int num){
        if((num / 8) == 0) return code[num];
        while((num / 8) != 0){
            num /= 8;
        }
        return code[num];
    }
    
    public static int decode(char a[]){
        int number = 0;
        for(int i =0; i < a.length; i++){
            int weight = 1;
            for(int j = 0; j < 9; j++){
                if(a[i] == code[j]) number = (weight * 1) + number;
            }
            weight *= 10;
        }
        return number;
    }
    
    public static void main(String args[]){
        try{
            int number = Integer.parseInt(args[0]);
            do{
                System.out.print(encode(number));
                if((number/8) != 0 && (number % 8) != 0){
                    System.out.println(code[(number % 8)-1]);
                }
                number /= 8;
            }while((number/8) != 0);
            
        }catch(Exception e){
            char[] c = args[0].toCharArray();
            System.out.println(decode(c));
        }         
    }
}