
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        char[] vocals = {'a', 'e', 'i', 'o', 'u'};
        BufferedReader br = new BufferedReader(new FileReader(".\\src\\net\\text\\lorem_ipsum.txt"));
        String line;
        StringBuilder textoCompleto = new StringBuilder();
        int contador = 0;

        while ((line = br.readLine()) != null) {
            textoCompleto.append(line).append("\n");
        }
        String text = textoCompleto.toString();
        File output = new File(".\\src\\net\\text\\output.txt");

        try {
            for (char vocal : vocals) {
                ProcessBuilder pb = new ProcessBuilder("java", ".\\src\\net\\contador\\Contador.java", String.valueOf(vocal), text);
                pb.redirectOutput(ProcessBuilder.Redirect.appendTo(output));
                pb.start();

                for (char caracter : text.toCharArray()) {
                    if (vocal == caracter) {
                        contador++;
                    }
                }
            }
            System.out.println(text + "\n" + contador + " vocales ");
        } catch (Exception e) {
            e.fillInStackTrace();
        }

    }
}
