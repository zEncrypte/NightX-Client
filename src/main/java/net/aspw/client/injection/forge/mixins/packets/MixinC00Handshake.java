package net.aspw.client.injection.forge.mixins.packets;

import net.minecraft.client.Minecraft;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.handshake.client.C00Handshake;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/**
 * The type Mixin c 00 handshake.
 */
@Mixin(C00Handshake.class)
public class MixinC00Handshake {

    /**
     * The Port.
     */
    @Shadow
    public int port;
    /**
     * The Ip.
     */
    @Shadow
    public String ip;
    @Shadow
    private int protocolVersion;
    @Shadow
    private EnumConnectionState requestedState;

    @ModifyConstant(method = "writePacketData", constant = @Constant(stringValue = "\u0000FML\u0000"))
    private String injectAntiForge(String constant) {
        return !Minecraft.getMinecraft().isIntegratedServerRunning() ? "" : "\u0000FML\u0000";
    }
}