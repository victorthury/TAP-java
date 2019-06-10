package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * Classe ControllerTelaReservas -  Representa a tela de gerencia de Reservas na aplicação
 * @author Victor Thury Vieira Hauache &lt;vtvh@icomp.ufam.edu.br&gt;
 */

public class ControllerTelaReservas {
    /** Cada atributo referencia um determinado butão, tabela, textfield, label e dentro outras funcionalidades que aparecem na tela*/
    @FXML
    private Button buttonCriarReserva;

    @FXML
    private Button buttonApagarReserva;

    @FXML
    private VBox campoCriarReserva;

    @FXML
    private TextField textReservaId;

    @FXML
    private TextField textData;

    @FXML
    private TextField textHoraInicio;

    @FXML
    private TextField textHoraFim;

    @FXML
    private TextField textIdSala;

    @FXML
    private TextField textIdUsuario;

    @FXML
    private TextField textTema;

    @FXML
    private Button buttonConfirmaReserva;

    @FXML
    private Label labelOcupado;

    @FXML
    private Label labelAlerta;
    @FXML
    private TableView<Reserva> tabelaReservas;
    private ObservableList<TableColumn> tableReservaColunas = FXCollections.observableArrayList(new ArrayList<>());
    public ObservableList<Reserva> listaReserva = FXCollections.observableArrayList(new ArrayList<>());


    @FXML
    private Label labelReservaCriada;

    @FXML
    private Button buttonTodasAsReservas;

    @FXML
    private Button buttonReservasPorSala;

    @FXML
    private Button buttonReservasPorUsuario;

    @FXML
    private VBox vboxApagarReserva;

    @FXML
    private TextField textIdApagar;

    @FXML
    private Button buttonConfirmaApagarReserva;

    @FXML
    private HBox hboxPesquisaSala;

    @FXML
    private TextField textProcuraSala;

    @FXML
    private Button buttonConfirmaPesquisaSala;

    @FXML
    private HBox hboxPesquisaPorUsuario;

    @FXML
    private TextField textPesquisaIdUsuario;

    @FXML
    private Button buttonConfirmaPesquisaUsuario;

    /**
     * Torna visível o campo de Pesquisa por Reserva de salas e torna invisível o campo de Pesquisa por Usuário
     * @param event
     */
    @FXML
    void handleButtonReservasPorSala(ActionEvent event) {
        hboxPesquisaSala.setVisible(true);
        hboxPesquisaPorUsuario.setVisible(false);
    }

    /**
     * Torna visível o campo de Pesquisa por Usuário e torna torna o campo de Pesquisa pro Sala Invisível
     * @param event
     */
    @FXML
    void handleButtonReservasPorUsuario(ActionEvent event) {
        hboxPesquisaSala.setVisible(false);
        hboxPesquisaPorUsuario.setVisible(true);
    }


    /**
     * Mostra na tabela todas as reservas que estão salvas no BD
     * @param event
     */
    @FXML
    void handleButtonTodasAsReservas(ActionEvent event) {
        ReservaDAO reservaDAO = new ReservaDAO();
        listaReserva = reservaDAO.listarReserva();
        tableReservaColunas.setAll(tabelaReservas.getColumns());
        tabelaReservas.setItems(listaReserva);
        tableReservaColunas.get(0).setCellValueFactory(new PropertyValueFactory<>("ReservaId"));
        tableReservaColunas.get(1).setCellValueFactory(new PropertyValueFactory<>("Data"));
        tableReservaColunas.get(2).setCellValueFactory(new PropertyValueFactory<>("Inicio"));
        tableReservaColunas.get(3).setCellValueFactory(new PropertyValueFactory<>("Fim"));
        tableReservaColunas.get(4).setCellValueFactory(new PropertyValueFactory<>("Tema"));
        tableReservaColunas.get(5).setCellValueFactory(new PropertyValueFactory<>("SalaId"));
        tableReservaColunas.get(6).setCellValueFactory(new PropertyValueFactory<>("UsuarioId"));

    }

    /**
     * mostra todas as reserva de uma sala em específico que estão salvas no BD
     * @param event
     */
    @FXML
    void handleConfirmaPesquisaSala(ActionEvent event) {
        ReservaDAO reservaDAO = new ReservaDAO();
        listaReserva = reservaDAO.listarReservaPorSala(textProcuraSala.getText());
        tableReservaColunas.setAll(tabelaReservas.getColumns());
        tabelaReservas.setItems(listaReserva);
        tableReservaColunas.get(0).setCellValueFactory(new PropertyValueFactory<>("ReservaId"));
        tableReservaColunas.get(1).setCellValueFactory(new PropertyValueFactory<>("Data"));
        tableReservaColunas.get(2).setCellValueFactory(new PropertyValueFactory<>("Inicio"));
        tableReservaColunas.get(3).setCellValueFactory(new PropertyValueFactory<>("Fim"));
        tableReservaColunas.get(4).setCellValueFactory(new PropertyValueFactory<>("Tema"));
        tableReservaColunas.get(5).setCellValueFactory(new PropertyValueFactory<>("SalaId"));
        tableReservaColunas.get(6).setCellValueFactory(new PropertyValueFactory<>("UsuarioId"));
        hboxPesquisaSala.setVisible(false);
        textProcuraSala.clear();
    }

