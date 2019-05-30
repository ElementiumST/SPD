package com.main;

import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;



public class Events implements Listener  {
	private static boolean NessScoutEvent = false; 
	
	
	@EventHandler
	public void admin(AsyncPlayerChatEvent e) {
		if(!e.getPlayer().getName().equals("ElementiumBuilder") && !e.getPlayer().getName().equals("Elementium") && !e.getPlayer().isOp()) return;
		String name = e.getMessage();
		if(name.equals("GiveMeSummoner")) 
			e.getPlayer().getInventory().addItem(Items.getItem("Манускрипт призыва"));
		if(name.equals("GiveMeAdminItem")) 
			e.getPlayer().getInventory().addItem(Items.getItem("Активатор"));
			
			

		
	}
/*	
	@EventHandler
	public void crushedBlockFromMultiPicaxe(BlockBreakEvent e) {
		if(e.getPlayer() != null && 
				e.getBlock() != null && 
				e.getPlayer().getInventory() != null && 
				e.getPlayer().getInventory().getItemInMainHand() != null && 
				e.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null) {
			if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().cntains(ChatColor.GREEN +
					"Кирка, которая способна копать несколько блоков одновременно")) {
				e.getPlayer().sendMessage(e.getPlayer().getFacing().toString());
				
			}
		
		}
	}
*/	
	@EventHandler
	public void itemUse(PlayerInteractEvent e) {
		if(!(e.getAction().equals(Action.RIGHT_CLICK_AIR) ||e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) return;
			if(e.getItem() != null && e.getItem().getItemMeta() != null && e.getItem().getItemMeta().getLore()!= null) {
				List<String> lore = e.getItem().getItemMeta().getLore();
				if(!NessScoutEvent && lore.contains(ChatColor.GREEN + "ПКМ - призывает 'Разведчика Несса'")) {
					Random r = new Random();
					Location loc = Utils.getFreePosition(e.getPlayer().getLocation(), r.nextInt((14))-7, r.nextInt((14))-7);
					Utils.spawnEntity("ScoutOfNess", loc, null);
					NessScoutEvent = true;
					if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE))
						e.getPlayer().getInventory().remove(e.getItem());
	
				}
				if(e.getPlayer() != null && lore.contains(ChatColor.MAGIC + "Только для администраторов")) {
					e.getPlayer().sendMessage("Поехали!");
					Player p = e.getPlayer();
					p.teleport(new Location(Main.GetNess(), 0, 100, 0));
					
				}
		}	
	}
	@EventHandler
	public void mobKilled(EntityDeathEvent e) {
		if(e == null|| e.getEntity() == null || e.getEntity().getCustomName() == null)return;
		switch(e.getEntity().getCustomName()) {
			case "Разведчик Неса":
				NessScoutEvent = false;
				
				break;
		}
	}
}

	

