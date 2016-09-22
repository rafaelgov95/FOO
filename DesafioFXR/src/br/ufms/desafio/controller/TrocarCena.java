/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.desafio.controller;

import static br.ufms.desafio.controller.Configuracoes.imagem;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author  Rafael Viana - Debian 8
 */
public class TrocarCena{

    public void trocarCena(ActionEvent event, String caminho) {
        try {

            FXMLLoader loader = new FXMLLoader();

            Parent root = (Parent) loader.load(getClass().getClassLoader().getResourceAsStream(
                    caminho));

            Scene scene = new Scene(root);

            Stage janelaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
           
           
            janelaAtual.setScene(scene);

            scene.getStylesheets().add(getClass().getClassLoader().getResource(
                    imagem).toExternalForm());

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
