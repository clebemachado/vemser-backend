public class Code {
    public static void main(String[] args) {
        Integer num = 10;
        String palavra = "";
        for(int i = 1; i <= num; i++){
            if(i % 3 == 0 && i % 5 == 0){
                palavra += "FizzBuzz ";
            } else if(i % 3 == 0){
                palavra += "Fizz ";
            } else if(i % 5 == 0){
                palavra +=  "Buzz ";
            } else {
                palavra += i + " ";
            }
        }
        System.out.println(palavra);



    }
}
