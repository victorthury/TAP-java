package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

/**
 * Classe ReservaDAO - Representa a conexão da aplicação com o BD
 * @author Victor Thury Vieira Hauache &lt;vtvh@icomp.ufam.edu.br&gt;
 */
public class ReservaDAO extends BancoDeDados{
    /**
     * Serve para a tabela ter coisas a serem mostradas
     * @return listaReserva, uma lista de observaveis que será usada na tabela
     */
    public ObservableList<Reserva> listarReserva(){
        try{
            ObservableList<Reserva> listaReserva= FXCollections.observableArrayList(new ArrayList<>());
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM reserva");
            while(rs.next()){
                Reserva reserva = new Reserva(String.valueOf(rs.getInt(1)), rs.getString(2),
                        String.valueOf(rs.getInt(3)), String.valueOf(rs.getInt(4)),
                        String.valueOf(rs.getInt(5)), String.valueOf(rs.getInt(6)),
                        rs.getString(7));
                listaReserva.add(reserva);
            }
            return listaReserva;
        }
        catch (SQLException E){
            return null;
        }
    }

    /**
     * Adiciona reserva ao BD
     * @param r um objeto da classe Reserva
     * @return um booleano, true se adicionou com sucesso, falso se houve um SQLException
     */
    public boolean adicionarReserva(Reserva r){
        try{
            Statement st = conexao.createStatement();
            st.executeUpdate("INSERT INTO reserva VALUES ("+ r.getReservaId()+", '" + r.getData() + "'," + " "
                    + r.getInicio() + ", " + r.getFim() + ", "+r.getUsuarioId()+", "+r.getSalaId()+", '" + r.getTema()+ "')");
            return true;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * /**
     * Remove reserva ao BD
     * @param reservaId Uma string do id da reserva
     * @return um booleano, true se adicionou com sucesso, falso se houve um SQLException
     */
    public boolean removerReserva(String reservaId){
        if(reservaId.isEmpty()){
            throw new NullPointerException("Nome vazio");
        }
        try{
            int reservaIdInt = Integer.parseInt(reservaId);
            Statement st = conexao.createStatement();
            st.executeUpdate("DELETE FROM reserva WHERE reservaid="+reservaIdInt);
            return true;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Uma função que pega todos os horários de determinada sala em determinado dia (serve pra checar conflito de horários)
     * @param data dia da reserva
     * @param idSala id da sala
     * @return lista de horarios (posição par é hora de inicio, posição ímpar é hora de fim)
     */
    public ArrayList<Integer> listaHorarios(String data, String idSala){
        int idSalaInt = Integer.parseInt(idSala);
        try {
            ArrayList<Integer> lista = new ArrayList<Integer>();
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM reserva where data='"+data+"' AND salaid="+idSalaInt);
            while (rs.next()){
                lista.add(rs.getInt(3));
                lista.add(rs.getInt(4));
            }
            return lista;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Serve pra retorna a lista que será exibida com reservas de determinada sala
     * @param salaId id da sla desejada
     * @return uma lista de reservas de uma sala
     */
    public ObservableList<Reserva> listarReservaPorSala(String salaId){
        try{
            int reservaIdInt = Integer.parseInt(salaId);
            ObservableList<Reserva> listaReserva= FXCollections.observableArrayList(new ArrayList<>());
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM reserva WHERE salaid="+salaId);
            while(rs.next()){
                Reserva reserva = new Reserva(String.valueOf(rs.getInt(1)), rs.getString(2),
                        String.valueOf(rs.getInt(3)), String.valueOf(rs.getInt(4)),
                        String.valueOf(rs.getInt(5)), String.valueOf(rs.getInt(6)),
                        rs.getString(7));
                listaReserva.add(reserva);
            }
            return listaReserva;
        }
        catch (SQLException E){
            return null;
        }
    }

    /**
     * Serve para retornar a lista que será exibida com reservas de determinado usuário
     * @param UsuarioId id de usuário
     * @return uma lista de reservas de determinado usuário
     */
    public ObservableList<Reserva> listarReservaPorUsuario(String UsuarioId){
        try{
            int reservaIdInt = Integer.parseInt(UsuarioId);
            ObservableList<Reserva> listaReserva= FXCollections.observableArrayList(new ArrayList<>());
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM reserva WHERE usuarioid="+reservaIdInt);
            while(rs.next()){
                Reserva reserva = new Reserva(String.valueOf(rs.getInt(1)), rs.getString(2),
                        String.valueOf(rs.getInt(3)), String.valueOf(rs.getInt(4)),
                        String.valueOf(rs.getInt(5)), String.valueOf(rs.getInt(6)),
                        rs.getString(7));
                listaReserva.add(reserva);
            }
            return listaReserva;
        }
        catch (SQLException E){
            return null;
        }
    }

}
