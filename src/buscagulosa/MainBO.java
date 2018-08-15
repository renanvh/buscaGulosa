/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscagulosa;

import java.util.Stack;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;

/**
 *
 * @author Renan
 */
    public class MainBO{
        
       public QCJFrame view;
    public int[] estadoAtual;
    public ProblemaQC problema;
    public BuscaQC busca;
    public Stack<NoQC> solucao;
    private Color sucess = new Color(75, 165, 66);
    private Color error = new Color(255, 165, 0);
    private Color alert = new Color(255, 140, 0);
    private Color verde = new Color(72, 201, 66);
    private Color preto = new Color(0, 0, 0);
    private Color branco = new Color(255, 255, 255);

    public MainBO(QCJFrame view) {
        this.view = view;
        estadoAtual = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        this.problema = new ProblemaQC();
        this.problema.setEstadoInicial(estadoAtual);
        this.busca = new BuscaQC(problema);
    }

    

    private void imprimeEstado() {
        String estado = "";
        for (int i = 0; i < estadoAtual.length; i++) {
            if (i == estadoAtual.length - 1) {
                estado += estadoAtual[i];
            } else {
                estado += estadoAtual[i] + ", ";
            }
        }

        System.out.println("[ " + estado + " ] - Estado Atual");
    }

    public void resolve(String busca) {
        this.problema.setEstadoInicial(this.estadoAtual);

        long ti = 0, tf = 0;
        solucao = null;
        if ("Gulosa".equals(busca)) {
            System.out.println("== Busca Gulosa==");
            ti = System.currentTimeMillis();
            solucao = this.busca.gulosa();
            tf = System.currentTimeMillis();
        }

        //this.view.getLabelMensagem().setText("");
        if (solucao != null) {
            //solucao.pop();
            System.out.println(solucao.size());
            //this.view.getLabelNumPasso().setText((solucao.size() - 1) + "");
            //this.view.getLabelTempo().setText((tf - ti) + "");
            //imprimeCaminho((Stack<NoQC>) solucao.clone());

            if (this.problema.isObjetivo(solucao.pop().getEstado())) {
                //this.view.getLabelMensagem().setForeground(sucess);
                //this.view.getLabelMensagem().setText("Sucesso!");
            }

        } else {
            //this.view.getLabelMensagem().setForeground(error);
            //this.view.getLabelMensagem().setText("Erro!");
        }
    }




    




    
}
