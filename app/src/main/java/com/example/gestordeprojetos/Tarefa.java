package com.example.gestordeprojetos;

import android.content.ContentValues;
import android.database.Cursor;

import java.sql.Date;

public class Tarefa {

    private long id;
    private long idProjeto;
    private String nome;
    private Date dataInicial;
    private Date dataPrevista;
    private Date dataConclusao;
    private Boolean concluido;
    private Boolean atrasado;

    public Tarefa(Cursor cursor){
        int posColId = cursor.getColumnIndex(TabelaTarefas._ID);
        int posColNome = cursor.getColumnIndex(TabelaTarefas.CAMPO_NOME);
        int posColIdProjeto = cursor.getColumnIndex(TabelaTarefas.CAMPO_PROJETO);
        int posColDataIni = cursor.getColumnIndex(TabelaTarefas.CAMPO_DATAINIT);
        int posColDataPrev = cursor.getColumnIndex(TabelaTarefas.CAMPO_DATAPREVISTA);
        int posColDataF = cursor.getColumnIndex(TabelaTarefas.CAMPO_DATAFINAL);
        int posColConc = cursor.getColumnIndex(TabelaTarefas.CAMPO_CONCLUIDO);

        id = cursor.getLong(posColId);
        nome = cursor.getString(posColNome);
        idProjeto = cursor.getLong(posColIdProjeto);
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

    public long getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(long idProjeto) {
        this.idProjeto = idProjeto;
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

    public void setDataPrevista(Date dataPrevista) {
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

    public ContentValues getContentValues() {
        ContentValues valores = new ContentValues();



        valores.put(TabelaTarefas.CAMPO_NOME, nome);
        valores.put(TabelaTarefas.CAMPO_PROJETO, idProjeto);
        valores.put(TabelaTarefas.CAMPO_DATAPREVISTA, dataPrevista.getTime());
        valores.put(TabelaTarefas.CAMPO_CONCLUIDO, concluido);

        return valores;
    }

}
