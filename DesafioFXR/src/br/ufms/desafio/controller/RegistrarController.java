/*
 * Copyright (C) 2016 Higor
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.ufms.desafio.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

/**
 * FXML Controller class
 *
 * @author  Rafael Viana - Debian 8
 */
public class RegistrarController extends TrocarCena implements Initializable {

    @FXML
    private Button btnHome;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnProcurar;
    @FXML
    private Button btnConfig;
    @FXML
    private Button btnProximo;
    @FXML
    private ChoiceBox choiceBox;
    @FXML
    private Button btnProximo1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("REGISTRAR CONTROLLER");

        // TODO
        btnHome.setOpacity(0.3);
        btnRegistrar.setOpacity(1);
        btnProcurar.setOpacity(0.3);
        btnConfig.setOpacity(0.3);
    }

    @FXML
    private void home(ActionEvent event) {
        trocarCena(event, "br/ufms/desafio/view/fxml/TesteLogin.fxml");
    }

    @FXML
    private void registrar(ActionEvent event) {
    }

    @FXML
    private void procurar(ActionEvent event) {
    }

    @FXML
    private void configuracoes(ActionEvent event) {
        trocarCena(event, "br/ufms/desafio/view/fxml/Configuracoes.fxml");
    }

    @FXML
    private void proximo(ActionEvent event) {
        System.out.println(choiceBox.getValue().toString());
        switch (choiceBox.getValue().toString()) {
            case "Aluno":
                trocarCena(event, "br/ufms/desafio/view/fxml/RegistraAluno.fxml");
                break;
            case "Professor":
                System.out.println("professor");
                trocarCena(event, "br/ufms/desafio/view/fxml/RegistraProfessor.fxml");
                break;
            case "Responsável":
                trocarCena(event, "br/ufms/desafio/view/fxml/RegistraResponsavel.fxml");
                break;
            case "Escola":
                trocarCena(event, "br/ufms/desafio/view/fxml/RegistraEscola.fxml");
                break;
            default:
                break;
        }

    }
}
