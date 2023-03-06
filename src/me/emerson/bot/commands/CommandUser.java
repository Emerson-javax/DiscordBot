package me.emerson.bot.commands;

import me.emerson.bot.main.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommandUser extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String[] message = e.getMessage().getContentRaw().split(" ");
        if(message[0].equalsIgnoreCase(Bot.prefixMap.get(e.getGuild().getIdLong()) + "user")) {
            String userName = message[1];
            User user = e.getGuild().getMembersByName(userName, true).get(0).getUser();
            String avatar = user.getAvatarUrl();
            EmbedBuilder avatarEmbed = new EmbedBuilder();

            avatarEmbed.setTitle(userName + "'s Info:");
            avatarEmbed.setColor(Color.CYAN);
            avatarEmbed.addField("Name", user.getName(), true);
            avatarEmbed.setImage("     "+ avatar);
            avatarEmbed.addField("Online Status: ", e.getGuild().getMembersByName(userName, true).get(0).getOnlineStatus().toString(), true);
            avatarEmbed.setFooter("Enviado às " + formatter.format(date), e.getGuild().getIconUrl());

            e.getChannel().sendMessageEmbeds(avatarEmbed.build()).queue();
        }
    }
}
