package me.emerson.bot.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.thread.member.ThreadMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.ImageProxy;

import java.awt.*;

public class MemberJoin extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent e) {
        TextChannel textChannel = e.getGuild().getTextChannelById(1077432654082875413L);
        String nome = e.getMember().getUser().getName();
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(nome + "Bem vindo sr. Paulo!");
        eb.setColor(Color.RED);


    }
}
