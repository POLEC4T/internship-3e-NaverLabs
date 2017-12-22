package SwordListeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

import static org.bukkit.Bukkit.getWorld;
import static org.bukkit.Material.COMPASS;

public class SwordListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        player.getInventory().clear();
        //player.getInventory().addItem(new ItemStack(Material.IRON_AXE,3));


        ItemStack MiloSword = new ItemStack(Material.IRON_AXE, 1);
        ItemMeta customM = MiloSword.getItemMeta();
        customM.setDisplayName("§cMa super hache en terre");
        customM.setLore(Arrays.asList("première ligne", "deuxième ligne", "troisième ligne"));
        customM.addEnchant(Enchantment.DAMAGE_ALL, 200, true);
        MiloSword.setItemMeta(customM);
        player.getInventory().addItem(MiloSword);


        ItemStack MiloCompas = new ItemStack(COMPASS, 1);
        ItemMeta boussoleM = MiloCompas.getItemMeta();
        boussoleM.setDisplayName("§4Ma super boussole");
        boussoleM.setLore(Arrays.asList("Click !"));
        MiloCompas.setItemMeta(boussoleM);
        player.getInventory().addItem(MiloCompas);
        player.updateInventory();

    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack it = event.getItem();

        if (it == null) return;

        if (it.getType() == Material.DIAMOND) {
            if (action == Action.LEFT_CLICK_AIR) {
                player.sendMessage("lol t'es trop faur");
            }
        }
        if (it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§4Ma super boussole")) {

            Inventory inv = Bukkit.createInventory(null, 27, "Mon menu");

            ItemStack apple = new ItemStack(Material.APPLE);
            ItemMeta appleM = apple.getItemMeta();
            appleM.setDisplayName("§aSPAWN");
            apple.setItemMeta(appleM);



            ItemStack quartz = new ItemStack(Material.QUARTZ);
            ItemMeta quartzM = quartz.getItemMeta();
            quartzM.setDisplayName("§bMAISON");
            quartz.setItemMeta(quartzM);

            inv.setItem(11, apple);
            inv.setItem(14, quartz);


            player.openInventory(inv);

        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){

        Inventory inv = event.getInventory();
        Player player = (Player)event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if (current == null) return;

        if (inv.getName().equalsIgnoreCase("Mon menu")){

            event.setCancelled(true);

            if (current.getType() == Material.APPLE){

                player.closeInventory();
                Location spawn = new Location(player.getWorld(), 0.5, 63, 0.5, 90, 0);
                player.sendMessage("§aVous venez d'être téléporté au spawn !");
                player.teleport(spawn);

            }

            if (current.getType() == Material.QUARTZ) {

                player.closeInventory();
                Location maison = new Location(player.getWorld(), -74.5, 71, -101, 90, 0);
                player.sendMessage("§eBienvenue dans votre maison !");
                player.teleport(maison);

            }




        }






    }



}

