package app;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;

public class OpPontuais {
    // Método para alterar os valores dos componentes RGB de uma imagem
    public static BufferedImage rgb(BufferedImage img, int redValue, int greenValue, int blueValue) {

        // Obtém a largura da imagem
        int largura = img.getWidth();

        // Obtém a altura da imagem
        int altura = img.getHeight();

        // Cria uma nova imagem com as mesmas dimensões e tipo da imagem original
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        // Itera sobre cada pixel da imagem
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {
                // Obtém a cor do pixel atual
                Color cor = new Color(img.getRGB(w, h));

                // Calcula os novos valores para os componentes RGB
                int newRed = Math.min(255, cor.getRed() + redValue); //255 Representa o valor Maximo é a soma de getRed + red value Não ultrapasse ele
                int newGreen = Math.min(255, cor.getGreen() + greenValue);
                int newBlue = Math.min(255, cor.getBlue() + blueValue);

                // Cria uma nova cor com os valores calculados
                Color novaCor = new Color(newRed, newGreen, newBlue);

                // Define a cor do pixel na imagem de saída
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        // Retorna a imagem resultante
        return imagemSaida;
    }

    // Método para extrair a banda vermelha de uma imagem
    public static BufferedImage bandaRed(BufferedImage img) {

        // Obtém a largura da imagem
        int largura = img.getWidth();

        // Obtém a altura da imagem
        int altura = img.getHeight();

        // Cria uma nova imagem com as mesmas dimensões e tipo da imagem original
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        // Itera sobre cada pixel da imagem
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {

                // Obtém a cor do pixel atual
                Color cor = new Color(img.getRGB(w, h));

                // Cria uma nova cor considerando apenas o componente vermelho
                Color novaCor = new Color(cor.getRed(), 0, 0);

                // Define a cor do pixel na imagem de saída
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        // Retorna a imagem resultante
        return imagemSaida;
    }

    // Método para extrair a banda verde de uma imagem
    public static BufferedImage bandaGreen(BufferedImage img) {
        // Obtém a largura da imagem
        int largura = img.getWidth();

        // Obtém a altura da imagem
        int altura = img.getHeight();

        // Cria uma nova imagem com as mesmas dimensões e tipo da imagem original
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        // Itera sobre cada pixel da imagem
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {

                // Obtém a cor do pixel atual
                int rgb = img.getRGB(w, h);
                Color cor = new Color(rgb);

                // Obtém o componente verde da cor
                int green = cor.getGreen();

                // Cria uma nova cor considerando apenas o componente verde
                Color novaCor = new Color(0, green, 0);

                // Define a cor do pixel na imagem de saída
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        // Retorna a imagem resultante
        return imagemSaida;
    }

    // Método para extrair a banda azul de uma imagem
    public static BufferedImage bandaBlue(BufferedImage img) {

        // Obtém a largura da imagem
        int largura = img.getWidth();

        // Obtém a altura da imagem
        int altura = img.getHeight();

        // Cria uma nova imagem com as mesmas dimensões e tipo da imagem original
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        // Itera sobre cada pixel da imagem
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {

                // Obtém a cor do pixel atual
                int rgb = img.getRGB(w, h);
                Color cor = new Color(rgb);

                // Obtém o componente azul da cor
                int blue = cor.getBlue(); // get : pegando o pixel da cor

                // Cria uma nova cor considerando apenas o componente azul
                Color novaCor = new Color(0, 0, blue);

                // Define a cor do pixel na imagem de saída
                imagemSaida.setRGB(w, h, novaCor.getRGB()); // set: colocar a cor no pixel.
            }
        }
        // Retorna a imagem resultante
        return imagemSaida;
    }

    // Método para aplicar a técnica de binarização em uma imagem
    public static BufferedImage binarizacao(BufferedImage img, int limiar) {
        // Obtém a largura da imagem
        int largura = img.getWidth();

        // Obtém a altura da imagem
        int altura = img.getHeight();

        // Cria uma nova imagem com as mesmas dimensões e tipo da imagem original
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        // Itera sobre cada pixel da imagem
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {

                // Obtém a cor do pixel atual
                Color cor = new Color(img.getRGB(w, h));

                // Calcula a média dos componentes RGB do pixel
                int media = (cor.getRed() + cor.getGreen() + cor.getBlue()) / 3;

                // Define a cor do pixel na imagem de saída com base no limiar
                Color novaCor = media > limiar ? Color.WHITE : Color.BLACK; //Operador Ternario

                // Define a cor do pixel na imagem de saída
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        // Retorna a imagem resultante
        return imagemSaida;
    }

    // Método para converter uma imagem para escala de cinza
    public static BufferedImage grayscale(BufferedImage img) {

        // Obtém a largura da imagem
        int largura = img.getWidth();

        // Obtém a altura da imagem
        int altura = img.getHeight();

        // Cria uma nova imagem com as mesmas dimensões e tipo da imagem original
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        // Itera sobre cada pixel da imagem
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {

                // Obtém a cor do pixel atual
                Color cor = new Color(img.getRGB(w, h));

                // Calcula a média dos componentes RGB do pixel
                int media = (cor.getRed() + cor.getGreen() + cor.getBlue()) / 3;

                // Cria uma nova cor com os valores médios
                Color novaCor = new Color(media, media, media);

                // Define a cor do pixel na imagem de saída
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        // Retorna a imagem resultante
        return imagemSaida;
    }

    // Método para aplicar o filtro negativo em uma imagem
    public static BufferedImage filtroNegativo(BufferedImage img) {
        // Obtém a largura da imagem
        int largura = img.getWidth();

        // Obtém a altura da imagem
        int altura = img.getHeight();

        // Cria uma nova imagem com as mesmas dimensões e tipo da imagem original
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        // Itera sobre cada pixel da imagem
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {

                // Obtém a cor do pixel atual
                Color cor = new Color(img.getRGB(w, h));

                // Calcula o negativo de cada componente RGB
                Color novaCor = new Color(255 - cor.getRed(), 255 - cor.getGreen(), 255 - cor.getBlue());

                // Define a cor do pixel na imagem de saída
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        // Retorna a imagem resultante
        return imagemSaida;
    }

    // Método para aplicar o filtro RGBy em uma imagem
    public static BufferedImage rgby(BufferedImage img) {
        // Obtém a largura da imagem
        int largura = img.getWidth();

        // Obtém a altura da imagem
        int altura = img.getHeight();

        // Cria uma nova imagem com as mesmas dimensões e tipo da imagem original
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        // Itera sobre cada pixel da imagem
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {

                // Obtém a cor do pixel atual
                Color cor = new Color(img.getRGB(w, h));

                // Reduz pela metade o componente verde da cor
                Color novaCor = new Color(cor.getRed(), cor.getGreen() / 2, cor.getBlue());

                // Define a cor do pixel na imagem de saída
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        // Retorna a imagem resultante
        return imagemSaida;
    }

    // Método para aplicar um brilho adicional em uma imagem
    public static BufferedImage brilhoAdicional(BufferedImage img, int valor) {

        // Obtém a largura da imagem
        int largura = img.getWidth();

        // Obtém a altura da imagem
        int altura = img.getHeight();

        // Cria uma nova imagem com as mesmas dimensões e tipo da imagem original
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        // Itera sobre cada pixel da imagem
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {

                // Obtém a cor do pixel atual
                Color cor = new Color(img.getRGB(w, h));

                // Adiciona o valor especificado a cada componente RGB, limitando o resultado a 255
                int red = Math.min(255, cor.getRed() + valor);
                int green = Math.min(255, cor.getGreen() + valor);
                int blue = Math.min(255, cor.getBlue() + valor);

                // Cria uma nova cor com os valores ajustados
                Color novaCor = new Color(red, green, blue);

                // Define a cor do pixel na imagem de saída
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        // Retorna a imagem resultante
        return imagemSaida;
    }

    public static BufferedImage brilhoAdicionalMult(BufferedImage img, int valor) {

        // Obtém a largura da imagem
        int largura = img.getWidth();

        // Obtém a altura da imagem
        int altura = img.getHeight();

        // Cria uma nova imagem com as mesmas dimensões e tipo da imagem original
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        // Itera sobre cada pixel da imagem
        for (int h = 0; h < altura; h++) {
            for (int w = 0; w < largura; w++) {

                // Obtém a cor do pixel atual
                Color cor = new Color(img.getRGB(w, h));

                // Adiciona o valor especificado a cada componente RGB, limitando o resultado a 255
                int red = Math.min(255, cor.getRed() * valor);
                int green = Math.min(255, cor.getGreen() * valor);
                int blue = Math.min(255, cor.getBlue() * valor);

                // Cria uma nova cor com os valores ajustados
                Color novaCor = new Color(red, green, blue);

                // Define a cor do pixel na imagem de saída
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        // Retorna a imagem resultante
        return imagemSaida;
    }

    public static BufferedImage conversaoYIQtoRgb(BufferedImage img){
        int largura = img.getWidth();
        int altura = img.getHeight();
        BufferedImage imagemSaida = new BufferedImage(largura, altura, img.getType());

        for (int h = 0; h < altura; h++){
            for(int w = 0; w < largura; w++){
                 Color cor = new Color(img.getRGB(w, h));

                 //Extrair os componentes YIQ
                double Y = cor.getRed();
                double I = cor.getGreen();
                double Q = cor.getBlue();

                //Converte para RGB
                int R = (int) (Y + 0.956 * I + 0.261 * Q);
                int G = (int) (Y - 0.272 * I - 0.647 * Q);
                int B = (int) (Y - 1.106 * I + 1.703 * Q);

                R = Math.min(Math.max(R, 0), 255); 
                G = Math.min(Math.max(G, 0), 255); // Math.max(valor da variavel maior que 0)
                B = Math.min(Math.max(B, 0), 255);

                Color novaCor = new Color(R,G,B);
                imagemSaida.setRGB(w,h,novaCor.getRGB());
            }
        }
        //Retorna imagem resultante
        return imagemSaida;
    }
}
