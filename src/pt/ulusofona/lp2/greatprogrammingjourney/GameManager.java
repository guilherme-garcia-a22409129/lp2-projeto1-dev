package pt.ulusofona.lp2.greatprogrammingjourney;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Integer.parseInt;

public class GameManager {
    Tabuleiro tabuleiro;
    static HashMap <Integer, Jogador> jogadores = new HashMap<>();
    int jogadorAtual;


    public GameManager() {

    }
    public boolean createInitialBoard(String[][] playerInfo, int worldSize){
        int playerCount = 0;
        if (playerInfo[0][0] != null) {
            playerCount++;
            Jogador jogador1 =
                    new Jogador(parseInt(playerInfo[0][0]),
                            playerInfo[0][1], playerInfo[0][2]);
            jogadores.put(parseInt(playerInfo[0][0]), jogador1);
        }
        if (playerInfo[1][0] != null) {
            playerCount++;
            Jogador jogador2 =
                    new Jogador(parseInt(playerInfo[1][0]),
                            playerInfo[1][1], playerInfo[1][2]);
            jogadores.put(parseInt(playerInfo[1][0]), jogador2);

        }
        if (playerInfo[2][0] != null) {
            playerCount++;
            Jogador jogador3 =
                    new Jogador(parseInt(playerInfo[2][0]),
                            playerInfo[2][1], playerInfo[2][2]);
            jogadores.put(parseInt(playerInfo[2][0]), jogador3);
        }
        if (playerInfo[3][0] != null) {
            playerCount++;
            Jogador jogador4 =
                    new Jogador(parseInt(playerInfo[3][0]),
                            playerInfo[3][1], playerInfo[3][2]);
            jogadores.put(parseInt(playerInfo[3][0]), jogador4);
        }

        if (playerCount < 2) {
            return false;
        }

        if (worldSize >= playerCount * 2) {
            tabuleiro = new Tabuleiro(worldSize);
            return true;
        } else {
            return false;
        }
    }

    public String getImagePng(int nrSquare) {
        if (nrSquare == 1) {
            return "start.png";
        } else if (nrSquare == tabuleiro.getUltimaPosicao()) {
            return "finish.png";
        } else if (nrSquare > 0 && nrSquare < tabuleiro.getUltimaPosicao()) {
            return "normal.png";
        }else {
            return null;
        }
    }

    public String[] getProgrammerInfo(int id){
        Jogador jogador = jogadores.get(id);

        if (jogador != null) {
            String[] info = new String[4];
            info[0] = Integer.toString(jogador.getId());
            info[1] = jogador.getNome();
            info[2] = jogador.getLinguagensFavoritas();
            info[3] = jogador.getCor().toString();
            return info;
        } else {
            return null;
        }
    }

    public String getProgrammerInfoAsStr(int id){
        Jogador jogador = jogadores.get(id);

        if (jogador != null) {
            return jogador.getId() +
                    " | " + jogador.getNome() +
                    " | " + jogador.getPosicao() +
                    " | " + jogador.getLinguagensFavoritas() +
                    " | " + "Em Jogo"; // Estado fixo como "Em Jogo" ate á pt2
        } else {
            return null;
        }
    }

    public String[] getSlotInfo(int position){
        String infoArr[] = new String[1];
        String info = null;

        for (Jogador jogador : jogadores.values()) {
            if (jogador.estaNaPosicao(position)) {

                if (info == null) {
                    info = Integer.toString(jogador.getId());
                } else {
                    info += "," + jogador.getId();
                }
            }
        }

        infoArr[0] = info;
        return infoArr;
    }

    public int getCurrentPlayerID(){
        return jogadorAtual;
    }

    public boolean moveCurrentPlayer(int nrSpaces){
        if (nrSpaces <= 0 ) {
            return false;
        }
        Jogador jogador = getJogadorAtual();
        int posicaoInicial = jogador.getPosicao();
        if (posicaoInicial + nrSpaces <= tabuleiro.getUltimaPosicao()) {
            jogador.avancarCasas(nrSpaces);
            return true;
        } else {
            int casasAmais = nrSpaces - tabuleiro.casasAteAMeta(posicaoInicial);

            jogador.vaiParaPosicao(tabuleiro.ultimaPosicao - casasAmais);
            return true;
        }
    }

    public boolean gameIsOver(){
        for (Jogador jogador : jogadores.values()) {
            if (jogador.estaNaPosicao(tabuleiro.getUltimaPosicao())) {
                return true;
            }
        }
        return false;
    }

    public Jogador getJogador(int id) {
        return jogadores.get(id);
    }

    public Jogador getJogadorAtual() {
        return jogadores.get(jogadorAtual);
    }
}
