package openperipheral.addons.sensors;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import openperipheral.adapter.AdapterManager;
import openperipheral.addons.OpenPeripheralAddons.Blocks;
import dan200.computer.api.IHostedPeripheral;
import dan200.turtle.api.*;

public class TurtleUpgradeSensor implements ITurtleUpgrade {

	private static class TurtleSensorEnvironment implements ISensorEnvironment {

		private ITurtleAccess turtle;

		public TurtleSensorEnvironment(ITurtleAccess turtle) {
			this.turtle = turtle;
		}

		@Override
		public boolean isTurtle() {
			return true;
		}

		@Override
		public Vec3 getLocation() {
			return turtle.getPosition();
		}

		@Override
		public World getWorld() {
			return turtle.getWorld();
		}

		@Override
		public int getSensorRange() {
			return 30;
		}

	}

	@Override
	public int getUpgradeID() {
		return 180;
	}

	@Override
	public String getAdjective() {
		return StatCollector.translateToLocal("openperipheral.turtle.sensor.adjective");
	}

	@Override
	public TurtleUpgradeType getType() {
		return TurtleUpgradeType.Peripheral;
	}

	@Override
	public ItemStack getCraftingItem() {
		return new ItemStack(Blocks.sensor);
	}

	@Override
	public boolean isSecret() {
		return false;
	}

	@Override
	public IHostedPeripheral createPeripheral(ITurtleAccess turtle, TurtleSide side) {
		return AdapterManager.createHostedPeripheral(new TurtleSensorEnvironment(turtle));
	}

	@Override
	public boolean useTool(ITurtleAccess turtle, TurtleSide side, TurtleVerb verb, int direction) {
		return false;
	}

	@Override
	public Icon getIcon(ITurtleAccess turtle, TurtleSide side) {
		return Blocks.sensor.turtleIcon;
	}

}
