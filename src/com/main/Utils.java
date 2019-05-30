package com.main;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;

public final class Utils {
	private static ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
	
	public static Location getFreePosition(Location loc, int rangeX, int rangeZ) {
		World w = loc.getWorld();
		Random r = new Random();
		r.setSeed(1);
		Location retLoc = new Location(w, 0, 0, 0);
		for(int i = 0; i < 20; i++) {
			int x = loc.getBlockX() + rangeX;
			int y = loc.getBlockY();
			int z = loc.getBlockZ() + rangeZ;
			boolean b = false;
			for(int j = -20; j < 40; j++) {
				if(w.getBlockAt(x, y+j, z).getBlockData().getMaterial().equals(Material.AIR)) {
					if(!b) {	
						if(j == -20) break;
						retLoc = w.getBlockAt(x, y+j, z).getLocation();
					}
					b = true;
				}
								
			}
			if(b) {
				return retLoc;
			}
		}
		return retLoc;				
	}
	public static void spawnEntity(String name, Location loc, String[] Args) {
		String coord = (int)loc.getX() + " " + (int)loc.getY() + " " + (int)loc.getZ();
		switch(name) {
			case "ScoutOfNess":
				Bukkit.dispatchCommand(console, ("summon minecraft:skeleton_horse " + coord +" {Tame:1,Passengers:[{id:\"minecraft:skeleton\",CustomName:\""
						+ "\\\"Разведчик Неса\\\"\",CustomNameVisible:1,HandItems:[{id:\"minecraft:iron_sword\",tag:{Enchantments:[{id:sharpness,lvl:1}]},"
						+ "Count:1},{}],ArmorItems:[{id:\"minecraft:chainmail_boots\",Count:1},{id:\"minecraft:leather_leggings\",tag:{display:{color:1384365}},"
						+ "Count:1},{id:\"minecraft:chainmail_chestplate\",Count:1},{id:\"minecraft:leather_helmet\",tag:{display:{color:1384365}},Count:1}]}]}"));
				break;
		}
	}
	public static void createStructure(String name, Location loc, String[] Args) {
		String coord = (int)loc.getX() + " " + (int)loc.getY() + " " + (int)loc.getZ();
		Bukkit.dispatchCommand(console, "say " + coord);
	}
	
}
