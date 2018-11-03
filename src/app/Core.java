package app;

import entidades.Agenda;
import java.util.Scanner;
import utilitarios.Pilha;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aluno
 */
public class Core {

    public static void main(String[] args) {
        /**
         * Programa 1 e 2
         */
        Pilha<Agenda> pilha = new Pilha<>(1);
        Scanner scanner = new Scanner(System.in);
        int op;
        do {
            System.out.println("0-Sair");
            System.out.println("1-Inserir itens");
            System.out.println("2-Remover itens");
            System.out.println("3-Imprimir tamanho");
            System.out.println("4-Imprimir item topo");
            op = scanner.nextInt();
            Agenda agenda;
            switch (op) {
                case 0:
                    System.out.println("Até mais!");
                    break;
                case 1:
                    scanner.nextLine();
                    System.out.println("Digite o nome do contato");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o numero do contato");
                    long telefone = scanner.nextLong();
                    agenda = new Agenda(nome, telefone);
                    pilha.push(agenda);
                    break;
                case 2:
                    if (pilha.empty()) {
                        System.out.println("A pilha está vazia!");
                    } else {
                        System.out.println("Removido com sucesso a agenda " + pilha.pop());
                    }
                    break;
                case 3:
                    System.out.println(pilha.size());
                    break;
                case 4:
                    System.out.println(pilha.top());
                    break;
            }
        } while (op != 0);

        /**
         * Programa 3
         */
        System.out.println("*********************Exercicio 3***************************");
        //Topico 3,.1
        System.out.println("PROGRAMA PILHA");
        Pilha<Integer> pilhaMenu = new Pilha<>(5);
        do {
            System.out.println("0: Sair");
            System.out.println("1: Inserir Iens");
            System.out.println("2: Remover itens");
            System.out.println("3: Imprimir Tamanho");
            System.out.println("4: Imprimir Item Topo");
            op = scanner.nextInt();
            switch (op) {
                case 0:
                    System.out.println("Até mais!");
                    break;
                case 1:
                    if (!pilhaMenu.full()) {
                        System.out.println("Digite um numero");
                        pilhaMenu.push(scanner.nextInt());
                    } else {
                        System.out.println("Pilha cheia!");
                    }
                    break;
                case 2:
                    if (pilhaMenu.empty()) {
                        System.out.println("Pilha vazia");
                    } else {
                        System.out.println("Foi removido o número " + pilhaMenu.pop());
                    }
                    break;
                case 3:
                    System.out.println("Tamanho: " + pilha.size());
                    break;
                case 4:
                    if (pilhaMenu.empty()) {
                        System.out.println("Pilha vazia");
                    } else {
                        System.out.println("Topo: " + pilhaMenu.top());
                    }
                    break;
            }
        } while (op != 0);

        //Topico 3.2
        Pilha<Integer> numeros = new Pilha<>(1, 5, 9, 3);
        numeros.push(2);
        System.out.println(numeros.pop());
        System.out.println(numeros.pop());
        System.out.println(numeros.top());
        numeros.push(7);
        System.out.println(numeros.pop());
        System.out.println(numeros.pop());
        numeros.push(4);
        System.out.println(numeros.pop());
        System.out.println(numeros.pop());
        numeros.push(8);
        numeros.push(6);
        numeros.pop();
        //Topico 3.3
        //Método para trocar o lugar do topo com a base
        numeros.inverterTopoBase();
        System.out.println(numeros.top());
        //Topico 3.4
        Pilha<Integer> pilhaPar = new Pilha<>(10);
        Pilha<Integer> pilhaImpar = new Pilha<>(10);
        System.out.println("Programa para leitura de 10 números e divir nas pilhas de pares e impares");
        for (int i = 0; i < 10; i++) {
            System.out.println("Digite um número");
            int numero = scanner.nextInt();
            if (numero % 2 == 0) {
                pilhaPar.push(numero);
            } else {
                pilhaImpar.push(numero);
            }
        }
        System.out.println("Pilha com valores par");
        while (!pilhaPar.empty()) {
            System.out.println(pilhaPar.pop());
        }

        System.out.println("Pilha com valores impares");

        while (!pilhaImpar.empty()) {
            System.out.println(pilhaImpar.pop());
        }
        /**
         * Programa 4
         */
        System.out.println("*******************Exercicio 4 ***************");
        scanner.nextLine();
        String palavra;
        Pilha<String> pilhaMaiuscula = new Pilha<>(1);
        Pilha<String> pilhaMinuscula = new Pilha<>(1);
        do {
            System.out.println("Digite uma palavra! '999' para sair");
            palavra = scanner.nextLine();
            for (int i = 0; i < palavra.length(); i++) {
                String letra = palavra.substring(i, i + 1);
                if (letra.matches("[A-Z]{1}")) {
                    pilhaMaiuscula.push(letra);
                } else if (letra.matches("[a-z]{1}")) {
                    pilhaMinuscula.push(letra);
                }
            }
        } while (!palavra.equals("999"));
        System.out.println("Letras maiúsculas");
        while (!pilhaMaiuscula.empty()) {
            System.out.println(pilhaMaiuscula.pop());
        }
        System.out.println("Letras minúsculas");
        while (!pilhaMinuscula.empty()) {
            System.out.println(pilhaMinuscula.pop());
        }
    }
}
