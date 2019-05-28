package com.main;




import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.mysql.jdbc.Util;



public class Main extends JavaPlugin implements Listener {
	 static World world;
	 public final static Items items = new Items();
	
	public void onEnable() {
		
		
		createWorld();
		Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);
		Bukkit.getServer().getConsoleSender().sendMessage("Its working");
		getCommand("saveStructure").setExecutor(new Commands(this));
		//Commands.fileSeparator();
		//craft();
		


		
	}
	public static World GetNess() {
		return world;
	}
	
	public void createWorld() {
		WorldCreator wc = new WorldCreator("ness");
		wc.type(WorldType.NORMAL);
		wc.generateStructures(false);
		wc.seed(1091939);
		world = wc.createWorld();
	}
	
	public void onDisable() {
		
	}
	/*
	 private void craft(){
			/*	ItemStack item1 = new ItemStack(Material.DIAMOND);
			*	ItemMeta meta1 = item1.getItemMeta();
			*	meta1.addEnchant(Enchantment.OXYGEN, 1 , false);
			*	meta1.setDisplayName("Generator");
			*/
			
			
			/*
	        ItemStack item = new ItemStack(Material.DIAMOND);
	        ItemMeta meta = item.getItemMeta();
	        meta.setDisplayName(ChatColor.GREEN + "Teleporter");
	        List<String> lore = new ArrayList<String>();
	        lore.add("Ender-teleport");
	        meta.setLore(lore);
	         meta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);

	        item.setItemMeta(meta);


	        ShapedRecipe s = new ShapedRecipe(item);
	        s.shape(new String[] {"A A", " B ", "A A"});



	        s.setIngredient('A', Material.ENDER_PEARL);
	        s.setIngredient('B', Material.DIAMOND);
	        Bukkit.getServer().addRecipe(s);
		
		 ItemStack item1 = new ItemStack(Material.STICK);
		 ItemMeta meta1 = item1.getItemMeta(); 
		 meta1.addEnchant(Enchantment.DAMAGE_ALL, 6, false);
		 meta1.addEnchant(Enchantment.KNOCKBACK, 1, false);
		 meta1.setDisplayName(ChatColor.GREEN + "Staff of Furious Healing");
		 List<String> lore1 = new ArrayList<String>(); 						
	        lore1.add(ChatColor.DARK_PURPLE +"Can heal an ally using healing potions");
	        lore1.add(ChatColor.DARK_PURPLE + "");
	        lore1.add(ChatColor.RED + "Can not use explosive potions");
	        lore1.add(ChatColor.RED + "takes precedence over stronger potions"); 										 
	        meta1.setLore(lore1);
	     item1.setItemMeta(meta1);
	     ShapedRecipe s1 = new ShapedRecipe(item1); 	
	     s1.shape(new String[] {"   ", " S ", "   "});
	     s1.setIngredient('S', Material.STICK);
	     Bukkit.getServer().addRecipe(s1); 		
	
	}
	*/
}
