package com.drunkshulker.bartender.client.commands;

import com.drunkshulker.bartender.Bartender;
import com.drunkshulker.bartender.client.commands.helper.CommandsHelper;
import com.google.common.collect.Lists;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ScriptCommand implements ICommand {

	@Override
	public int compareTo(ICommand arg0) {
		return 0;
	}

	@Override
	public String getName() {
		return "script";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/script <name>";
	}

	@Override
	public List<String> getAliases() {
		List<String> aliases = Lists.<String>newArrayList();
		aliases.add("/script");
		return aliases;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(args==null||args.length!=1) {
			Bartender.msg("Invalid args.");
			return;
		} else {
			CommandsHelper.findScript(args[0]);
		}
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return true;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) {
		return Collections.emptyList();
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}
	
	private TextComponentTranslation format(TextFormatting color, String str, Object... args)
    {
        TextComponentTranslation ret = new TextComponentTranslation(str, args);
        ret.getStyle().setColor(color);
        return ret;
    }
}