/*
for(int numRooms = Generator.generateShape(100, 100, e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ(), 4, e); numRooms < 500;) {
	            numRooms = Generator.generateShape(100, 100,e.getClickedBlock().getX(), e.getClickedBlock().getY(), e.getClickedBlock().getZ(), 4, e);
			}
*/
/*	
	@EventHandler
	public void PlayerJoinInServer(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.sendMessage("1111111");
		ItemStack item = new ItemStack(Material.DIRT);
		for(int i = 0; i < 2; i++)
			p.getInventory().setItemInMainHand(item);
				
		e.getPlayer().sendMessage("2222222");
	}
	Block block = e.getBlock();
				Location up = block.getLocation().add(0,0,0);
		        Location down = block.getLocation().subtract(0,0,0);
		        Location left = block.getLocation().add(1,0,0);
		        Location leftt = block.getLocation().subtract(1,0,0);
		        Location right = block.getLocation().add(0,0,1);
		        Location rightt = block.getLocation().subtract(0,0,1);
		        Location up1 = block.getLocation().add(0,1,0);
		        Location down1 = block.getLocation().subtract(0,1,0);
		        Location left1 = block.getLocation().add(1,1,0);
		        Location left21 = block.getLocation().subtract(1,1,0);
		        Location right1 = block.getLocation().add(0,1,1);
		        Location right21 = block.getLocation().subtract(0,1,1);
		        Location up2 = block.getLocation().add(0,-1,0);
		        Location down2 = block.getLocation().subtract(0,-1,0);
		        Location left2 = block.getLocation().add(1,-1,0);
		        Location left22 = block.getLocation().subtract(1,-1,0);
		        Location right2 = block.getLocation().add(0,-1,1);
		        Location right22 = block.getLocation().subtract(0,-1,1);
		
		        Location corner = block.getLocation().subtract(1,0,1);
		        Location corner1 = block.getLocation().add(1,0,1);
		        Location corner2 = block.getLocation().subtract(-1,0,1);
		        Location corner3 = block.getLocation().subtract(1,0,-1);
		        Location corner4 = block.getLocation().subtract(1,1,1);
		        Location corner5 = block.getLocation().add(1,1,1);
		        Location corner6 = block.getLocation().subtract(-1,1,1);
		        Location corner7 = block.getLocation().subtract(1,1,-1);
		        Location corner8 = block.getLocation().subtract(1,-1,1);
		        Location corner9 = block.getLocation().add(1,-1,1);
		        Location corner10 = block.getLocation().subtract(-1,-1,1);
		        Location corner11 = block.getLocation().subtract(1,-1,-1);
		
		        up.getBlock().setType(Material.AIR);
		        down.getBlock().setType(Material.AIR);
		        left.getBlock().setType(Material.AIR);
		        right.getBlock().setType(Material.AIR);
		        leftt.getBlock().setType(Material.AIR);
		        rightt.getBlock().setType(Material.AIR);
		  
		        up1.getBlock().setType(Material.AIR);
		        down1.getBlock().setType(Material.AIR);
		        left1.getBlock().setType(Material.AIR);
		        left21.getBlock().setType(Material.AIR);
		        right1.getBlock().setType(Material.AIR);
		        right21.getBlock().setType(Material.AIR);
		  
		        up2.getBlock().setType(Material.AIR);
		        down2.getBlock().setType(Material.AIR);
		        left22.getBlock().setType(Material.AIR);
		        right2.getBlock().setType(Material.AIR);
		        left2.getBlock().setType(Material.AIR);
		        right22.getBlock().setType(Material.AIR);
		  
		        corner.getBlock().setType(Material.AIR);
		        corner1.getBlock().setType(Material.AIR);
		        corner2.getBlock().setType(Material.AIR);
		        corner3.getBlock().setType(Material.AIR);
		        corner4.getBlock().setType(Material.AIR);
		        corner5.getBlock().setType(Material.AIR);
		        corner6.getBlock().setType(Material.AIR);
		        corner7.getBlock().setType(Material.AIR);
		        corner8.getBlock().setType(Material.AIR);
		        corner9.getBlock().setType(Material.AIR);
		        corner10.getBlock().setType(Material.AIR);
		        corner11.getBlock().setType(Material.AIR);
			}
			
		}
	
*/	

/*
ItemStack item1 = new ItemStack(Material.DIAMOND);
ItemMeta meta1 = item1.getItemMeta();
meta1.setUnbreakable(true);
meta1.addEnchant(Enchantment.OXYGEN, 100 , true);
meta1.setDisplayName(ChatColor.GOLD + "Generator");
List<String> lore = new ArrayList<String>();
lore.add("its developer item");
meta1.setLore(lore);
item1.setItemMeta(meta1);
e.getPlayer().getInventory().addItem(item1);
*/
/*
ItemStack item = new ItemStack(Material.IRON_PICKAXE);
ItemMeta meta = item.getItemMeta();
meta.setDisplayName(ChatColor.BLUE + "Кирка Марах-Бади");
ArrayList<String> lore = new ArrayList<String>();
lore.add(ChatColor.BOLD + "Магический");
lore.add(ChatColor.GREEN + "Кирка, которая способна копать несколько блоков 			одновременно");//ScoutOfNess
lore.add(ChatColor.GRAY + "Кирка, способная одним ударом");
lore.add(ChatColor.GRAY + "разрушать всё, вокруг того места,");
lore.add(ChatColor.GRAY + "В которое был нанесен удар.");
meta.setLore(lore);
item.setItemMeta(meta);
e.getPlayer().getInventory().addItem(item);
*/
/*	
@EventHandler
public void crushedBlockFromMultiPicaxe(BlockBreakEvent e) {
	if(e.getPlayer() != null && 
			e.getBlock() != null && 
			e.getPlayer().getInventory() != null && 
			e.getPlayer().getInventory().getItemInMainHand() != null && 
			e.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null) {
		if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().cntains(ChatColor.GREEN +
				"Кирка, которая способна копать несколько блоков одновременно")) {
			e.getPlayer().sendMessage(e.getPlayer().getFacing().toString());
			
		}
	
	}
}
*/