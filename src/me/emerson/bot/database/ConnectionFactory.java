package me.emerson.bot.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConn() throws SQLException {

        String url = "jdbc:sqlite:C:/Users/emers/OneDrive/Área de Trabalho/BancoDeDadosBot/bot.db";

        try {
            return DriverManager.getConnection(url);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

}
