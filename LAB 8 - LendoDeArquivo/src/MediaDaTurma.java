import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MediaDaTurma{

    public static void main(String[] args){
        System.out.println(calcularMedia(defineNomeDoArquivo()));
    }

    public static float calcularMedia(String nomeDoArquivo){

        int totalDeLinhas = 0, linhasInvalidas = 0, linhasValidas;
        float totalDeNotas = 0;
        File arquivo = new File(nomeDoArquivo);
        Scanner scanner = null;

        try {
            scanner = new Scanner(arquivo);
            while (scanner.hasNext()) {
                try {
                    totalDeNotas += scanner.nextFloat();
                } catch (Exception e) {
                    linhasInvalidas++;
                    scanner.nextLine();
                } finally {
                    totalDeLinhas++;
                }
            }

            linhasValidas = totalDeLinhas - linhasInvalidas;

            if (linhasInvalidas <= (linhasValidas)){
                return totalDeNotas / linhasValidas;
            }
            else {
                ArquivoCorrompidoException e = new ArquivoCorrompidoException();
                e.setNumeroDeLinhasInvalidas(linhasInvalidas);
                e.printStackTrace();
                return e.getNumeroDeLinhasInvalidas();
            }

        } catch (FileNotFoundException e) {
            System.out.printf("\nO arquivo '%s' não foi encontrado. Indique um novo arquivo.%n", nomeDoArquivo);
            return calcularMedia(defineNomeDoArquivo());
        }
    }

    public static String defineNomeDoArquivo(){
        System.out.println("Insira o nome do arquivo a ser lido: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}

