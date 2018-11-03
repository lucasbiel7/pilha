/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

/**
 *
 * @author aluno
 * @param <T>
 */
public class Pilha<T> {

    private Object[] itens;
    private int maximo;
    private int topo;

    public Pilha(int maximo) {
        this.maximo = maximo;
        itens = new Object[maximo];
        topo = -1;
    }

    public Pilha(T... itens) {
        this(itens.length * 2);
        for (T item : itens) {
            push(item);
        }
    }

    public void limpar() {
        topo = -1;
    }

    public void push(T t) {
        /**
         * Caso a quantidade da pilha for alcançada o tamanho da pilha será
         * duplicada
         */
        if (full()) {
            Object[] itens = new Object[maximo * 2];
            maximo *= 2;
            for (int i = 0; i < this.itens.length; i++) {
                itens[i] = this.itens[i];
            }
            this.itens = itens;
        }
        itens[++topo] = t;
    }

    public T pop() {
        return (T) itens[topo--];
    }

    public T top() {
        return (T) itens[topo];
    }

    public boolean empty() {
        return topo < 0;
    }

    public boolean full() {
        return topo == maximo - 1;
    }

    public int size() {
        return topo + 1;
    }

    public void inverterTopoBase() {
        if (!empty()) {
            T aux = top();
            itens[topo] = itens[0];
            itens[0] = aux;
        }
    }
}
