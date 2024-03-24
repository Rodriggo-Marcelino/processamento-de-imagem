import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criando um objeto Scanner para receber entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicitando o nome do arquivo de imagem ao usuário
        System.out.println("Digite o nome do arquivo de imagem (sem extensão):");
        String nomeArquivo = scanner.nextLine();

        // Solicitando ao usuário que escolha o tipo de processamento de imagem
        System.out.println("Escolha o tipo de processamento:");
        System.out.println("1. Escala de Cinza");
        System.out.println("2. Banda Binária");
        System.out.println("3. Negativa");
        int opcao = scanner.nextInt();

        try {
            // Lendo a imagem original a partir do arquivo fornecido pelo usuário
            File input = new File(nomeArquivo + ".jpeg");
            BufferedImage imagemOriginal = ImageIO.read(input);

            BufferedImage imagemProcessada = null;
            // Aplicando o processamento de acordo com a opção escolhida pelo usuário
            switch (opcao) {
                case 1:
                    imagemProcessada = converterParaEscalaDeCinza(imagemOriginal);
                    break;
                case 2:
                    imagemProcessada = converterParaBinaria(imagemOriginal);
                    break;
                case 3:
                    imagemProcessada = converterParaNegativa(imagemOriginal);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    return;
            }

            // Salvando a imagem processada com um sufixo "_processada" no nome do arquivo
            File output = new File(nomeArquivo + "_processada.jpeg");
            ImageIO.write(imagemProcessada, "jpg", output);
            System.out.println("Imagem processada salva como " + nomeArquivo + "_processada.jpeg");
        } catch (IOException e) {
            // Lidando com exceções de entrada e saída, se houver
            e.printStackTrace();
        }
    }

    // Função para converter a imagem para escala de cinza
    public static BufferedImage converterParaEscalaDeCinza(BufferedImage imagem) {
        // Criando uma nova imagem em tons de cinza com as mesmas dimensões da imagem original
        BufferedImage imagemCinza = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
        // Iterando sobre cada pixel da imagem original
        for (int y = 0; y < imagem.getHeight(); y++) {
            for (int x = 0; x < imagem.getWidth(); x++) {
                // Obtendo o valor RGB do pixel
                int rgb = imagem.getRGB(x, y);
                // Extraindo os componentes de cor vermelha, verde e azul
                int red = (rgb >> 16) & 0xff;
                int green = (rgb >> 8) & 0xff;
                int blue = rgb & 0xff;
                // Calculando o valor de cinza utilizando a fórmula de luminosidade
                int cinza = (int) (0.299 * red + 0.587 * green + 0.114 * blue);
                // Criando um novo valor RGB com os três componentes iguais ao valor de cinza calculado
                int novoRgb = (cinza << 16) | (cinza << 8) | cinza;
                // Definindo o pixel na imagem em tons de cinza
                imagemCinza.setRGB(x, y, novoRgb);
            }
        }
        return imagemCinza;
    }

    // Função para converter a imagem para binária
    public static BufferedImage converterParaBinaria(BufferedImage imagem) {
        BufferedImage imagemBinaria = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < imagem.getHeight(); y++) {
            for (int x = 0; x < imagem.getWidth(); x++) {
                int rgb = imagem.getRGB(x, y);
                int red = (rgb >> 16) & 0xff;
                int green = (rgb >> 8) & 0xff;
                int blue = rgb & 0xff;
                int cinza = (int) (0.299 * red + 0.587 * green + 0.114 * blue);
                // Convertendo para binário com base em um limiar de 128
                int novoRgb = (cinza > 128 ? 255 : 0) << 16 | (cinza > 128 ? 255 : 0) << 8 | (cinza > 128 ? 255 : 0);
                imagemBinaria.setRGB(x, y, novoRgb);
            }
        }
        return imagemBinaria;
    }

    // Função para converter a imagem para negativa
    public static BufferedImage converterParaNegativa(BufferedImage imagem) {
        BufferedImage imagemNegativa = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < imagem.getHeight(); y++) {
            for (int x = 0; x < imagem.getWidth(); x++) {
                int rgb = imagem.getRGB(x, y);
                int red = (rgb >> 16) & 0xff;
                int green = (rgb >> 8) & 0xff;
                int blue = rgb & 0xff;
                // Calculando a negativa de cada componente de cor
                int novoRgb = (255 - red) << 16 | (255 - green) << 8 | (255 - blue);
                // Definindo o pixel na imagem negativa
                imagemNegativa.setRGB(x, y, novoRgb);
            }
        }
        return imagemNegativa;
    }
}
