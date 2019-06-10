package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Classe Main - é a classe main da aplicaçãp
 * @author Victor Thury Vieira Hauache &lt;vtvh@icomp.ufam.edu.br&gt;
 */
public class Main extends Application {
    /**
     * abre a janela principal do sistema
     * @param primaryStage primeira janela
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
        primaryStage.setTitle("TelaInicial");
        primaryStage.setScene(new Scene(root, 275, 325));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
