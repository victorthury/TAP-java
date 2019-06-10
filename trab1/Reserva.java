package sample;

/**
 * Classe Reserva - Representa o objeto Reserva
 * @author Victor Thury Vieira Hauache &lt;vtvh@icomp.ufam.edu.br&gt;
 */

public class Reserva {
    /** id de reserva*/
    private int reservaId;
    /** data de reserva*/
    private String data;
    /** hora de início*/
    private int inicio;
    /** hora de fim*/
    private int fim;
    /** id de sala*/
    private int salaId;
    /** id de usuário*/
    private int usuarioId;
    /** tema da reserva*/
    private String tema;


    /**
     * Construtor da Classe
     * @param reservaId
     * @param data
     * @param inicio
     * @param fim
     * @param usuarioId
     * @param salaId
     * @param tema
     */
    Reserva(String reservaId,String data, String inicio, String fim, String usuarioId, String salaId, String tema){
        if(usuarioId.isEmpty() || salaId.isEmpty() || tema.isEmpty() || data.isEmpty() || inicio.isEmpty() || fim.isEmpty()){
            throw new NullPointerException("Nome vazio");
        }
        int inicioInt = Integer.parseInt(inicio);
        int fimInt = Integer.parseInt(fim);
        int reservaIdInt = Integer.parseInt((reservaId));
        int usuarioIdInt = Integer.parseInt(usuarioId);
        int salaIdInt = Integer.parseInt(salaId);

        setReservaId(reservaIdInt);
        setUsuarioId(usuarioIdInt);
        setSalaId(salaIdInt);
        setTema(tema);
        setData(data);
        setInicio(inicioInt);
        setFim(fimInt);
    }

    /**
     * getter do tema
     * @return Tema reserva
     */
    public String getTema() {
        return tema;
    }

    /**
     * setter do tema
     * @param tema tema da resereva
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * getter da hora inicio da reserva
     * @return int de hora de inicio
     */
    public int getInicio() {
        return inicio;
    }

    /**
     * setter da hora de inicio
     * @param inicio
     */
    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    /**
     * getter da hora de Fim
     * @return hora de fim
     */
    public int getFim() {
        return fim;
    }

    /**
     * setter da hora de fim
     * @param fim hora de fim
     */
    public void setFim(int fim) {
        this.fim = fim;
    }

    /**
     * getter da data
     * @return data
     */
    public String getData() {
        return data;
    }

    /**
     * setter da data
     * @param data data da reserva
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * getter do ReservaId
     * @return reservaId
     */
    public int getReservaId() {
        return reservaId;
    }

    /**
     * setter do ReservaId
     * @param reservaId reservaId
     */
    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    /**
     * getter da salaId
     * @return salaId
     */
    public int getSalaId() {
        return salaId;
    }

    /**
     * setter da salaId
     * @param salaId salaId
     */
    public void setSalaId(int salaId) {
        this.salaId = salaId;
    }

    /**
     * getter do usuarioId
     * @return usuarioId
     */
    public int getUsuarioId() {
        return usuarioId;
    }

    /**
     * setter do usuarioId
     * @param usuarioId usuarioId
     */
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
