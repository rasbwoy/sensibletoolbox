package io.github.thebusybiscuit.sensibletoolbox.api.gui;

import org.apache.commons.lang.Validate;

import io.github.thebusybiscuit.sensibletoolbox.api.LightMeterHolder;

/**
 * Measures the light intensity for an STB block.  The GUI that this gadget
 * is added to must be owned by an STB block which implements
 * {@link io.github.thebusybiscuit.sensibletoolbox.api.LightMeterHolder}.
 */
public class LightMeter extends MonitorGadget {
    /**
     * Constructs a new light meter gadget.
     *
     * @param gui the GUI which holds this gadget
     */
    public LightMeter(InventoryGUI gui) {
        super(gui);
        Validate.isTrue(gui.getOwningBlock() instanceof LightMeterHolder, "Attempt to install light meter in non-lightmeter-holder block!");
    }

    @Override
    public void repaint() {
        LightMeterHolder ls = (LightMeterHolder) getOwner();
        getGUI().getInventory().setItem(ls.getLightMeterSlot(), ls.getLightMeterIndicator());
    }

    @Override
    public int[] getSlots() {
        return new int[]{((LightMeterHolder) getOwner()).getLightMeterSlot()};
    }
}
