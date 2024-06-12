package hu.serwenyi.mentorud.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class OnDeathEvent implements Listener {
    @EventHandler
    public void playerDeath(PlayerDeathEvent e) {
        Player player = e.getEntity().getPlayer();
        ItemStack saveRod = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = saveRod.getItemMeta();
        meta.setDisplayName("Mentő rúd");
        List lore = new ArrayList();
        lore.add("Megment téged  a haláltól");
        meta.setLore(lore);
        saveRod.setItemMeta(meta);
        ItemStack[] var9;
        int var8 = (var9 = player.getInventory().getContents()).length;

        for(int var7 = 0; var7 < var8; ++var7) {
            ItemStack allDrops = var9[var7];

            try {
                if (allDrops.isSimilar(saveRod)) {
                    e.setKeepInventory(true);
                    if (allDrops.getAmount() == 1) {
                        player.getInventory().remove(saveRod);
                        player.sendMessage("Megmenekültél");
                        e.getDrops().clear();
                    } else {
                        allDrops.setAmount(allDrops.getAmount() - 1);
                        player.sendMessage("Megmenekültél");
                        e.getDrops().clear();
                    }
                }
            } catch (Exception var11) {
            }
        }

    }
}
