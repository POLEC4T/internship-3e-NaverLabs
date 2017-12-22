package fr.polecat.test;

import SwordListeners.SwordListeners;
import org.bukkit.plugin.java.JavaPlugin;

public class Sword extends JavaPlugin {

    @Override
    public void onEnable() {

        System.out.println("Le plugin 'Sword' vient de s'allumer");
        getServer().getPluginManager().registerEvents(new SwordListeners(),this);

    }

    @Override
    public void onDisable(){

        System.out.println("Le plugin 'Sword' vient de s'eteindre");

    }










}