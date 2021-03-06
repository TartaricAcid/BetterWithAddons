package betterwithaddons.config;

import betterwithaddons.interaction.*;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModConfiguration {
    Configuration configuration;
    ConfigOptionBool BWM_Enabled = new ConfigOptionBool("interaction.BetterWithMods", "Enabled", InteractionBWM.ENABLED);
    ConfigOptionBool BWM_MillClay = new ConfigOptionBool("interaction.BetterWithMods", "MillClay", InteractionBWM.MILL_CLAY, "Hardened clay can be milled into bricks, saving fuel and allowing dyed bricks.");
    ConfigOptionBool BWM_ChorusInCauldron = new ConfigOptionBool("interaction.BetterWithMods", "ChorusInCauldron", InteractionBWM.CHORUS_IN_CAULDRON, "Chorus fruit (and Midori) can only be popped in a cauldron.");
    ConfigOptionBool BWM_ButcherBlocks = new ConfigOptionBool("interaction.BetterWithMods", "ButcherBlocks", InteractionBWM.BUTCHER_BLOCKS, "Striking an enemy on chopping blocks will bloody them and bestow a short strenth buff.");

    ConfigOptionBool Quark_Enabled = new ConfigOptionBool("interaction.Quark", "Enabled", InteractionQuark.ENABLED);
    ConfigOptionBool Quark_MidoriBlocksNeedChunks = new ConfigOptionBool("interaction.Quark", "Enabled", InteractionQuark.MIDORI_BLOCKS_NEED_CHUNKS, "Midori blocks require popped Midori chunks.");

    ConfigOptionBool BWA_StoneBricksNeedSmelting = new ConfigOptionBool("addons.BetterWithAddons", "StoneBricksNeedSmelting", InteractionBWA.STONEBRICKS_NEED_SMELTING, "Stonebricks need two extra steps in crafting.");
    ConfigOptionInteger BWA_LureTreeRadius = new ConfigOptionInteger("addons.BetterWithAddons", "LureTreeRadius", InteractionBWA.RADIUS, "Radius in which the tree can spawn mobs.");
    ConfigOptionInteger BWA_LureTreeTime = new ConfigOptionInteger("addons.BetterWithAddons", "LureTreeTime", InteractionBWA.MAXCHARGE, "Time it takes for the tree to do one spawning cycle.");
    ConfigOptionInteger BWA_LureTreeMaxFood = new ConfigOptionInteger("addons.BetterWithAddons", "LureTreeMaxFood", InteractionBWA.MAXFOOD, "How much food the tree can hold.");
    ConfigOptionInteger BWA_LureTreeFoodGlowstone = new ConfigOptionInteger("addons.BetterWithAddons", "LureTreeFoodGlowstone", InteractionBWA.FOODGLOWSTONE, "How much food is contained in one glowstone dust.");
    ConfigOptionBool BWA_ObviousStorms = new ConfigOptionBool("addons.BetterWithAddons", "ObviousStorms", InteractionBWA.OBVIOUS_STORMS, "Storms in dry biomes are much more obvious.");
    ConfigOptionBool BWA_ObviousSandStorms = new ConfigOptionBool("addons.BetterWithAddons", "ObviousSandStorms", InteractionBWA.OBVIOUS_SAND_STORMS, "Storms in sandy biomes are even more obvious.");
    ConfigOptionInteger BWA_ObviousDustParticles = new ConfigOptionInteger("addons.BetterWithAddons", "ObviousDustParticles", InteractionBWA.DUST_PARTICLES, "How many dust particles are kicked up every tick.");
    ConfigOptionInteger BWA_ObviousAirParticles = new ConfigOptionInteger("addons.BetterWithAddons", "ObviousAirParticles", InteractionBWA.AIR_PARTICLES, "How many wind particles are generated every tick.");

    ConfigOptionBool CondensedOutputs_Enabled = new ConfigOptionBool("addons.CondensedOutputs", "Enabled", InteractionCondensedOutputs.ENABLED);
    ConfigOptionBool CondensedOutputs_LoseBinder = new ConfigOptionBool("addons.CondensedOutputs", "LoseBinder", InteractionCondensedOutputs.LOSE_BINDER, "When uncrafting condensed materials, the binding material is not returned.");

    ConfigOptionBool EriottoMod_Enabled = new ConfigOptionBool("addons.EriottoMod", "Enabled", InteractionEriottoMod.ENABLED);
    ConfigOptionBool EriottoMod_GrassDropsSeeds = new ConfigOptionBool("addons.EriottoMod", "GrassDropsSeeds", InteractionEriottoMod.GRASS_DROPS_SEEDS, "Rice and Rush seeds can be gotten from breaking grass.");

    ConfigOptionBool DecoAddon_Enabled = new ConfigOptionBool("addons.DecoAddon", "Enabled", InteractionDecoAddon.ENABLED);
    ConfigOptionBool DecoAddon_WoodColoring = new ConfigOptionBool("addons.DecoAddon", "WoodColoring", InteractionDecoAddon.WOOD_COLORING, "Vanilla planks can be bleached or stained.");
    ConfigOptionBool DecoAddon_AlternateWroughtBars = new ConfigOptionBool("addons.DecoAddon", "AlternateWroughtBars", InteractionDecoAddon.ALTERNATE_WROUGHT_BARS, "Wrought bars are made at a ratio of 1 iron ingot per bar instead of 1/2 an iron ingot per bar.");
    ConfigOptionBool DecoAddon_ChiselBricksInAnvil = new ConfigOptionBool("addons.DecoAddon", "ChiselBricksInAnvil", InteractionDecoAddon.CHISEL_BRICKS_IN_ANVIL, "Chiseled Stone Bricks can only be crafted on a Steel Anvil.");
    ConfigOptionBool DecoAddon_GlassPaneRebalance = new ConfigOptionBool("addons.DecoAddon", "GlassPaneRebalance", InteractionDecoAddon.GLASS_PANE_REBALANCE, "Glass becomes neatly divisable into two glass panes per block.");
    ConfigOptionBool DecoAddon_GlassFurnace = new ConfigOptionBool("addons.DecoAddon", "GlassFurnace", InteractionDecoAddon.GLASS_FURNACE, "Glass chunks can be smelted in a furnace.");
    ConfigOptionBool DecoAddon_CheaperBottles = new ConfigOptionBool("addons.DecoAddon", "CheaperBottles", InteractionDecoAddon.CHEAPER_BOTTLES, "Glass bottles are made from half as much glass as normal.");
    ConfigOptionBool DecoAddon_RecycleBottles = new ConfigOptionBool("addons.DecoAddon", "RecycleBottles", InteractionDecoAddon.RECYCLE_BOTTLES, "Glass bottles can melted into chunks in a crucible. This allows you to make glass from a witch farm.");

    ConfigOptionBool BTWTweak_Enabled = new ConfigOptionBool("addons.BTWTweak", "Enabled", InteractionBTWTweak.ENABLED);
    //ConfigOptionBool BTWTweak_KilnDoubling = new ConfigOptionBool("addons.BTWTweak", "KilnDoubling", InteractionBTWTweak.KILN_DOUBLING, "Ores can be smelted into double the amount of output in a kiln.");
    ConfigOptionBool BTWTweak_SoftWoods = new ConfigOptionBool("addons.BTWTweak", "SoftWoods", InteractionBTWTweak.SOFT_WOODS, "Spruce, Jungle and Dark Oak logs are much easier to break.");
    ConfigOptionBool BTWTweak_HardStumps = new ConfigOptionBool("addons.BTWTweak", "HardStumps", InteractionBTWTweak.HARD_STUMPS, "Makes treefarms great ag- I mean, makes logs with dirt underneath them much harder to break to encourage leaving awesome stumps.");
    ConfigOptionBool BTWTweak_SawRecycling = new ConfigOptionBool("addons.BTWTweak", "SawRecycling", InteractionBTWTweak.SAW_RECYCLING, "Many wooden blocks can be recycled by putting them infront of a saw, at a bit of a loss.");
    ConfigOptionBool BTWTweak_EggIncubation = new ConfigOptionBool("addons.BTWTweak", "EggIncubation", InteractionBTWTweak.EGG_INCUBATION, "Allows eggs to be incubated into chicken by placing them on a Block of Padding with a lit Light Block above.");

    public void preInit(FMLPreInitializationEvent event)
    {
        configuration = new Configuration(event.getSuggestedConfigurationFile());
        configuration.load();

        configuration.getCategory("interaction").setComment("Enable or disable mod interactions.");

        InteractionBWM.ENABLED = BWM_Enabled.init(configuration);
        InteractionBWM.MILL_CLAY = BWM_MillClay.init(configuration);
        InteractionBWM.CHORUS_IN_CAULDRON = BWM_ChorusInCauldron.init(configuration);
        InteractionBWM.BUTCHER_BLOCKS = BWM_ButcherBlocks.init(configuration);
        InteractionQuark.ENABLED = Quark_Enabled.init(configuration);
        InteractionQuark.MIDORI_BLOCKS_NEED_CHUNKS = Quark_MidoriBlocksNeedChunks.init(configuration);

        configuration.getCategory("addons").setComment("Configure individual addons.");

        InteractionBWA.STONEBRICKS_NEED_SMELTING = BWA_StoneBricksNeedSmelting.init(configuration);
        InteractionBWA.RADIUS = BWA_LureTreeRadius.init(configuration);
        InteractionBWA.MAXCHARGE = BWA_LureTreeTime.init(configuration);
        InteractionBWA.MAXFOOD = BWA_LureTreeMaxFood.init(configuration);
        InteractionBWA.FOODGLOWSTONE = BWA_LureTreeFoodGlowstone.init(configuration);
        InteractionBWA.OBVIOUS_STORMS = BWA_ObviousStorms.init(configuration);
        InteractionBWA.OBVIOUS_SAND_STORMS = BWA_ObviousSandStorms.init(configuration);
        InteractionBWA.DUST_PARTICLES = BWA_ObviousDustParticles.init(configuration);
        InteractionBWA.AIR_PARTICLES = BWA_ObviousAirParticles.init(configuration);
        InteractionEriottoMod.ENABLED = EriottoMod_Enabled.init(configuration);
        InteractionEriottoMod.GRASS_DROPS_SEEDS = EriottoMod_GrassDropsSeeds.init(configuration);
        InteractionDecoAddon.ENABLED = DecoAddon_Enabled.init(configuration);
        InteractionDecoAddon.WOOD_COLORING = DecoAddon_WoodColoring.init(configuration);
        InteractionDecoAddon.ALTERNATE_WROUGHT_BARS = DecoAddon_AlternateWroughtBars.init(configuration);
        InteractionDecoAddon.CHISEL_BRICKS_IN_ANVIL = DecoAddon_ChiselBricksInAnvil.init(configuration);
        InteractionDecoAddon.GLASS_PANE_REBALANCE = DecoAddon_GlassPaneRebalance.init(configuration);
        InteractionDecoAddon.GLASS_FURNACE = DecoAddon_GlassFurnace.init(configuration);
        InteractionDecoAddon.CHEAPER_BOTTLES = DecoAddon_CheaperBottles.init(configuration);
        InteractionDecoAddon.RECYCLE_BOTTLES = DecoAddon_RecycleBottles.init(configuration);
        InteractionCondensedOutputs.ENABLED = CondensedOutputs_Enabled.init(configuration);
        InteractionCondensedOutputs.LOSE_BINDER = CondensedOutputs_LoseBinder.init(configuration);
        InteractionBTWTweak.ENABLED = BTWTweak_Enabled.init(configuration);
        //InteractionBTWTweak.KILN_DOUBLING = BTWTweak_KilnDoubling.init(configuration);
        InteractionBTWTweak.SOFT_WOODS = BTWTweak_SoftWoods.init(configuration);
        InteractionBTWTweak.HARD_STUMPS = BTWTweak_HardStumps.init(configuration);
        InteractionBTWTweak.SAW_RECYCLING = BTWTweak_SawRecycling.init(configuration);
        InteractionBTWTweak.EGG_INCUBATION = BTWTweak_EggIncubation.init(configuration);

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
}
