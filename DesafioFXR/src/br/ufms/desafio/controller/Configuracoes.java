/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.desafio.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 *   @author Rafael Viana - Debian 8
 */
public class Configuracoes extends TrocarCena implements Initializable {

    @FXML
    private Button btnHome;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnProcurar;
    @FXML
    private Button btnConfig;
    static String imagem = "br/ufms/desafio/view/css/desafio.css";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnHome.setOpacity(0.3);
        btnRegistrar.setOpacity(0.3);
        btnProcurar.setOpacity(0.3);
        btnConfig.setOpacity(1);
    }

    @FXML
    private void home(ActionEvent event) {
        trocarCena(event, "br/ufms/desafio/view/fxml/TesteLogin.fxml");
    }

    @FXML
    private void registrar(ActionEvent event) {
        trocarCena(event, "br/ufms/desafio/view/fxml/Registrar.fxml");
    }

    @FXML
    private void procurar(ActionEvent event) {
    }

    @FXML
    private void configuracoes(ActionEvent event) {
    }

    private void trocar_fundo(ActionEvent event) {
        System.out.println("trocando");
        trocarCena(event, "br/ufms/desafio/view/fxml/Configuracoes.fxml");
    }

    @FXML
    private void trocar_fundo_foto_1(ActionEvent event) {

        imagem = "br/ufms/desafio/view/css/desafio.css";
        trocar_fundo(event);

    }

    @FXML
    private void trocar_fundo_foto_2(ActionEvent event) {
    
        imagem = "br/ufms/desafio/view/css/desafio2.css";
        trocar_fundo(event);
    }

    @FXML
    private void trocar_fundo_foto_3(ActionEvent event) {

        System.out.println("foto_3");
        imagem = "br/ufms/desafio/view/css/desafio3.css";
        trocar_fundo(event);

    }
    
    @FXML
    private void trocar_fundo_foto_4(ActionEvent event) {

        imagem = "br/ufms/desafio/view/css/desafio4.css";
        trocar_fundo(event);

    }
    
    @FXML
    private void trocar_fundo_foto_5(ActionEvent event) {

        imagem = "br/ufms/desafio/view/css/desafio5.css";
        trocar_fundo(event);

    }

}
