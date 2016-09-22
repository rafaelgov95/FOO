/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.desafio.controller;

import br.ufms.desafio.model.bean.Aluno;
import br.ufms.desafio.model.bean.Escola;
import br.ufms.desafio.model.bean.Professor;
import br.ufms.desafio.model.bean.Responsavel;
import br.ufms.desafio.model.dao.AlunoDAO;
import br.ufms.desafio.model.dao.DAOFactory;
import br.ufms.desafio.model.dao.EscolaDAO;
import br.ufms.desafio.model.dao.ProfessorDAO;
import br.ufms.desafio.model.dao.ResponsavelDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rafael Viana - Debian 8
 */
public class HomePrincipal extends TrocarCena implements Initializable {

    @FXML
    private Button btnHome;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnProcurar;
    @FXML
    private Button btnConfig;
    @FXML
    private PasswordField pfSenha;
    @FXML
    private Label msgErro;
    @FXML
    private Label llNomeUsuario;
    @FXML
    private Button btnExcluir;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String nomeDoUsuario = Buffer.user.getNome();

        llNomeUsuario.setText(nomeDoUsuario);

        btnHome.setOpacity(1);
        btnRegistrar.setOpacity(0.3);
        btnProcurar.setOpacity(0.3);
        btnConfig.setOpacity(0.3);

        Tooltip tooltip = new Tooltip();
        tooltip.setText("Ir para Home");

        btnHome.setTooltip(tooltip);

    }

    @FXML
    private void home(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();

            Parent root = (Parent) loader.load(getClass().getClassLoader().getResourceAsStream(
                    "br/ufms/desafio/view/fxml/TesteLogin.fxml"));

            Scene scene = new Scene(root);

            Stage janelaAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            janelaAtual.setScene(scene);
            scene.getStylesheets().add(getClass().getClassLoader().getResource(
                    "br/ufms/desafio/view/css/desafio.css").toExternalForm());

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    private void registrar(ActionEvent event) {

    }

    @FXML
    private void procurar(ActionEvent event) {
    }

    @FXML
    private void excluirConta(ActionEvent event) throws SQLException {
        if (Buffer.user instanceof Aluno) {
            AlunoDAO alunoDao = DAOFactory.getInstance().getAlunoDAO();
            alunoDao.delete(Buffer.user.getCodigo());
            System.out.println("Exclui Aluno ");
            trocarCena(event, "br/ufms/desafio/view/fxml/TesteLogin.fxml");
        } else if (Buffer.user instanceof Escola) {
            EscolaDAO escolaDAO = DAOFactory.getInstance().getEscolaDAO();
            escolaDAO.delete(Buffer.user.getCodigo());
            System.out.println("Exclui ESCOLA ");
            trocarCena(event, "br/ufms/desafio/view/fxml/TesteLogin.fxml");
        }else  if (Buffer.user instanceof Professor) {
            ProfessorDAO ProfessorDAO = DAOFactory.getInstance().getProfessorDAO();
            ProfessorDAO.delete(Buffer.user.getCodigo());
            System.out.println("Exclui Professor ");
            trocarCena(event, "br/ufms/desafio/view/fxml/TesteLogin.fxml");
        }else  if (Buffer.user instanceof Responsavel) {
            ResponsavelDAO responsavelDAO = DAOFactory.getInstance().getResponsavelDAO();
            responsavelDAO.delete(Buffer.user.getCodigo());
            System.out.println("Exclui Responsavel ");
            trocarCena(event, "br/ufms/desafio/view/fxml/TesteLogin.fxml");
        }
    }

    @FXML
    private void configuracoes(ActionEvent event) {
    }

    @FXML
    private void update(ActionEvent event) {
         if (Buffer.user instanceof Aluno) {

            trocarCena(event, "br/ufms/desafio/view/fxml/RegistraAlunoUpdate.fxml");
        } else if (Buffer.user instanceof Escola) {
   
            trocarCena(event, "br/ufms/desafio/view/fxml/RegistraEscolaUpdate.fxml");
        }else  if (Buffer.user instanceof Professor) {

            trocarCena(event, "br/ufms/desafio/view/fxml/RegistraProfessorUpdate.fxml");
        }else  if (Buffer.user instanceof Responsavel) {

            trocarCena(event, "br/ufms/desafio/view/fxml/RegistraResponsavelUpdate.fxml");
        }

    }

}
