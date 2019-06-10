package sample;

/**
 * Classe Usuario - Representa um Usuário da Aplicação
 * @author Victor Thury Vieira Hauache &lt;vtvh@icomp.ufam.edu.br&gt;
 */

public class Usuario  {
    /** id do usuário*/
    private int usuarioId;
    /** nome do usuário*/
    private String nome;
    /**função do usuário */
    private String funcao;

    /**
     * Construtor da Classe
     * @param usuarioId String do id do usuário
     * @param nome  String do nome do usuário
     * @param funcao String da função do usuário
     * @throws NullPointerException caso o nome esteja vazio
     */
    Usuario(String usuarioId,String nome, String funcao) throws NullPointerException{
        if(nome.isEmpty() || funcao.isEmpty()  || usuarioId.isEmpty()){
            throw new NullPointerException("Campo vazio");
        }
        int usuarioIdInt = Integer.parseInt(usuarioId);
        setUsuarioId(usuarioIdInt);
        setNome(nome);
        setFuncao(funcao);

    }

    /**
     * getter do nome do usuário
     * @return String Nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * setter do nome do usuário
     * @param nome String nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * getter da função do usuário
     * @return String funcao
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * setter da funcao do usuário
     * @param funcao String funcao
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     * getter do id do usuário
     * @return int usuarioId
     */
    public int getUsuarioId() {
        return usuarioId;
    }

    /**
     * setter do id do usuário
     * @param usuarioId int usuarioId
     */
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
