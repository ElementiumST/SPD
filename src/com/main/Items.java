package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {
	static Map<String, ItemStack> dic = new HashMap<String, ItemStack>();
	public Items() {
		ItemStack item1 = new ItemStack(Material.ENCHANTED_BOOK);
		ItemMeta meta1 = item1.getItemMeta();
		String name1 = "Манускрипт призыва";
		meta1.setDisplayName(ChatColor.AQUA + name1);
		ArrayList<String> lore1 = new ArrayList<String>();
		lore1.add(ChatColor.BOLD + "Вспомогательный предмет");
		lore1.add(ChatColor.GREEN + "ПКМ - призывает 'Разведчика Несса'");//ScoutOfNess
		lore1.add(ChatColor.GRAY + "Предмет, позволяющий призвать");
		lore1.add(ChatColor.GRAY + "разведчика из далёких земель,");
		lore1.add(ChatColor.GRAY + "или, даже миров");
		meta1.setLore(lore1);
		item1.setItemMeta(meta1);
		dic.put(name1, item1);
		
		ItemStack item2 = new ItemStack(Material.DIAMOND);
		ItemMeta meta2 = item2.getItemMeta();
		String name2 = "Активатор";
		meta2.setDisplayName(ChatColor.STRIKETHROUGH + name2);
		ArrayList<String> lore2 = new ArrayList<String>();
		lore2.add(ChatColor.MAGIC + "Только для администраторов");
		meta2.setLore(lore2);
		item2.setItemMeta(meta2);
		dic.put(name2, item2);

	}
	public static void addItem(String name, ItemStack item) {
		dic.put(name, item);
	}
	public static ItemStack getItem(String name) {
		return dic.get(name);
	}
}
