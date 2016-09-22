/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.desafio.controller;

import br.ufms.desafio.model.bean.Dependencia;
import br.ufms.desafio.model.bean.Endereco;
import br.ufms.desafio.model.bean.Municipio;
import br.ufms.desafio.model.bean.Responsavel;
import br.ufms.desafio.model.bean.Telefone;
import br.ufms.desafio.model.bean.enumerate.Deficiencia;
import br.ufms.desafio.model.bean.enumerate.TipoTelefone;
import br.ufms.desafio.model.dao.DAOFactory;
import br.ufms.desafio.model.dao.MunicipioDAO;
import br.ufms.desafio.model.dao.ResponsavelDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Rafael Viana - Debian 8
 */
public class RegistraResponsavelUpdate extends TrocarCena implements Initializable {

    @FXML
    private Button btnHome;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnProcurar;
    @FXML
    private Button btnConfig;
    @FXML
    private ScrollPane scroll;
    @FXML
    private TextField tfUsuario;
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField pfSenha;
    @FXML
    private PasswordField pfSenha2;
    @FXML
    private TextField tfDdd;
    @FXML
    private TextField tfTelefone;
    @FXML
    private CheckBox cbTelPrincipal;
    @FXML
    private ChoiceBox<?> cbTipoTelefone;
    @FXML
    private ChoiceBox<String> cbUF;
    @FXML
    private Button btnAdicionar;
    @FXML
    private ComboBox<String> cbTelefonesAdicionados;
    @FXML
    private Button btnDeletar;
    @FXML
    private TextField tfLogradouro;
    @FXML
    private TextField tfNumero;
    @FXML
    private TextField tfComplemento;
    @FXML
    private TextField tfCep;
    @FXML
    private TextField tfBairro;
    @FXML
    private ChoiceBox<Municipio> cbMunicipio;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnCriar;
    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfCpf;
    @FXML
    private DatePicker dpNascimento;
    @FXML
    private RadioButton rbNenhuma;
    @FXML
    private RadioButton rbFisica;
    @FXML
    private RadioButton rbMental;
    @FXML
    private RadioButton rbAuditiva;
    @FXML
    private RadioButton rbVisual;

    List<String> listaTelefones = new ArrayList<>();
    ObservableList<String> olTelefones = FXCollections.observableList(listaTelefones);

    List<Telefone> listaAuxTel = new ArrayList<>();

    List<Dependencia> listaAuxDependencia = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btnHome.setOpacity(0.3);
        btnRegistrar.setOpacity(1);
        btnProcurar.setOpacity(0.3);
        btnConfig.setOpacity(0.3);

