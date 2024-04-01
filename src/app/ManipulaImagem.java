package app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ManipulaImagem {

    // Método para salvar uma imagem em disco
    public static void salvarImagem(BufferedImage imagem) {
        try {
            // Tenta escrever a imagem no formato JPG em um arquivo chamado "lena_resultado.jpg"
            ImageIO.write(imagem, "jpg", new File("lena_resultado.jpg"));

        } catch (IOException e) { // Se ocorrer um erro de entrada/saída durante a escrita

            System.out.println("Erro ao salvar a imagem"); // Exibe uma mensagem de erro

            throw new RuntimeException(e); // Lança uma exceção indicando o erro ocorrido
        }
    }

    // Método para exibir imagens em uma janela Swing
    public static void exibirImagens(BufferedImage... imagens) {
        JFrame janela = new JFrame(); // Cria uma nova janela Swing

        janela.setTitle("Processamento de Imagens"); // Define o título da janela

        janela.getContentPane().setLayout(new FlowLayout()); // Define o layout da área de conteúdo da janela como um layout de fluxo (FlowLayout)

        // Itera sobre cada imagem passada como argumento
        for (BufferedImage img : imagens) {

            JLabel label = new JLabel(new ImageIcon(img)); // Cria um rótulo Swing com a imagem

            janela.getContentPane().add(label); // Adiciona o rótulo à área de conteúdo da janela
        }

        janela.pack(); // Ajusta o tamanho da janela com base no conteúdo

        janela.setVisible(true); // Torna a janela visível

        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Define o comportamento de fechamento da janela
    }

    // Método para abrir uma imagem a partir de um arquivo
    public static BufferedImage abrirImagem(String path) {
        try {
            // Tenta ler a imagem do arquivo especificado pelo caminho 'path'
            return ImageIO.read(new File(path));

        } catch (IOException e) { // Se ocorrer um erro de entrada/saída durante a leitura

            System.out.println("Erro ao ler a imagem"); // Exibe uma mensagem de erro

            throw new RuntimeException(e); // Lança uma exceção indicando o erro ocorrido
        }
    }
}
