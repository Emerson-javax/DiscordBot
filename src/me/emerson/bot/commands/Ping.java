package me.emerson.bot.commands;

import me.emerson.bot.main.Bot;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
public class Ping extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split(" ");
        TextChannel textChannel = event.getChannel().asTextChannel();

        if(args[0].equalsIgnoreCase(Bot.prefixMap.get(event.getGuild().getIdLong()) + "ping")) {
            textChannel.sendMessage(Bot.jda.getGatewayPing() + "ms").queue();
        }
    }
}
