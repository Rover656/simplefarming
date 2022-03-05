package enemeez.simplefarming.events;

import enemeez.simplefarming.config.MiscConfig;
import enemeez.simplefarming.config.RightClickConfig;
import enemeez.simplefarming.events.harvest.*;
import net.minecraftforge.common.MinecraftForge;

public class EventSetup
{

    public static void setupEvents() {
        MinecraftForge.EVENT_BUS.register(new LootTableHandler());
        MinecraftForge.EVENT_BUS.register(new TemptationTask());
        MinecraftForge.EVENT_BUS.register(new IntoxicationTracker());
        MinecraftForge.EVENT_BUS.register(new ScarecrowEvent());

        if (MiscConfig.stem_toggle.get()) {
            MinecraftForge.EVENT_BUS.register(new StemReplaceEvent());
        }

        if (RightClickConfig.rightClickHarvest.get().isEnabled()) {
            if (RightClickConfig.crop_right_click.get()) MinecraftForge.EVENT_BUS.register(new CropHarvest());
            if (RightClickConfig.bush_right_click.get()) MinecraftForge.EVENT_BUS.register(new BerryBushHarvest());
            if (RightClickConfig.cactus_right_click.get()) MinecraftForge.EVENT_BUS.register(new CactusCropHarvest());
            if (RightClickConfig.doublecrop_right_click.get()) MinecraftForge.EVENT_BUS.register(new DoubleCropHarvest());
            if (RightClickConfig.tree_right_click.get()) MinecraftForge.EVENT_BUS.register(new FruitLeavesHarvest());
            if (RightClickConfig.grape_right_click.get()) MinecraftForge.EVENT_BUS.register(new GrapeHarvest());
            if (RightClickConfig.plant_right_click.get()) MinecraftForge.EVENT_BUS.register(new WildPlantHarvest());
        }
    }

}
