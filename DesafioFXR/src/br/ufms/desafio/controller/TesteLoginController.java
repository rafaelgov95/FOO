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

import br.ufms.desafio.model.bean.Usuario;
import br.ufms.desafio.model.dao.DAOFactory;
import br.ufms.desafio.model.dao.UsuarioDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Rafael Viana - Debian 8
 */
public class TesteLoginController extends TrocarCena implements Initializable {

    @FXML
    private Button btnEntrar;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnProcurar;
    @FXML
    private Button btnConfig;
    @FXML
    private Label msgErro;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField pfSenha;
    @FXML
    private Button btnTrocar;
    @FXML
    private StackPane fundo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btnHome.setOpacity(1);
        btnRegistrar.setOpacity(0.3);
        btnProcurar.setOpacity(0.3);
        btnConfig.setOpacity(0.3);

        Tooltip tooltip = new Tooltip();
        tooltip.setText("Ir para Home");

        btnHome.setTooltip(tooltip);
    }

    @FXML
    private void registrar(ActionEvent event) {
        trocarCena(event, "br/ufms/desafio/view/fxml/Registrar.fxml");
    }

    @FXML
    private void home(ActionEvent event) {
    }

    @FXML
    private void procurar(ActionEvent event) {
    }

    @FXML
    private void configuracoes(ActionEvent event) {
        trocarCena(event, "br/ufms/desafio/view/fxml/Configuracoes.fxml");
    }

    @FXML
    private void entrar(ActionEvent event) throws SQLException {

        UsuarioDAO alunoDao = DAOFactory.getInstance().getAlunoDAO();

        UsuarioDAO professorDao = DAOFactory.getInstance().getProfessorDAO();

        UsuarioDAO responsavelDao = DAOFactory.getInstance().getResponsavelDAO();

        UsuarioDAO escolaDao = DAOFactory.getInstance().getEscolaDAO();

        List<Usuario> listaDeLoginf = new ArrayList<Usuario>();
        
        listaDeLoginf.addAll(alunoDao.getAll());
        System.out.println("tamanho = " + listaDeLoginf.size());
        listaDeLoginf.addAll(professorDao.getAll());
        System.out.println("tamanho = " + listaDeLoginf.size());
        listaDeLoginf.addAll(escolaDao.getAll());
        System.out.println("tamanho = " + listaDeLoginf.size());
        listaDeLoginf.addAll(responsavelDao.getAll());
        System.out.println("tamanho = " + listaDeLoginf.size());

        for (int i = 0; i < listaDeLoginf.size(); i++) {

            if (tfEmail.getText().equals(listaDeLoginf.get(i).getUsuario())) {
                System.out.println(pfSenha.getText());
                if (pfSenha.getText().equals(listaDeLoginf.get(i).getSenha())) {

                    Buffer.user=listaDeLoginf.get(i);

                    trocarCena(event, "br/ufms/desafio/view/fxml/HomePrincipal.fxml");
                }
            }
        }

        if (tfEmail.getText().equals("") || pfSenha.getText().equals("")) {
            msgErro.setVisible(true);
            msgErro.setText("Complete os campos!");
        }

    }
}
