public class Outra {
    public static boolean validar(String nome){
        // Valida Tamanho
if(nome.length < 4 || nome
        .length() > 25) {
    return false;
}

char[] charArray = nome.toCharArray();

// valida o 2
if(((int)charArray[0]  >= 65 && (int)charArray[0] <= 90 ) || ((int)charArray[0]  >= 97 && (int)charArray[0] <= 122 )){
    // deixa assim
}else {
    return false;
}

// valida o 3
for(char l: charArray){
    if(((int)l  >= 65 && (int)l <= 90 ) || ((int)l  >= 97 && (int)l <= 122 ) || ((int)l == 95)){
        continue;
    } else {
        return false;
    }
}
// valida o 4
if(((int)charArray[charArray.length - 1] == 95)){
    return false;
}
return true;
    }

    public static void main(String[] args) {
        System.out.println(validar("aaaa"));
    }
}
