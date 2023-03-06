package me.emerson.bot.main;

import me.emerson.bot.commands.CommandUser;
import me.emerson.bot.database.Config;
import me.emerson.bot.events.MemberJoin;
import me.emerson.bot.commands.Ping;
import me.emerson.bot.events.MemberLeave;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class Bot {
    public static Map<Long, Character> prefixMap = new HashMap<>();
    public static Map<Long, Long> joinChannelMap = new HashMap<>();
    public static Map<Long, Long> leaveChannelMap = new HashMap<>();
    public static JDA jda;
    public static void main(String[] args) throws LoginException, InterruptedException, SQLException, IOException {

        Config.createFilesAndTable();;

        jda = JDABuilder.create("MTA3MzgyMTIzMjkwNDAxOTk4OQ.GDxNTd.eAOGEJmTxOrYPM4OMsDLvF2yfvh5W8sbHXgqyk",
                EnumSet.allOf(GatewayIntent.class)).build();

        jda.addEventListener(new Ping());
        jda.addEventListener(new CommandUser());
        jda.addEventListener(new MemberJoin());
        jda.addEventListener(new MemberLeave());

        for (Guild guild: jda.awaitReady().getGuilds()) {
            prefixMap.put(guild.getIdLong(), '!');
            joinChannelMap.put(guild.getIdLong(), null);
            leaveChannelMap.put(guild.getIdLong(), null);
        }



    }
}