        tfUsuario.setText(Buffer.user.getUsuario());
        tfNome.setText(Buffer.user.getNome());
        tfEmail.setText(Buffer.user.getEmail());
        tfLogradouro.setText(Buffer.user.getEndereco().getLogradouro());
        tfBairro.setText(Buffer.user.getEndereco().getLogradouro());
        tfCep.setText(Buffer.user.getEndereco().getCEP());
        tfComplemento.setText(Buffer.user.getEndereco().getComplemento());
    }

    @FXML
    private void deselecionar(ActionEvent event) {
        if (rbNenhuma.isSelected()) {
            rbAuditiva.setSelected(false);
            rbFisica.setSelected(false);
            rbMental.setSelected(false);
            rbVisual.setSelected(false);
        }
    }

    @FXML
    private void deselecionarNenhuma(ActionEvent event) {
        rbNenhuma.setSelected(false);
    }

    @FXML
    private void home(ActionEvent event) {
        trocarCena(event, "br/ufms/desafio/view/fxml/TesteLoginController.fxml");
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
        trocarCena(event, "br/ufms/desafio/view/fxml/Configuracoes.fxml");
    }

    @FXML
    private void criar(ActionEvent event) {
        try {
            Responsavel responsavel = new Responsavel();
            responsavel.setNome(tfNome.getText());
            responsavel.setUsuario(tfUsuario.getText());
            responsavel.setCPF(tfCpf.getText());
            responsavel.setEmail(tfEmail.getText());
            responsavel.setNascimento(dpNascimento.getValue());

            if (pfSenha.getText().equals(pfSenha2.getText())) {
                responsavel.setSenha(pfSenha.getText());
            } else {
                System.out.println("senhas diferentes");
            }

            // ENDEREÇO
            Endereco endereco = new Endereco();
            endereco.setLogradouro(tfLogradouro.getText());
            endereco.setBairro(tfBairro.getText());
            endereco.setCEP(tfCep.getText());
            endereco.setComplemento(tfComplemento.getText());
            if (tfNumero.getText().equals("")) {
                endereco.setSemNumero(true);
            } else {
                endereco.setNumero(Short.parseShort(tfNumero.getText()));
                endereco.setSemNumero(false);
            }

            endereco.setMunicipio(cbMunicipio.getValue());

            responsavel.setEndereco(endereco);

            responsavel.setTelefones(listaAuxTel);
            ResponsavelDAO responsaveldao = DAOFactory.getInstance().getResponsavelDAO();

            Set<Deficiencia> defic = new HashSet();

            if (rbAuditiva.isSelected()) {
                defic.add(Deficiencia.AUDITIVA);
            }

            if (rbFisica.isSelected()) {
                defic.add(Deficiencia.FISICA);
            }

            if (rbMental.isSelected()) {
                defic.add(Deficiencia.MENTAL);
            }

            if (rbVisual.isSelected()) {
                defic.add(Deficiencia.VISUAL);
            }

            if (!rbNenhuma.isSelected()) {
                responsavel.setDeficiencias(defic);
            }

            for (int i = 0; i < listaAuxDependencia.size(); i++) {
                System.out.println(listaAuxDependencia.get(i).getAluno().getNome());
                System.out.println(listaAuxDependencia.get(i).getParentescoResponsavel());
            }
            responsavel.setDependencias(listaAuxDependencia);
            responsaveldao.save(responsavel);
trocarCena(event, "br/ufms/desafio/view/fxml/HomePrincipal.fxml");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    @FXML
    private void adicionarTelefone(ActionEvent event) {
        if (tfDdd.getText().equals("") || tfTelefone.getText().equals("")
                || cbTipoTelefone.getValue() == null) {
            System.out.println("PRENCHA Os CAMPOS");

        } else {
            Telefone telefone = new Telefone();

            telefone.setDDD(tfDdd.getText());
            telefone.setNumero(tfTelefone.getText());

            if (cbTipoTelefone.getValue().equals("CELULAR")) {
                telefone.setTipo(TipoTelefone.CELULAR);
            } else if (cbTipoTelefone.getValue().equals("RESIDENCIAL")) {
                telefone.setTipo(TipoTelefone.RESIDENCIAL);
            } else if (cbTipoTelefone.getValue().equals("COMERCIAL")) {
                telefone.setTipo(TipoTelefone.COMERCIAL);
            } else if (cbTipoTelefone.getValue().equals("INSTITUCIONAL")) {
                telefone.setTipo(TipoTelefone.INSTITUCIONAL);
            } else if (cbTipoTelefone.getValue().equals("FAX_RESIDENCIAL")) {
                telefone.setTipo(TipoTelefone.FAX_RESIDENCIAL);
            } else if (cbTipoTelefone.getValue().equals("FAX_COMERCIAL")) {
                telefone.setTipo(TipoTelefone.FAX_COMERCIAL);
            } else if (cbTipoTelefone.getValue().equals("FAX_INSTITUCIONAL")) {
                telefone.setTipo(TipoTelefone.FAX_INSTITUCIONAL);
            }

            if (cbTelPrincipal.isSelected()) {
                telefone.setPrincipal(true);
            } else {
                telefone.setPrincipal(false);
            }

            listaAuxTel.add(telefone);
            olTelefones.add(telefone.toString());

            cbTelefonesAdicionados.setItems(olTelefones);
            cbTelefonesAdicionados.setValue(telefone.toString());

            //LIMPANDO OS DADOS
            tfDdd.setText("");
            tfTelefone.setText("");
            cbTelPrincipal.setSelected(false);
            cbTipoTelefone.setAccessibleText("");
        }
    }

    @FXML
    private void deletarTelefone(ActionEvent event) {
        String telefoneDeletar = (cbTelefonesAdicionados.getValue());
        for (int i = 0; i < listaAuxTel.size(); i++) {
            System.out.println("----------------");
            if (listaAuxTel.get(i).toString().equals(telefoneDeletar)) {
                olTelefones.remove(i);
                listaAuxTel.remove(i);
            }
        }
        cbTelefonesAdicionados.setItems(olTelefones);
    }

    @FXML
    private void Municipio(ActionEvent event) throws SQLException {

        if (cbUF.getValue().equals("AC")) {
        } else if (cbUF.getValue().equals("AL")) {
            Municipioconsulta("AL");
        } else if (cbUF.getValue().equals("AM")) {
            Municipioconsulta("AM");
        } else if (cbUF.getValue().equals("AP")) {
            Municipioconsulta("AP");
        } else if (cbUF.getValue().equals("BA")) {
            Municipioconsulta("BA");
        } else if (cbUF.getValue().equals("CE")) {
            Municipioconsulta("CE");
        } else if (cbUF.getValue().equals("DF")) {
            Municipioconsulta("DF");
        } else if (cbUF.getValue().equals("ES")) {
            Municipioconsulta("ES");
        } else if (cbUF.getValue().equals("GO")) {
            Municipioconsulta("GO");
        } else if (cbUF.getValue().equals("MA")) {
            Municipioconsulta("MA");
        } else if (cbUF.getValue().equals("MG")) {
            Municipioconsulta("MG");
        } else if (cbUF.getValue().equals("MS")) {
            Municipioconsulta("MS");
        } else if (cbUF.getValue().equals("MT")) {
            Municipioconsulta("MT");
        } else if (cbUF.getValue().equals("PA")) {
            Municipioconsulta("PA");
        } else if (cbUF.getValue().equals("PB")) {
            Municipioconsulta("PB");
        } else if (cbUF.getValue().equals("PE")) {
            Municipioconsulta("PE");
        } else if (cbUF.getValue().equals("PI")) {
            Municipioconsulta("PI");
        } else if (cbUF.getValue().equals("PR")) {
            Municipioconsulta("PR");
        } else if (cbUF.getValue().equals("RJ")) {
            Municipioconsulta("RJ");
        } else if (cbUF.getValue().equals("RN")) {
            Municipioconsulta("RN");
        } else if (cbUF.getValue().equals("RO")) {
            Municipioconsulta("RO");
        } else if (cbUF.getValue().equals("RR")) {
            Municipioconsulta("RR");
        } else if (cbUF.getValue().equals("RS")) {
            Municipioconsulta("RS");
        } else if (cbUF.getValue().equals("SC")) {
            Municipioconsulta("SC");
        } else if (cbUF.getValue().equals("SE")) {
            Municipioconsulta("SE");
        } else if (cbUF.getValue().equals("SP")) {
            Municipioconsulta("SP");
        } else if (cbUF.getValue().equals("TO")) {
            Municipioconsulta("TO");

        }

    }

    public void Municipioconsulta(String uf) throws SQLException {
        MunicipioDAO municipioDAO = DAOFactory.getInstance().getMunicipioDAO();

        List<Municipio> listaM = municipioDAO.getAllString(uf);
        ObservableList<Municipio> municipioColletion = FXCollections.observableList(listaM);
        for (int i = 0; i < listaM.size(); i++) {
//                System.out.println(listaM.get(i));
            municipioColletion.add(listaM.remove(i));
        }
        cbMunicipio.setItems(municipioColletion);
    }

}
