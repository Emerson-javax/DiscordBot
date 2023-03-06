package me.emerson.bot.database;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;

public class Config {

    public static File databaseFile = new File("C:/Users/emers/OneDrive/Área de Trabalho/BancoDeDadosBot/Bot.db");

    public static void createFilesAndTable() throws IOException, SQLException {

    if(Files.notExists(databaseFile.toPath())){
        Files.createFile(databaseFile.toPath());
        CRUD.createTable();
    }


    }

}
