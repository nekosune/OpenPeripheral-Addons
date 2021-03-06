package openperipheral.addons.proxy;

import net.minecraftforge.common.MinecraftForge;
import openmods.api.IProxy;
import openperipheral.addons.OpenPeripheralAddons;
import openperipheral.addons.client.BlockRenderingHandler;
import openperipheral.addons.client.SoundLoader;
import openperipheral.addons.glasses.TerminalManagerClient;
import openperipheral.addons.sensors.TileEntitySensor;
import openperipheral.addons.sensors.TileEntitySensorRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy implements IProxy {

	@Override
	public void preInit() {
		MinecraftForge.EVENT_BUS.register(new TerminalManagerClient());
		MinecraftForge.EVENT_BUS.register(new SoundLoader());
	}

	@Override
	public void init() {}

	@Override
	public void postInit() {}

	@Override
	public void registerRenderInformation() {
		OpenPeripheralAddons.renderId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new BlockRenderingHandler());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySensor.class, new TileEntitySensorRenderer());
	}

}
