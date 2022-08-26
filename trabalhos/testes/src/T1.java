public class T1 {

    public static String order(String str){
        return new StringBuilder(str).reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(order("coderbytes"));
    }
}
