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
		ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
		ItemMeta meta = item.getItemMeta();
		String name = "���������� �������";
		meta.setDisplayName(ChatColor.AQUA + name);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.BOLD + "��������������� �������");
		lore.add(ChatColor.GREEN + "��� - ��������� '���������� �����'");//ScoutOfNess
		lore.add(ChatColor.GRAY + "�������, ����������� ��������");
		lore.add(ChatColor.GRAY + "���������� �� ������ ������,");
		lore.add(ChatColor.GRAY + "���, ���� �����");
		meta.setLore(lore);
		item.setItemMeta(meta);
		dic.put(name, item);
	}
	public static void addItem(String name, ItemStack item) {
		dic.put(name, item);
	}
	public static ItemStack getItem(String name) {
		return dic.get(name);
	}
}
