package com.example.gestordeprojetos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BdProjetosOpenHelper extends SQLiteOpenHelper {

    private boolean TestSeed =false;
    public static final String NOME_BASE_DADOS = "projetos.db";
    public static final int VERSAO = 1;

    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use for locating paths to the the database
     */
    public BdProjetosOpenHelper(Context context) {
        super(context, NOME_BASE_DADOS, null, VERSAO);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        new TabelaProjetos(db).cria();
        new TabelaTarefas(db).cria();
//TODO SEED para testes
        if (TestSeed) {
            seed(db);
        }
    }

    private void seed(SQLiteDatabase db) {
        TabelaProjetos tabelaProjetos = new TabelaProjetos(db);
        TabelaTarefas tabelaTarefas = new TabelaTarefas(db);

        Date d = (Date) Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
        dateFormat.format(d);
        Projeto projeto = new Projeto();
        projeto.setNome("Teste");
        projeto.setDataInicial(d);
        /*long id = tabelaOradores.inserir(orador.getContentValues());
        orador.setId(id);

        Apresentacao apresentacao = new Apresentacao();
        apresentacao.setIdOrador(orador.getId());
        apresentacao.setTitulo("Xamarim cross-platform for mobile");
        apresentacao.setSumario("Xamarim para iOS e Android");
        tabelaApresentacoes.inserir(apresentacao.getContentValues());

        orador = new Orador();
        orador.setTitulo("Eng.");
        orador.setNome("Bruna Silva");
        id = tabelaOradores.inserir(orador.getContentValues());
        orador.setId(id);

        apresentacao = new Apresentacao();
        apresentacao.setIdOrador(orador.getId());
        apresentacao.setTitulo("API Sintese e Reconhecimento de Voz");
        apresentacao.setSumario("Sintese e Reconhecimento de Voz");
        tabelaApresentacoes.inserir(apresentacao.getContentValues());*/
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     *
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
