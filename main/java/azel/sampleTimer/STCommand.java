package azel.sampleTimer;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;

public class STCommand extends CommandBase
{
    /**
     * Gets the name of the command
     */
    public String getCommandName()
    {
        return "stTimer";
    }

    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel()
    {
        return 3;
    }

    /**
     * Gets the usage string for the command.
     */
    public String getCommandUsage(ICommandSender sender)
    {
        return "commands.stTimer.usage";
    }

    /**
     * Callback for when the command is executed
     */
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if (args.length == 1 && args[0].length() > 0)
        {
        	if(args[0].equalsIgnoreCase("start"))
        	{
        		//STARTの場合、スレッド処理を開始する。
        		STThread threadTimer = new STThread(sender, server);
        		threadTimer.start();
        	}else if(args[0].equalsIgnoreCase("stop"))
        	{
        		//STOPの場合、スレッドフラグを0(停止)に変更
        		SampleTimer.threadProc = 0;
        	}
        }
        else
        {
            throw new WrongUsageException("commands.stTimer.usage", new Object[0]);
        }
    }

    /**
     * Get a list of options for when the user presses the TAB key
     */
    /*
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos)
    {

        if (args.length == 1)
        {
            String s = args[args.length - 1];
            List<String> list = Lists.<String>newArrayList();

            for (GameProfile gameprofile : server.getGameProfiles())
            {
                if (!server.getPlayerList().canSendCommands(gameprofile) && doesStringStartWith(s, gameprofile.getName()))
                {
                    list.add(gameprofile.getName());
                }
            }

            return list;
        }
        else
        {
            return Collections.<String>emptyList();
        }
    }
    */
}