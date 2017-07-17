package azel.sampleTimer;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.text.TextComponentTranslation;

public class STUtil {

	public static void doBroadcastMessage(String par1, ICommandSender sender, MinecraftServer server)
	{
        if (par1 != null)
        {
        	//サーバー上の全プレイヤーにメッセージ送信
            server.getPlayerList().sendChatMsg(new TextComponentTranslation("chat.type.announcement", new Object[] {sender.getDisplayName(), par1}));
        }
	}

	public static void doBroadcastMessage2(String par1, ICommandSender sender, MinecraftServer server)
	{
        if (par1 != null)
        {
        	//サーバー上の全プレイヤーにメッセージ送信
            PlayerList playerList = server.getPlayerList();
        }
	}
}