    /**
     * Mostra todas a reservas de um usuário epecífico que está salvo no BD
     * @param event
     */
    @FXML
    void handleButtonConfirmaPesquisaUsuario(ActionEvent event) {
        ReservaDAO reservaDAO = new ReservaDAO();
        listaReserva = reservaDAO.listarReservaPorUsuario(textPesquisaIdUsuario.getText());
        tableReservaColunas.setAll(tabelaReservas.getColumns());
        tabelaReservas.setItems(listaReserva);
        tableReservaColunas.get(0).setCellValueFactory(new PropertyValueFactory<>("ReservaId"));
        tableReservaColunas.get(1).setCellValueFactory(new PropertyValueFactory<>("Data"));
        tableReservaColunas.get(2).setCellValueFactory(new PropertyValueFactory<>("Inicio"));
        tableReservaColunas.get(3).setCellValueFactory(new PropertyValueFactory<>("Fim"));
        tableReservaColunas.get(4).setCellValueFactory(new PropertyValueFactory<>("Tema"));
        tableReservaColunas.get(5).setCellValueFactory(new PropertyValueFactory<>("SalaId"));
        tableReservaColunas.get(6).setCellValueFactory(new PropertyValueFactory<>("UsuarioId"));
        hboxPesquisaPorUsuario.setVisible(false);
        textPesquisaIdUsuario.clear();
    }

    /**
     * Torna visível o campo de apagar reservas
     * @param event
     */
    @FXML
    void handleButtonApagarReserva(ActionEvent event) {
        campoCriarReserva.setVisible(false);
        labelReservaCriada.setVisible(false);
        vboxApagarReserva.setVisible(true);
    }

    /**
     * Apaga uma reserva conforme o Id da reserva
     * @param event
     */
    @FXML
    void handleConfirmaButtonApagarReserva(ActionEvent event) {
        try {
            ReservaDAO reservaDAO = new ReservaDAO();
            String id = textIdApagar.getText();
            boolean existe = reservaDAO.removerReserva(id);
            if(existe == true){
                vboxApagarReserva.setVisible(false);

            }
            textIdApagar.clear();
        }
        catch (NullPointerException e){

        }
    }

    /**
     * Torna visível o campo de Criar Reserva
     * @param event
     */
    @FXML
    void handleButtonCriarReserva(ActionEvent event) {
        vboxApagarReserva.setVisible(false);
        campoCriarReserva.setVisible(true);
        labelReservaCriada.setVisible(false);
    }

    /**
     * Cria uma reserva somente se for um horário disponível e possível, e salva no banco de dados
     * @param event
     */
    @FXML
    void handleButtonConfirmaReserva(ActionEvent event) {
        try {
            ReservaDAO reservaDAO = new ReservaDAO();
            ArrayList<Integer> listaDeHorarios = reservaDAO.listaHorarios(textData.getText(), textIdSala.getText());
            boolean desocupado = true;
            boolean horarioPossivel = true;
            boolean existe;
            int inicio = Integer.parseInt(textHoraInicio.getText());
            int fim = Integer.parseInt(textHoraFim.getText());
            if(fim - inicio <=0) {
                horarioPossivel = false;
            }
            for(int i = 0; i<listaDeHorarios.size(); i+=2){
                if((inicio>=listaDeHorarios.get(i) && inicio<listaDeHorarios.get(i+1)) ||
                        fim>listaDeHorarios.get(i) && fim<=listaDeHorarios.get(i+1)){
                    desocupado = false;
                }
                if((listaDeHorarios.get(i)>=inicio && listaDeHorarios.get(i)<fim)||
                        (listaDeHorarios.get(i+1)>inicio && listaDeHorarios.get(i+1) <= fim)){
                    desocupado = false;
                }
            }
            if(horarioPossivel && desocupado) {
                Reserva reserva = new Reserva(textReservaId.getText(), textData.getText(),
                        textHoraInicio.getText(), textHoraFim.getText(),
                        textIdSala.getText(), textIdUsuario.getText(), textTema.getText());
                existe = reservaDAO.adicionarReserva(reserva);
                if (existe) {
                    textReservaId.clear();
                    textData.clear();
                    textHoraInicio.clear();
                    textHoraFim.clear();
                    textIdSala.clear();
                    textIdUsuario.clear();
                    textTema.clear();
                    campoCriarReserva.setVisible(false);
                    labelReservaCriada.setVisible(true);
                    labelOcupado.setVisible(false);
                    labelAlerta.setVisible(false);
                }
            }
            else{
                labelOcupado.setVisible(true);
            }
        }catch (NullPointerException e){
            labelAlerta.setVisible(true);
        }

    }



}
