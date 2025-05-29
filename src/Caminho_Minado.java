
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
    
    
    public static int passos(String[] caminho) {
        Scanner input = new Scanner(System.in);
        
        int posicaoEscolhida = 0;
        
        System.out.println("Escolha a posicao de onde quer ir: ");
        posicaoEscolhida = input.nextInt() - 1;
        
        if(caminho[posicaoEscolhida].equals("_")) {
            caminho[posicaoEscolhida] = "x";
        }
        
        mostrarCaminho(caminho);
        
        return posicaoEscolhida;
    }
    
    
    
    public static void main(String[] args) {
        int tamanho = tamanhoCaminho();
        int bombas = qtdeBombas(tamanho);
        int[] bombasEscondidas = colocarBombas(tamanho, bombas);
        String[] caminho = inicializarCaminho(tamanho);
        mostrarCaminho(caminho);
        passos(caminho);
    
    
    
    
        for(int i = 0; i < tamanho; i++) {
            System.out.print(bombasEscondidas[i] + " ");
        }
    
    }
}
