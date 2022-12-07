package net.aspw.nightx.features.module.modules.movement.speeds.aac;

import net.aspw.nightx.event.MoveEvent;
import net.aspw.nightx.features.module.modules.movement.speeds.SpeedMode;
import net.aspw.nightx.utils.MovementUtils;

public class AACYPort2 extends SpeedMode {

    public AACYPort2() {
        super("AACYPort2");
    }

    @Override
    public void onMotion() {
        if (MovementUtils.isMoving()) {
            mc.thePlayer.cameraPitch = 0F;

            if (mc.thePlayer.onGround) {
                mc.thePlayer.jump();
                mc.thePlayer.motionY = 0.3851F;
                mc.thePlayer.motionX *= 1.01;
                mc.thePlayer.motionZ *= 1.01;
            } else
                mc.thePlayer.motionY = -0.21D;
        }
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onMove(MoveEvent event) {
    }
}