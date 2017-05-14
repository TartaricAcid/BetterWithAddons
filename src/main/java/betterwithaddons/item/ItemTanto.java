package betterwithaddons.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ItemTanto extends ItemSword {
    public ItemTanto()
    {
        super(ModItems.tamahaganeToolMaterial);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        boolean hit = super.hitEntity(stack,target,attacker);

        if(hit && attacker.getHealth() <= 5.0f) {
            target.attackEntityFrom(DamageSource.causeMobDamage(attacker).setDamageBypassesArmor(), 6.0f);
            attacker.addPotionEffect(new PotionEffect(MobEffects.SPEED,15 * 20));
        }

        return hit;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        ItemStack itemStackIn = playerIn.getHeldItem(hand);

        if (playerIn.capabilities.isCreativeMode)
        {
            return new ActionResult(EnumActionResult.FAIL, itemStackIn);
        }
        else
        {
            playerIn.setActiveHand(hand);
            return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
        }
    }

    @Override
    public void onUsingTick(ItemStack stack, EntityLivingBase entityLiving, int timeLeft) {
        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            int i = timeLeft;
            System.out.println(i);
            if(i <= 1) {
                entityplayer.getEntityWorld().playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_SKELETON_DEATH, SoundCategory.NEUTRAL, 1.0f, 1.0f / (itemRand.nextFloat() * 0.4f + 2.2f));
                entityplayer.attackEntityFrom(DamageSource.causeMobDamage(entityplayer).setDamageBypassesArmor(), 1.0f);
                entityplayer.addStat(StatList.getObjectUseStats(this));
            }
        }
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 50;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }
}
