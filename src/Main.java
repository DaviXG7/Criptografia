public class Main {

    static String criptografar(String word, String keyword) {

        StringBuilder builder = new StringBuilder();

        int index = 0;

        for (int i = 0; i < keyword.length(); i++) {
            index += (int) keyword.toCharArray()[i];
        }

        for (int i = 0; i < word.length(); i++) {
            builder.append((int) word.toCharArray()[i] * index + 10000000);
        }

        return builder.toString();


    }

    static String descriptografar(String cripto, String keyword) {

        if (!(cripto.length()%8==0)) throw new IllegalArgumentException("Esse não é um texto que foi criptografado!");


        StringBuilder builder = new StringBuilder();

        int index = 0;

        for (int i = 0; i < keyword.length(); i++) {
            index += keyword.toCharArray()[i];
        }

        for (int i = 0; i < cripto.length(); i+=8) {

            builder.append(

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
        System.out.println(criptografar("Maricá", "abc"));
        System.out.println(descriptografar("100226381002851810033516100308701002910610066150", "abc"));
    }
}