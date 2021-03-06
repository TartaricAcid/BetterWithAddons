package betterwithaddons.interaction;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;

public class ModInteractions {
    public static ArrayList<IInteraction> LIST = new ArrayList<>();

    public static InteractionBWA bwa;
    public static InteractionBWM bwm;
    public static InteractionQuark quark;
    public static InteractionJEI jei;
    public static InteractionEriottoMod eriottoMod;
    public static InteractionCondensedOutputs condensedOutputs;
    public static InteractionDecoAddon decoAddon;
    public static InteractionBTWTweak btwTweak;

    public static void preInit(FMLPreInitializationEvent event) {
        bwa = (InteractionBWA) addInteraction(new InteractionBWA());
        bwm = (InteractionBWM) addInteraction(new InteractionBWM());
        quark = (InteractionQuark) addInteraction(new InteractionQuark());
        jei = (InteractionJEI) addInteraction(new InteractionJEI());
        eriottoMod = (InteractionEriottoMod) addInteraction(new InteractionEriottoMod());
        condensedOutputs = (InteractionCondensedOutputs) addInteraction(new InteractionCondensedOutputs());
        decoAddon = (InteractionDecoAddon) addInteraction(new InteractionDecoAddon());
        btwTweak = (InteractionBTWTweak) addInteraction(new InteractionBTWTweak());

        validate();

        for (IInteraction interaction: LIST)
            if(interaction.isActive())
                interaction.preInit();
    }

    public static void init(FMLInitializationEvent event)
    {
        for (IInteraction interaction: LIST)
            if(interaction.isActive())
                interaction.init();
    }

    public static void postInit(FMLPostInitializationEvent event)
    {
        for (IInteraction interaction: LIST)
            if(interaction.isActive())
                interaction.postInit();
    }

    private static IInteraction addInteraction(IInteraction interaction)
    {
        LIST.add(interaction);
        return interaction;
    }

    private static void validate()
    {
        for (IInteraction interaction: LIST) {
            if(interaction.getDependencies() != null)
            for(IInteraction dependency: interaction.getDependencies())
            {
                if(!dependency.isActive())
                {
                    interaction.setEnabled(false);
                    break;
                }
            }

            if(interaction.getIncompatibilities() != null)
            for(IInteraction incompatibility: interaction.getIncompatibilities())
            {
                if(incompatibility.isActive())
                {
                    interaction.setEnabled(false);
                    break;
                }
            }
        }
    }
}
