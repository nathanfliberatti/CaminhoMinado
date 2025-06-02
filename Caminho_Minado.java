
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Nathan
 */
public class Caminho_Minado {
    
    public static int tamanhoCaminho() {
        Scanner input = new Scanner(System.in);
        
        int tamanho = 0;
        
        while(tamanho <= 1) {
            System.out.println("Digite o tamanho do caminho:");
            tamanho = input.nextInt();
        }
        
        return tamanho;
    }
    
    public static int qtdeBombas(int tamanho){
        Scanner input = new Scanner(System.in);
        
        int bombas = 0;
        
        while(bombas <= 0 || bombas >= tamanho){
            System.out.println("Digite a quantidade de bombas que existem no caminho:");
            bombas = input.nextInt();
        }
        
        return bombas;
    }
    
    
    public static int[] colocarBombas(int tamanho, int bombas) {
        Random rnd = new Random();

        int[] caminho = new int[tamanho];
        
        int bombasColocadas = 0;
        
        while(bombasColocadas < bombas) {
            int posicao = rnd.nextInt(tamanho);
            
            if (caminho[posicao] != -1) {
                caminho[posicao] = -1;
                bombasColocadas++;  
            }
        }
        
        return caminho;
}

    
    public static String[] inicializarCaminho(int tamanho) {
        String[] caminho = new String[tamanho];
        
        for(int i = 0; i < tamanho; i++) {
            caminho[i] = "_";
        }
        return caminho;
    }
    
    public static void mostrarCaminho(String[] caminho) {
        for(int i = 0; i < caminho.length; i++) {
            System.out.print(caminho[i] + " ");
        }
        System.out.println();
    }
    
    
    public static int pedirPosicao(String[] caminho) {
        Scanner input = new Scanner(System.in);
        
        int posicao = -1;
        
        while (true) {
            System.out.print("Escolha a posição (1 a " + caminho.length + "): ");
            posicao = input.nextInt() - 1;
            if (posicao < 0 || posicao >= caminho.length) {
                System.out.println("Posição inválida! Tente novamente.");
            } else if (!caminho[posicao].equals("_")) {
                System.out.println("Posição já escolhida! Tente outra.");
            } else {
                break;
            }
        }
        return posicao;
    }
    
    
    public static boolean bombaProxima(int[] bombasEscondidas, int posicao) {
        int esquerda = posicao -1;
        int direita = posicao +1;
        
        if (esquerda >= 0 && bombasEscondidas[esquerda] == - 1) {
            return true;
        }
        if(direita < bombasEscondidas.length && bombasEscondidas[direita] == -1) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public static void mostrarCaminhoFinal(int[] bombasEscondidas, String[] caminhoJogador) {
        for (int i = 0; i < bombasEscondidas.length; i++) {
            if (bombasEscondidas[i] == -1) {
                System.out.print("b ");
            } else if (caminhoJogador[i].equals("x")) {
                System.out.print("x ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }
    
    
    public static void main(String[] args) {
        int tamanho = tamanhoCaminho();
        int bombas = qtdeBombas(tamanho);
        int[] bombasEscondidas = colocarBombas(tamanho, bombas);
        String[] caminhoJogador = inicializarCaminho(tamanho);
        
        int pontos = 0;
        int pontosMaximos = tamanho - bombas;
        boolean jogoAtivo = true;
        
        mostrarCaminho(caminhoJogador);
        
        
        while(jogoAtivo) {
            int posicaoEscolhida = pedirPosicao(caminhoJogador);
            
            if (bombasEscondidas[posicaoEscolhida] == -1) {
                caminhoJogador[posicaoEscolhida] = "b";
                System.out.println("Game over!");
                jogoAtivo = false;
            } else{
                caminhoJogador[posicaoEscolhida] = "x";
                pontos++;
                mostrarCaminho(caminhoJogador);
                
                if (bombaProxima(bombasEscondidas, posicaoEscolhida)) {
                    System.out.println("Cuidado: bomba próxima!");
                }
                
                if (pontos == pontosMaximos) {
                    System.out.println("Parabéns, você ganhou o jogo!");
                    jogoAtivo = false;
                }
            }
        }
        
        System.out.println("Sua pontuacao: " + pontos + " de " + pontosMaximos);
        System.out.println("Caminho Final:");
        mostrarCaminhoFinal(bombasEscondidas, caminhoJogador);
    
    }
}
