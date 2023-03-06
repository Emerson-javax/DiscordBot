package me.emerson.bot.database;

import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

    public static void createTable() throws SQLException {


        String sql = "create table tb_guild\n" +
                "(\n" +
                " id INTEGER not null primary key autoincrement unique,\n" +
                " guild_id TEXT not null,\n" +
                " prefix TEXT not null\n" +
                ")";

        Statement statement = ConnectionFactory.getConn().createStatement();
        statement.execute(sql);
        statement.close();
        ConnectionFactory.getConn().close();
    }

}
