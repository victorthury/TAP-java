package sample;

import java.sql.*;

/**
 * Classe BancoDeDados -  Representa o Bnaco de Dados (classe mostrada em sala)
 * @author Horácio Fernandes  &lt;horacio.fernandes@gmail.com&gt;
 */

public class BancoDeDados {
    private static String url = "jdbc:mysql://localhost:3306/reservasalasbd";
    private static String user = "reservasalas_admin";
    private static String pass = "admin";
    protected static Connection conexao = null;

    public BancoDeDados() {
        if (conexao == null){
            conecta();
        }
    }
    private static boolean conecta() {
        try {
            conexao = DriverManager.getConnection(url, user, pass);
            System.out.println("conectou");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("nao conectou");
            return false;
        }
    }

    public static boolean desconecta() {
        try {
            conexao.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
