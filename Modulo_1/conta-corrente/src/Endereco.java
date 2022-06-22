public class Endereco {

    Integer tipo;
    String logradouro;
    Integer numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    void imprimirEndereco(){
        System.out.println(this);
    }

    @Override
    public String toString() {

        return "Endereco{" + "\n" +
                "   tipo=" + tipo + ", \n" +
                "   logradouro='" + logradouro + ", \n" +
                "   numero=" + numero + ", \n" +
                "   complemento='" + complemento + ", \n" +
                "   cep='" + cep + ", \n" +
                "   cidade='" + cidade + ", \n" +
                "   estado='" + estado + ", \n" +
                "   pais='" + pais + ", \n" +
                '}';
    }
}
