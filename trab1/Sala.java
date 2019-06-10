package sample;

import java.util.*;

/**
 * Classe Sala - Representa uma Sala da aplicação
 * @author Victor Thury Vieira Hauache &lt;vtvh@icomp.ufam.edu.br&gt;
 */

public class Sala {
    /** id de sala*/
    private int salaId;
    /** nome da sala*/
    private String nome;
    /** tipo da sala*/
    private String tipo;

    /**
     * Contrutor da classe
     * @param id id da sala
     * @param nome nome da sala
     * @param tipo tipo da sala
     */
    Sala(String id,String nome, String tipo){
        if(id.isEmpty()||nome.isEmpty() || tipo.isEmpty()){
            throw new NullPointerException("Nome vazio");
        }
        int idInt = Integer.parseInt(id);
        setSalaId(idInt);
        setNome(nome);
        setTipo(tipo);
    }

    /**
     * getter do nome da sala
     * @return String nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * setter do nome da sala
     * @param nome String da Sala
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * getter do tipo da sala
     * @return String do tipo da sala
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * setter do tipo da sala
     * @param tipo String tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * getter do id da sala
     * @return int salaId
     */
    public int getSalaId() {
        return salaId;
    }

    /**
     * setter do id da sala
     * @param salaId int do id da sala
     */
    public void setSalaId(int salaId) {
        this.salaId = salaId;
    }
}
