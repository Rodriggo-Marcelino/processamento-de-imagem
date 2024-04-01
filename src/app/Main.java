package app;

import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {

        // Abertura da imagem
        BufferedImage imagem = ManipulaImagem.abrirImagem("lena.jpg");

        // Aplicação do filtro de binarização na imagem, com threshold 127, e atribuição do resultado à variável 'binarizada'
        BufferedImage binarizada = OpPontuais.binarizacao(imagem, 127);

        // Conversão da imagem para escala de cinza e atribuição do resultado à variável 'grayscale'
        BufferedImage grayscale = OpPontuais.grayscale(imagem);

        // Aplicação do filtro negativo na imagem e atribuição do resultado à variável 'negativo'
        BufferedImage negativo = OpPontuais.filtroNegativo(imagem);

        // Aplicação do filtro RGBy na imagem e atribuição do resultado à variável 'rgby'
        BufferedImage rgby = OpPontuais.rgby(imagem);

        // Aplicação do filtro RGB na imagem com valores de componente vermelho, verde e azul especificados e atribuição do resultado à variável 'rgb'
        BufferedImage rgb = OpPontuais.rgb(imagem, 100, 50, 150); // Valores arbitrários apenas para demonstração

        // Aplicação do ajuste de brilho adicional na imagem e atribuição do resultado à variável 'brilhoAdicional'
        BufferedImage brilhoAdicional = OpPontuais.brilhoAdicional(imagem, 100);
        BufferedImage brilhoAdicionalMult = OpPontuais.brilhoAdicionalMult(imagem, 100);

        // Extração da banda vermelha da imagem e atribuição do resultado à variável 'bandaRed'
        BufferedImage bandaRed = OpPontuais.bandaRed(imagem);

        // Extração da banda verde da imagem e atribuição do resultado à variável 'bandaGreen'
        BufferedImage bandaGreen = OpPontuais.bandaGreen(imagem);

        // Extração da banda azul da imagem e atribuição do resultado à variável 'bandaBlue'
        BufferedImage bandaBlue = OpPontuais.bandaBlue(imagem);


        BufferedImage conversaoYIQtoRgb = OpPontuais.conversaoYIQtoRgb(imagem);

        // Exibição das imagens resultantes na tela, com a imagem original seguida pelas imagens modificadas
        ManipulaImagem.exibirImagens(
                imagem,
                binarizada,
                grayscale,
                negativo,
                rgby,
                rgb,
                brilhoAdicional,
                brilhoAdicionalMult,
                bandaRed,
                bandaGreen,
                bandaBlue,
                conversaoYIQtoRgb
        );

        // Salvando a última imagem modificada ('brilhoAdicional') em disco
        ManipulaImagem.salvarImagem(brilhoAdicional);
    }
}
