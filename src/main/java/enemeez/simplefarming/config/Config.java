package enemeez.simplefarming.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec CONFIG;

	static {

		BUILDER.push("Tweak World Generation Rates");
		WorldGenChances.init(BUILDER);
		BUILDER.pop();

		BUILDER.push("Enable/Disable World Generation");
		EnableConfig.init(BUILDER);
		BUILDER.pop();

		BUILDER.push("Miscellaneous Features");
		MiscConfig.init(BUILDER);
		BUILDER.pop();

		BUILDER.push("Right-click Harvesting Settings");
		RightClickConfig.init(BUILDER);
		BUILDER.pop();

		/*
		BUILDER.push("Dimensions Settings");
		DimensionConfig.init(BUILDER);
		BUILDER.pop();
		*/
		BUILDER.push("Hunger Value Settings");
		HungerConfig.init(BUILDER);
		BUILDER.pop();

		BUILDER.push("Seed Drop Settings");
		SeedConfig.init(BUILDER);
		BUILDER.pop();
		CONFIG = BUILDER.build();
	}

	public static void loadConfig(ForgeConfigSpec config, String path) {
		CommentedFileConfig file = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
		file.load();
		config.setConfig(file);
	}
}