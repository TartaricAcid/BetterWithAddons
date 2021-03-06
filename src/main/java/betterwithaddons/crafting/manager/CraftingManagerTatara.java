package betterwithaddons.crafting.manager;

import com.google.common.collect.Maps;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.Map;

public class CraftingManagerTatara {
    private static final CraftingManagerTatara instance = new CraftingManagerTatara();
    private final Map<ItemStack, ItemStack> smeltingList = Maps.newHashMap();

    public static CraftingManagerTatara instance() {
        return instance;
    }

    private CraftingManagerTatara() {
    }

    public void addSmeltingRecipe(ItemStack input, ItemStack output) {
        if(!this.getSmeltingResult(input).isEmpty()) {
            FMLLog.info("Ignored tatara recipe with conflicting input: " + input + " = " + output, new Object[0]);
        } else {
            this.smeltingList.put(input, output);
        }
    }

    @Nullable
    public ItemStack getSmeltingResult(ItemStack input) {
        Iterator var2 = this.smeltingList.entrySet().iterator();

        Map.Entry entry;
        do {
            if(!var2.hasNext()) {
                return ItemStack.EMPTY;
            }

            entry = (Map.Entry)var2.next();
        } while(!this.compareItemStacks(input, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean compareItemStacks(ItemStack p_compareItemStacks_1_, ItemStack p_compareItemStacks_2_) {
        return p_compareItemStacks_2_.getItem() == p_compareItemStacks_1_.getItem() && (p_compareItemStacks_2_.getMetadata() == OreDictionary.WILDCARD_VALUE || p_compareItemStacks_2_.getMetadata() == p_compareItemStacks_1_.getMetadata());
    }

    public Map<ItemStack, ItemStack> getSmeltingList() {
        return this.smeltingList;
    }
}
