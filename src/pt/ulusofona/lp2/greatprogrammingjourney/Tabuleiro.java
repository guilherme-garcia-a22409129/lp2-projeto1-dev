package pt.ulusofona.lp2.greatprogrammingjourney;

public class Tabuleiro {
    int tamanho;
    int ultimaPosicao = tamanho - 1;

    public Tabuleiro(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getUltimaPosicao() {
        return ultimaPosicao;
    }

    public int casasAteAMeta(int posicaoAtual) {
        return tamanho - posicaoAtual;
    }
}
