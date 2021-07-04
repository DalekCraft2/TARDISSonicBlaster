/*
 * Copyright (C) 2021 eccentric_nz
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package me.eccentric_nz.tardissonicblaster;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

/**
 * @author eccentric_nz
 */
public class TardisSonicBlasterCraftListener implements Listener {

    /**
     * This event will check the crafting recipe to see if it is a sonic
     * upgrade. If it is, then the current sonic screwdriver is queried to see
     * if it has the desired upgrade. If it hasn't (and the player has
     * permission) then the upgrade is added.
     *
     * @param event A player preparing to craft a sonic upgrade
     */
    @EventHandler(priority = EventPriority.HIGH)
    public void onSonicUpgrade(PrepareItemCraftEvent event) {
        CraftingInventory craftingInventory = event.getInventory();
        Recipe recipe = craftingInventory.getRecipe();
        ItemStack itemStack = craftingInventory.getResult();
        if (recipe instanceof ShapedRecipe) {
            if (itemStack == null || !itemStack.hasItemMeta() || !itemStack.getItemMeta().hasDisplayName() || !itemStack.getItemMeta().getDisplayName().equals("Sonic Blaster")) {
                return;
            }
            ItemStack b1 = craftingInventory.getItem(7); // TODO Figure out what these two "b" variables are and rename them.
            ItemStack b2 = craftingInventory.getItem(9);
            if ((!b1.hasItemMeta() || !b2.hasItemMeta()) || (!b1.getItemMeta().hasDisplayName() || !b2.getItemMeta().hasDisplayName()) || (!b1.getItemMeta().getDisplayName().equals("Blaster Battery") || !b2.getItemMeta().getDisplayName().equals("Blaster Battery"))) {
                craftingInventory.setResult(null);
            }
        }
    }
}
