package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe ControllerTelaUsuario - Representa a tela de gerência de Usuários
 * @author Victor Thury Vieira Hauache &lt;vtvh@icomp.ufam.edu.br&gt;
 */

public class ControllerTelaUsuario {

    /** Cada atributo referencia um determinado butão, tabela, textfield, label e dentro outras funcionalidades que aparecem na tela*/

    @FXML
    private TableView<Usuario> tableUsuarios;
    private ObservableList<TableColumn> tableUsuariosColunas = FXCollections.observableArrayList(new ArrayList<>());
    public ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList(new ArrayList<>());

    @FXML
    private Button buttonCriarUsuario;

    @FXML
    private Button buttonRemoverUsuario;

    @FXML
    private Button buttonAlterarUsuario;

    @FXML
    private VBox campoCadastrarUsuario;

    @FXML
    private Button buttonConfirmarCadastro;

    @FXML
    private TextField textUsuarioId;

    @FXML
    private TextField textNomeUsuario;

    @FXML
    private TextField textFuncaoUsuario;


    @FXML
    private Label textCampoAviso;

    @FXML
    private Label labelAlertaExiste;

    @FXML
    private Button buttonConfirmaRemocao;

    @FXML
    private VBox vboxRemover;

    @FXML
    private Label labelRemover;

    @FXML
    private TextField textUsuarioRemover;


    @FXML
    private Label labelUsuarioNaoExiste;

    @FXML
    private Label labelUsuarioApagado;

    @FXML
    private Label labelCamposRemover;

    @FXML
    private VBox vboxAlterarUsuario;

    @FXML
    private Label labelAlterarUsuario;

    @FXML
    private TextField textIdAlteracao;

    @FXML
    private TextField textNomeAlteracao;

    @FXML
    private TextField textFuncaoAltercao;

    @FXML
    private Button buttonConfirmaAlteracao;

    @FXML
    private Label labelAlterarNaoExiste;

    @FXML
    private Label labelUsuarioCriado;

    @FXML
    private Label labelUsuarioAlterado;

    @FXML
    private Button buttonAtualizaTabela;

    /**
     * deixa apenas o campo de cadastro de usuários visível
     * @param event
     */
    @FXML
    void handleButtonCriarUsuario(ActionEvent event) {
        labelCamposRemover.setVisible(false);
        labelUsuarioAlterado.setVisible(false);
        labelUsuarioCriado.setVisible(false);
        vboxAlterarUsuario.setVisible(false);
        vboxRemover.setVisible(false);
        labelUsuarioNaoExiste.setVisible(false);
        labelUsuarioApagado.setVisible(false);
        campoCadastrarUsuario.setVisible(true);
    }

    /**
     * adiciona ao DB novos Usuários
     * @param event
     * @throws SQLException
     */
    @FXML
    void handleButtonConfirmarCadastro(ActionEvent event) throws SQLException {
        //System.out.println(funcao.getSelectedToggle().getUserData());
        try {
            Usuario user = new Usuario(textUsuarioId.getText(), textNomeUsuario.getText(), textFuncaoUsuario.getText());
            System.out.println("usuario inserido");
            UsuarioDAO userDAO = new UsuarioDAO();
            System.out.println("dao criado");
            boolean criou = userDAO.adicionarUsuario(user);
            if (criou == true) {
                textNomeUsuario.clear();
                textFuncaoUsuario.clear();
                textUsuarioId.clear();
                campoCadastrarUsuario.setVisible(false);
                textCampoAviso.setVisible(false);
                labelAlertaExiste.setVisible(false);
                labelUsuarioCriado.setVisible(true);
            } else {
                textCampoAviso.setVisible(false);
                labelAlertaExiste.setVisible(true);
            }
        } catch (NullPointerException e) {
            labelAlertaExiste.setVisible(false);
            textCampoAviso.setVisible(true);
        }


    }

    /**
     * Deixa visível apenas o campo de Remoção
     * @param event
     */
    @FXML
    void handleButtonRemoverUsuario(ActionEvent event) {
        labelCamposRemover.setVisible(false);
        labelUsuarioAlterado.setVisible(false);
        labelUsuarioCriado.setVisible(false);
        labelUsuarioApagado.setVisible(false);
        campoCadastrarUsuario.setVisible(false);
        vboxAlterarUsuario.setVisible(false);
        vboxRemover.setVisible(true);
    }

    /**
     * Remove um Usuário do DB
     * @param event
     */
    @FXML
    void handleButtonConfirmaRemocao(ActionEvent event) {
        try {
            String id = textUsuarioRemover.getText();
            UsuarioDAO userDao = new UsuarioDAO();
            boolean existe = userDao.removerUsuario(id);
            if(existe == true){
                userDao.removerUsuario(id);
                vboxRemover.setVisible(false);
                labelUsuarioApagado.setVisible(true);
                labelUsuarioNaoExiste.setVisible(false);
                labelCamposRemover.setVisible(false);
                textUsuarioRemover.clear();
            }
            else{
                labelUsuarioNaoExiste.setVisible(true);
                textUsuarioRemover.clear();
            }
        }
        catch (NullPointerException e){
            labelCamposRemover.setVisible(true);
        }
    }

    /**
     * Deixa visível apenas o campo de alterção do usuário
     * @param event
     */
    @FXML
    void handleButtonAlterarUsuario(ActionEvent event) {
        labelCamposRemover.setVisible(false);
        vboxRemover.setVisible(false);
        labelUsuarioAlterado.setVisible(false);
        labelUsuarioNaoExiste.setVisible(false);
        labelUsuarioApagado.setVisible(false);
        vboxAlterarUsuario.setVisible(true);
        labelUsuarioCriado.setVisible(false);
    }

    /**
     * Altera os dados usuário no DB
     * @param event
     */
    @FXML
    void handeButtonConfirmaAlteracao(ActionEvent event) {
        UsuarioDAO userDAO = new UsuarioDAO();
        int idInt = Integer.parseInt(textIdAlteracao.getText());
        boolean existe = userDAO.existeUsuario(idInt);
        if(existe == true){
            userDAO.alterarUsuario(textIdAlteracao.getText(), textNomeAlteracao.getText(), textFuncaoAltercao.getText());
            textIdAlteracao.clear();
            textNomeAlteracao.clear();
            textFuncaoAltercao.clear();
            labelAlterarNaoExiste.setVisible(false);
            vboxAlterarUsuario.setVisible(false);
            labelUsuarioAlterado.setVisible(true);
        }
        else{
            labelAlterarNaoExiste.setVisible(true);
        }

    }

    /**
     * Mostra e atualiza a tabela conforme o que há no DB
     * @param event
     */
    @FXML
    void handleButtonAtualizaTabela(ActionEvent event) {
        UsuarioDAO userDAO = new UsuarioDAO();
        listaUsuarios = userDAO.listarUsuarios();
        tableUsuariosColunas.setAll(tableUsuarios.getColumns());
        tableUsuarios.setItems(listaUsuarios);
        tableUsuariosColunas.get(0).setCellValueFactory(new PropertyValueFactory<>("UsuarioId"));
        tableUsuariosColunas.get(1).setCellValueFactory(new PropertyValueFactory<>("Nome"));
        tableUsuariosColunas.get(2).setCellValueFactory(new PropertyValueFactory<>("Funcao"));

    }

}
