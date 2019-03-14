package com.example.gestordeprojetos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class TabelaProjetos implements BaseColumns {
    public static final String NOME_TABELA = "tarefas";

    public static final String CAMPO_NOME = "nome";
    public static final String CAMPO_DATAINIT = "datainicial";
    public static final String CAMPO_DATAPREVISTA = "datalimite";
    public static final String CAMPO_DATAFINAL = "datafinal";
    public static final String CAMPO_ATRASADO = "atrasado";
    public static final String CAMPO_CONCLUIDO = "concluido";

    public static final String [] TODAS_COLUNAS = new String[] { _ID, CAMPO_NOME, CAMPO_DATAINIT, CAMPO_DATAPREVISTA,CAMPO_DATAFINAL,CAMPO_ATRASADO,CAMPO_CONCLUIDO };

    private SQLiteDatabase bd;

    public TabelaProjetos(SQLiteDatabase bd) {
        this.bd = bd;
    }

    public void cria() {
        bd.execSQL("CREATE TABLE " + NOME_TABELA + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                CAMPO_NOME + " TEXT NOT NULL," +
                CAMPO_DATAINIT + " DATE NOT NULL," +
                CAMPO_DATAPREVISTA+ " DATE NOT NULL," +
                CAMPO_DATAFINAL + " DATE," +
                CAMPO_ATRASADO + " BOOLEAN," +
                CAMPO_CONCLUIDO + " BOOLEAN" +
                ")");
    }

    /**
     * Insere um novo registo na tabela de apresentações
     * @param valores valores a inserir
     * @return o ID do registo inserido ou -1 se houver um erro
     */
    public long inserir(ContentValues valores) {
        return bd.insert(NOME_TABELA, null, valores);
    }

    /**
     * Altera um ou mais registos da tabela de oradores
     * @param valores valores a alterar
     * @param where Especifica quais os registos a alterar (ex: "_id=?")
     * @param whereArgs Argumentos a usar no comando where (substituem os ?)
     * @return o número de registos alterados
     */
    public int altera(ContentValues valores, String where, String[] whereArgs) {
        return bd.update(NOME_TABELA, valores, where, whereArgs);
    }

    /**
     * Elimina um ou mais registos da tabela de apresentações
     * @param where Especifica quais os registos a eliminar (ex: "_id=?")
     * @param whereArgs Argumentos a usar no comando where (substituem os ?)
     * @return o número de registos eliminados
     */
    public int elimina(String where, String[] whereArgs) {
        return bd.delete(NOME_TABELA, where, whereArgs);
    }

    /**
     * Devolve um conjunto de registos (Cursor) da tabela de apresentações
     * @param colunas colunas da tabela a devolver
     * @param where Especifica quais os registos a devolver (ex: "Nome LIKE '%?%'")
     * @param whereArgs Argumentos a usar no comando where (substituem os ?)
     * @param groupBy group by (SQL)
     * @param having having (SQL)
     * @param orderBy ordenação
     * @return Cursor para obter os registos
     */

    //TODO: CONSULTAR
    public Cursor consulta(String [] colunas, String where, String[] whereArgs, String groupBy, String having, String orderBy) {
        return bd.query(NOME_TABELA, colunas, where, whereArgs, groupBy, having, orderBy);
    }
}


