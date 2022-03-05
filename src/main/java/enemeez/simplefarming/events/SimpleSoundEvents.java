package enemeez.simplefarming.events;

import enemeez.simplefarming.SimpleFarming;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class SimpleSoundEvents {

	public static SoundEvent nourish = register("music_disc.nourish");

	private static SoundEvent register(String key) {
		ResourceLocation id = SimpleFarming.getId(key);
		SoundEvent event = new SoundEvent(id);
    	event.setRegistryName(id);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
}