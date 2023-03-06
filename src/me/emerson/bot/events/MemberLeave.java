package me.emerson.bot.events;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.thread.member.ThreadMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberLeave extends ListenerAdapter {
    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
        TextChannel textChannel = event.getGuild().getTextChannelById(1077432690770452480L);
        String userName = event.getMember().getUser().getName();

        textChannel.sendMessage(userName + " saiu do Servidor!").queue();

    }
}
