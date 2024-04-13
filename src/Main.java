public class Main {

    /*
        Criptografa seu texto

        @param word    Palavra a ser criptografada
        @param keyword Chave em que vai ser criptografada (Ela não pode ser muito grande!!)
     */
    static String criptografar(String word, String keyword) {

        StringBuilder builder = new StringBuilder();

        int index = 0;

        for (int i = 0; i < keyword.length(); i++) {
            index += (int) keyword.toCharArray()[i];
        }

        for (int i = 0; i < word.length(); i++) {
            builder.append((int) word.toCharArray()[i] * index + 10000000);
        }

        //A quantidade de caracteres precisa ser divisível por 8
        if (!(builder.toString().length()%8==0)) throw new UnsupportedOperationException("A chave que foi utiliada para criptografar é muito grande!");



        //Retorna a string porque o número pode ser muito grande

        return builder.toString();


    }

    /*
        Descriptografa seu texto
        Lembre-se de usar a mesma chave em que criptografou

        @param cripto  Palavra criptografada a ser descriptografada
        @param keyword Chave em que vai ser descriptografada
     */

    static String descriptografar(String cripto, String keyword) {


        //A quantidade de caracteres precisa ser divisível por 8
        if (!(cripto.length()%8==0)) throw new IllegalArgumentException("Esse não é um texto que foi criptografado!");


        StringBuilder builder = new StringBuilder();

        int index = 0;

        for (int i = 0; i < keyword.length(); i++) {
            index += keyword.toCharArray()[i];
        }

        for (int i = 0; i < cripto.length(); i+=8) {

            builder.append(

                    //Ela pega os 8 números da sequencia, pois 8 formam 1 caractere

                    (char) ((Integer.parseInt(
                            cripto.toCharArray()[i] + "" +
                                    cripto.toCharArray()[i+1] + "" +
                                    cripto.toCharArray()[i+2] + "" +
                                    cripto.toCharArray()[i+3] + "" +
                                    cripto.toCharArray()[i+4] + "" +
                                    cripto.toCharArray()[i+5] + "" +
                                    cripto.toCharArray()[i+6] + "" +
                                    cripto.toCharArray()[i+7] + ""

                    )- 10000000) / index)

            );
        }

        return builder.toString();

    }


    public static void main(String[] args) {
        //"Márica" sendo criptografado na chave abc
        System.out.println(criptografar("Maricá", "abc"));

        /*

        Esse conjunto de números é "Maricá" criptografado
        na chave abc.

        O texto só vai ser descriptografado com os mesmos
        caracteres que antes na chave abc

         */
        System.out.println(descriptografar("100226381002851810033516100308701002910610066150", "abc"));
    }

    //Eu fiz a criptografia de um trecho Lorem Impisum na chave "Lorem" não deu erro
}