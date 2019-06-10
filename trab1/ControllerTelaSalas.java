package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * Classe ControllerTelaSalas - Representa a tela de gerência de Salas
 * @author Victor Thury Vieira Hauache &lt;vtvh@icomp.ufam.edu.br&gt;
 */

public class ControllerTelaSalas {
    /** Cada atributo referencia um determinado butão, tabela, textfield, label e dentro outras funcionalidades que aparecem na tela*/
    @FXML
    private TableView<Sala> tableSalas;
    private ObservableList<TableColumn> tableSalasColunas = FXCollections.observableArrayList(new ArrayList<>());
    public ObservableList<Sala> listaSalas = FXCollections.observableArrayList(new ArrayList<>());


    @FXML
    private Button buttonCriarSala;

    @FXML
    private Button buttonRemoverSala;

    @FXML
    private Button buttonAlterarSala;

    @FXML
    private Button buttonConfirmarSala;

    @FXML
    private VBox campoCadastroSala;


    @FXML
    private TextField textNomeSala;

    @FXML
    private TextField textFuncaoSala;

    @FXML
    private Label labelAviso;

    @FXML
    private TextField textIdSala;

    @FXML
    private Label labelSalaExiste;

    @FXML
    private VBox vboxRemocao;

    @FXML
    private TextField textRemoverId;

    @FXML
    private Button buttonConfirmaRemoção;

    @FXML
    private Label labelPreenchaRemocao;

    @FXML
    private Label labelIdRemocaoNaoExiste;

    @FXML
    private Button buttonAtualizarSalas;

    @FXML
    private VBox vboxAlteraSala;

    @FXML
    private TextField textAlterarId;

    @FXML
    private TextField textNomeAlterar;

    @FXML
    private TextField textFuncaoAlterar;

    @FXML
    private Button buttonConfirmaAlteracao;

    /**
     * Esse método confirma e cria e salva no BD os dados da sala
     * @param event
     */
    @FXML
    void handleButtonConfirmarSala(ActionEvent event) {
        try{
            Sala sala = new Sala(textIdSala.getText(),textNomeSala.getText(), textFuncaoSala.getText());
            SalaDAO salaDAO = new SalaDAO();
            boolean criouSala = salaDAO.adicionarSala(sala);
            if(criouSala==true) {
                textNomeSala.clear();
                textFuncaoSala.clear();
                campoCadastroSala.setVisible(false);
                labelAviso.setVisible(false);
            }
            else{
                labelAviso.setVisible(false);
                labelSalaExiste.setVisible(true);
            }
        }catch (NullPointerException e){
            labelAviso.setVisible(true);
        }
    }

    /**
     * Essa método torna visível apenas o campo de criar sala
     * @param event
     */
    @FXML
    void handleButtonCriarSala(ActionEvent event) {
        labelIdRemocaoNaoExiste.setVisible(false);
        labelPreenchaRemocao.setVisible(false);
        labelAviso.setVisible(false);
        vboxRemocao.setVisible(false);
        campoCadastroSala.setVisible(true);
        vboxAlteraSala.setVisible(false);
    }

    /**
     * Esse método torna apenas visível o campo de remoção de Sala
     * @param event
     */
    @FXML
    void handleButtonRemoverSala(ActionEvent event) {
        labelPreenchaRemocao.setVisible(false);
        labelIdRemocaoNaoExiste.setVisible(false);
        campoCadastroSala.setVisible(false);
        vboxRemocao.setVisible(true);
        vboxAlteraSala.setVisible(false);
    }

    /**
     * Esse método Apaga do BD a sala com o Id escrito no textfield
     * @param event
     */
    @FXML
    void handleButtonConfirmaRemocao(ActionEvent event) {
        try {
            SalaDAO salaDAO = new SalaDAO();
            boolean existe = salaDAO.removerSala(textRemoverId.getText());
            if (existe == true) {
                textRemoverId.clear();
                vboxRemocao.setVisible(false);
            }
            else{
                labelIdRemocaoNaoExiste.setVisible(true);
            }
        }
        catch (NullPointerException e){
            labelPreenchaRemocao.setVisible(true);
        }
    }

    /**
     * Esse método torna apenas visível o campo de alteração de Sala
     * @param event
     */
    @FXML
    void handleButtonAlterarSala(ActionEvent event) {
        vboxRemocao.setVisible(false);
        campoCadastroSala.setVisible(false);
        vboxAlteraSala.setVisible(true);
    }

    /**
     * Esse método altera do BD a sala com o Id escrito no textfield
     * @param event
     */
    @FXML
    void handleButtonConfirmaAlteracao(ActionEvent event) {
        SalaDAO salaDAO = new SalaDAO();
        boolean existe = salaDAO.alterarSala(textAlterarId.getText(), textNomeAlterar.getText(), textFuncaoAlterar.getText());
        if(existe == true){
            vboxAlteraSala.setVisible(false);
            textAlterarId.clear();
            textNomeAlterar.clear();
            textFuncaoAlterar.clear();

        }
        else{
            System.out.println("ID repetido");
        }
    }

    /**
     * Esse método mostra mostra e atualiza as informações da tabela conforme o que há no BD
     * @param event
     */
    @FXML
    void handleButtonAtualizarSalas(ActionEvent event) {
        SalaDAO salaDAO = new SalaDAO();
        listaSalas = salaDAO.listarSalas();
        tableSalasColunas.setAll(tableSalas.getColumns());
        tableSalas.setItems(listaSalas);
        tableSalasColunas.get(0).setCellValueFactory(new PropertyValueFactory<>("SalaId"));
        tableSalasColunas.get(1).setCellValueFactory(new PropertyValueFactory<>("Nome"));
        tableSalasColunas.get(2).setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        System.out.println("Tabela atualizada");
    }


}
