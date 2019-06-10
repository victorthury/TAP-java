package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;

/**
 * Classe Controller - Representa a primeira Tela do Sistema para Reserva de Salas
 * @author Victor Thury Vieira Hauache
 */

public class Controller {

// TelaInicial
    /** Botão que abre a tela para gerencia de usuários*/
    @FXML
    private Button buttonGerenciarUsuarios;
    /** Botão que abre a tela para gerencia de Salas*/
    @FXML
    private Button buttonGerenciarSalas;
    /** Botão que abre a tela para gerencia de Reservas*/
    @FXML
    private Button buttonReservaSalas;

    /**
     * Cria a tela de gerencia de Usuários
     * @param e
     * @throws IOException
     */
    public void irParaTelaDeGerenciarUsuarios(ActionEvent e) throws IOException {
        System.out.println("aprende a gerenciar");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaGerenciarUsuario.fxml"));

        ControllerTelaUsuario ctrlUsuarios = new ControllerTelaUsuario();
        loader.setController(ctrlUsuarios);

        Parent root = loader.load();

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Gerencia de Usuários");
        primaryStage.setScene(new Scene(root, 629, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Cria a tela de gerencia de Salas
     * @param e
     * @throws IOException
     */
    public void irParaTelaDeGerenciarSalas(ActionEvent e) throws IOException {
        System.out.println("aprende a ge");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaGerenciarSalas.fxml"));

        ControllerTelaUsuario ctrlSala = new ControllerTelaUsuario();

        Parent root = loader.load();

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Gerencia de Salas");
        primaryStage.setScene(new Scene(root, 629, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
        /*
        System.out.println("aprende a fazer salas");
        Parent root = FXMLLoader.load(getClass().getResource("TelaGerenciarSalas.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Gerencia de Salas");
        primaryStage.setScene(new Scene(root, 629, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
        */
    }

    /**
     * Cria a tela de gerencia de Reservas
     * @param e
     * @throws IOException
     */
    public void irParaTelaDeGerenciarReservas(ActionEvent e) throws IOException {
        System.out.println("aprende a gerenciar");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaVerOuGerenciarReservas.fxml"));

        ControllerTelaUsuario ctrlReservas = new ControllerTelaUsuario();

        Parent root = loader.load();

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Gerencia de Reservas");
        primaryStage.setScene(new Scene(root, 813, 440));
        primaryStage.setResizable(false);
        primaryStage.show();

    }




}
