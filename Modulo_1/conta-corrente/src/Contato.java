public class Contato {

    String descricao;
    String telefone;
    Integer tipo;

    void imprimirContato(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        String tipoContato = tipo == 0 ? "Residencial" : "Comercial";
        return "Contato{" + "\n" +
                "   descricao='" + descricao + ", \n" +
                "   telefone='" + telefone + ", \n" +
                "   tipo=" + tipoContato + ", \n" +
                '}';
    }
}
