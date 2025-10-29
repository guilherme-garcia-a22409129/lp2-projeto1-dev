package pt.ulusofona.lp2.greatprogrammingjourney;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class Jogador {
    static final Cor[] CORES = {Cor.PURPLE, Cor.BLUE, Cor.GREEN, Cor.BROWN};
    int id;
    String nome;
    String linguagensFavoritas;
    Cor cor;
    int posicao;

    public Jogador( int id, String nome, String linguagensFavoritas) {
        this.id = id;
        this.nome = nome;
        this.linguagensFavoritas = linguagensFavoritas;
        this.cor = CORES [id - 1];
        this.posicao = 1; // Posição inicial
    }

    public int getId() {
        return id;
    }

    public String getNome() { return nome; }

    public String getLinguagensFavoritas() {
        String[] linguagens = linguagensFavoritas.split(";");
        Arrays.sort(linguagens);

        return String.join(";", linguagens);
    }

    public boolean estaNaPosicao(int posicao) {
        return getPosicao()==posicao;
    }

    public  void avancarCasas(int nrCasas) {
        this.posicao += nrCasas;
    }

    public  void vaiParaPosicao(int novaPosicao) {
        this.posicao = novaPosicao;
    }

    public Cor getCor() {
        return cor;
    }

    public int getPosicao() {
        return posicao;
    }


}
