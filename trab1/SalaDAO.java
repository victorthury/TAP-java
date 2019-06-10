package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

/**
 * Classe SalaDAO - Representa a conexão da aplicação com o BD
 * @author Victor Thury Vieira Hauache &lt;vtvh@icomp.ufam.edu.br&gt;
 */
public class SalaDAO extends BancoDeDados{
    /**
     * Serva pra dar inforamções para a tabela
     * @return uma lista de observaveis da classe Sala
     */
    public ObservableList<Sala> listarSalas(){
        try{
            ObservableList<Sala> listaSala = FXCollections.observableArrayList(new ArrayList<>());
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM salas");
            while (rs.next()){
                Sala sala = new Sala(String.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3));
                listaSala.add(sala);
            }
            return listaSala;
        }
        catch (SQLException E){
            return null;
        }
    }

    /**
     * adicionar uma sala ao bd
     * @param s objeto a ser adicionado
     * @return retorna booleano, true se foi acicionada, false se houve SQLexception
     */
    public boolean adicionarSala(Sala s) {
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO salas VALUES ("+ s.getSalaId()+", '"+ s.getNome()+"', '" + s.getTipo()+ "')");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * remove uma sala do bd
     * @param id id da sala a ser removida
     * @return boolean, true se foi removida, false se houve SQLException
     */
    public boolean removerSala(String id){
        if(id.isEmpty()){
            throw new NullPointerException("Nome vazio");
        }
        int idInt = Integer.parseInt(id);
        try{
            Statement st = conexao.createStatement();
            st.executeUpdate("DELETE FROM reserva WHERE salaid="+ id);
            st.executeUpdate("DELETE FROM salas WHERE salaid="+id);
            return true;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Altera as inforamações da sala no BD
     * @param id id para pesquisa
     * @param nomeSala nome a ser alterado se não estiver vazio
     * @param funcao função ser alterada se não estiver vazia
     * @return
     */
    public boolean alterarSala (String id, String nomeSala, String funcao){
        int idInt = Integer.parseInt(id);
        try{
            Statement st = conexao.createStatement();
            if(nomeSala.isEmpty() == false){
                st.executeUpdate("UPDATE salas SET nome='"+nomeSala+ "' WHERE salaid="+idInt);
            }
            if(funcao.isEmpty() == false){
                st.executeUpdate("UPDATE salas SET tipo='"+funcao+ "' WHERE salaid="+idInt);
            }
            return true;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }


}
