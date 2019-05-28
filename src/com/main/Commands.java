package com.main;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class Commands implements CommandExecutor{
	private static Main plugin;
	
	public Commands(Main p) {
		this.plugin = p;
	}
	

	public boolean onCommand(CommandSender sender, Command c, String s , String[] args) {
		//admin only
		// TODO ������� ����������

		switch (c.getName())
		{
			case "saveStructure":
				sender.sendMessage("in develop");
				try{
					//Path.save(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]));
				}	catch(Exception e){
					sender.sendMessage("�������� ���������");

				}
				break;
			case "genshape":

				break;
			case "loadStructure":

				break;
		}
		
			
		return true;	
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
