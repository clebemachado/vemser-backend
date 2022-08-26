fun main(args: Array<String>) {
    condicionais();
    expressaoCondicional();
    funcaoWhen();
    val name:String= getString();
    println(name);
    println(funcaoComParametro(10));

    val stringLenghtFunc: (String) -> Int = {
        input -> input.length;
    }

    val testeString:Int = stringLenghtFunc("Teste");
    println(testeString);

    println(stringMapper("Testeeeee") { input -> input.length });


    val car = Car(listOf(Rodas("P"), Rodas("G")));

    for(roda in car.getListaRodas()){
        println(roda.tamanho)
    }

    val valor:Int =
        car.getListaRodas().stream().map { i -> i.tamanho.length}.count().toInt();

    println(valor)

}

fun declaracaoDeVariavel(){
    val cout:Int = 10;
    var cont:Int = 10;

    // Pode mudar
    cont = 1;

    // cout = 1; // Não pode mudar

    val languageName:String = "Kotlin";

}

fun segurancaNula() {
    // Kotlin não deixa valores nulos
    //val nome:String = null;

    val nome: String ? = null;
}

fun condicionais(){
    var count:Int = 10;

    if(count==10) {
        println("É igual a 10")
    } else {
        println("Diferente de 10")
    }


}

fun expressaoCondicional(){
    val count = 42;
    val resposta: String =
        if(count == 42){
            "res"
        } else if (count > 35){
            "Maior que 35"
        } else {
            "Não sei";
        }
    println(resposta);
}

fun funcaoWhen(){
    val count = 42;
    val resposta = when {
        count == 42 -> "I have the answer.";
        count > 35 -> "The answer is close.";
        else -> "The aanswe eludes me."
    };
    println(resposta);
}

fun getString():String {
    return "Uma string";
}

fun funcaoComParametro(valoUm:Int): String{
    return "Valor: $valoUm ";
}

fun stringMapper(str:String, mapper: (String) -> Int): Int {
    return mapper(str);
}