package com.example.gestordeprojetos;

import java.sql.Date;

public class Tarefa {

    private long id;
    private long idProjeto;
    private String nome;
    private Date dataInicial;
    private Date dataConclusao;
    private Boolean concluido;
    private Boolean atrasado;
}
