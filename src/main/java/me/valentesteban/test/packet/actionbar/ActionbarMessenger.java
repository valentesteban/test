package me.valentesteban.test.packet.actionbar;

import me.clip.placeholderapi.PlaceholderAPI;
import me.valentesteban.test.packet.Packets;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.entity.Player;

public class ActionbarMessenger {

    public void send(Player player, String message) {
        IChatBaseComponent chatBaseComponent = IChatBaseComponent.ChatSerializer.a(
                ComponentSerializer.toString(
                        TextComponent.fromLegacyText(
                                PlaceholderAPI.setPlaceholders(player, message))
                )
        );
        PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(chatBaseComponent, (byte) 2);
        Packets.sendPacket(player, packetPlayOutChat);
    }
}