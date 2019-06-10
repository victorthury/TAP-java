package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

/**
 * Classe UsuarioDAO - Representa a conexão da aplicação com o BD
 * @author Victor Thury Vieira Hauache &lt;vtvh@icomp.ufam.edu.br&gt;
 */
public class UsuarioDAO extends BancoDeDados{
    /**
     * gera a lista que será exibida na tabela
     * @return lista observavel da classe Usuario
     */
    public ObservableList<Usuario> listarUsuarios(){
        try{
            ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList(new ArrayList<>());
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuario");
            while (rs.next()){
                Usuario user = new Usuario(String.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3));
                listaUsuarios.add(user);
            }
            return listaUsuarios;
        }
        catch (SQLException e){
            return null;
        }
    }

    /**
     * adiciona  objetos da classe Usuário no BD
     * @param u usuário a ser adicionado no BD
     * @return boolean, true se foi adicionado na tabela, false se houve SQLException
     */
    public boolean adicionarUsuario(Usuario u){
        try{
            Statement st = conexao.createStatement();

            st.executeUpdate("INSERT INTO usuario VALUES ("+ u.getUsuarioId()+", '" + u.getNome() + "'," + " '" + u.getFuncao() + "')");
            return true;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("nao cadastrou");
            return false;
        }
    }

    /**
     * remove determinado usuário do bd
     * @param id id do usuário a ser removido
     * @return boolean, true se foi removido, false se houve SQLException
     */
    public boolean removerUsuario(String id){
        if(id.isEmpty()){
            throw new NullPointerException("Nome vazio");
        }
        int usuarioId = Integer.parseInt(id);
        try{
            Statement st = conexao.createStatement();
            st.executeUpdate("DELETE from reserva where usuarioid="+usuarioId);
            st.executeUpdate("DELETE FROM usuario WHERE usuarioid="+usuarioId);
            return true;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * altera os dados do usuário
     * @param id id do usuário a ser alterado
     * @param nome atributo a ser alterado se estiver preenchido
     * @param funcao atributo a ser alterado se estiver preenchido
     * @return boolean, true se foi alterado, false se houve SQLException
     */
    public boolean alterarUsuario (String id, String nome, String funcao){
        int usuarioId = Integer.parseInt(id);
        try{
            Statement st = conexao.createStatement();
            if(nome.isEmpty() == false){
                st.executeUpdate("UPDATE usuario SET nome='"+nome+ "' WHERE usuarioid="+ usuarioId);
            }
            if(funcao.isEmpty() == false){
                st.executeUpdate("UPDATE usuario SET funcao='"+funcao+ "' WHERE usuarioid="+ usuarioId);
            }

            return true;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * verifica se usuário existe para alteração
     * @param id id a ser conferido
     * @return boolean, true se existe, false se não existe
     */
    public boolean existeUsuario(int id){
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE usuarioid="+id);

            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        }
        catch (SQLException e){
            return false;
        }
    }

}
