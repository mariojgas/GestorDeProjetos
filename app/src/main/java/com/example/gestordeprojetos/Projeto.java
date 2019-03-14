package com.example.gestordeprojetos;

import android.database.Cursor;

import java.sql.Date;


public class Projeto {

    private long id;
    private String nome;
    private Date dataInicial;
    private Date dataConclusao;
    private Date dataPrevista;
    private Boolean concluido;
    private Boolean atrasado;


    public Projeto(Cursor cursor){
        int posColId = cursor.getColumnIndex(TabelaProjetos._ID);
        int posColNome = cursor.getColumnIndex(TabelaProjetos.CAMPO_NOME);
        int posColDataIni = cursor.getColumnIndex(TabelaProjetos.CAMPO_DATAINIT);
        int posColDataPrev = cursor.getColumnIndex(TabelaProjetos.CAMPO_DATAPREVISTA);
        int posColDataF = cursor.getColumnIndex(TabelaProjetos.CAMPO_DATAFINAL);
        int posColConc = cursor.getColumnIndex(TabelaProjetos.CAMPO_CONCLUIDO);

        id = cursor.getLong(posColId);
        nome = cursor.getString(posColNome);
        dataInicial = new Date(cursor.getLong(posColDataIni));
        dataPrevista = new Date(cursor.getLong(posColDataPrev));
        dataConclusao = new Date(cursor.getLong(posColDataF));
        concluido = (cursor.getInt(posColConc) == 1);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataInicial) {
        this.dataPrevista = dataPrevista;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }

    public Boolean getAtrasado() {
        return atrasado;
    }

    public void setAtrasado(Boolean atrasado) {
        this.atrasado = atrasado;
    }


}
