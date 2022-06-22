public class Contato {

    String descricao;
    String telefone;
    Integer tipo;

    @Override
    public String toString() {
        return "Contato{" + "\n" +
                "   descricao='" + descricao + ", \n" +
                "   telefone='" + telefone + ", \n" +
                "   tipo=" + tipo + ", \n" +
                '}';
    }
}
