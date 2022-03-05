package enemeez.simplefarming.events;

import enemeez.simplefarming.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.world.BlockEvent.FarmlandTrampleEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ScarecrowEvent {
	@SubscribeEvent
	public void scarecrowEvent(FarmlandTrampleEvent event) {
		if (!event.getWorld().isClientSide()) {
			int x = event.getPos().getX();
			int y = event.getPos().getY();
			int z = event.getPos().getZ();
			if (searchForScarecrow(event.getWorld(), x, y + 1, z))
				event.setCanceled(true);

		}
	}

	private boolean searchForScarecrow(LevelAccessor world, int x, int y, int z) {
		for (int x1 = x - 10; x1 < x + 10; x1++)
			for (int z1 = z - 10; z1 < z + 10; z1++) {
				if (world.getBlockState(new BlockPos(x1, y, z1)).getBlock() == ModBlocks.SCARECROW.get())
					return true;

			}
		return false;
	}

}
