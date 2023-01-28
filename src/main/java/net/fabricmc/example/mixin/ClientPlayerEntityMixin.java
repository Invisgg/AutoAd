package net.fabricmc.example.mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import net.minecraft.class_310;
import net.fabricmc.example.ExampleModInstance;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({ class_746.class })
public class ClientPlayerEntityMixin
{
    private long lastTime;
    
    @Inject(at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;tick()V", ordinal = 0) }, method = { "tick()V" })
    private void onTick(final CallbackInfo ci) {
        if (ExampleModInstance.INSTANCE.isEnabled() && System.currentTimeMillis() - this.lastTime > ExampleModInstance.INSTANCE.getDelay() + this.randomNumber(2000L, 10000L)) {
            if (class_310.method_1551().method_1562() == null) {
                return;
            }
            class_310.method_1551().method_1562().method_45730(invokedynamic(makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;, ExampleModInstance.INSTANCE.getMessage()));
            this.lastTime = System.currentTimeMillis();
        }
    }
    
    public long randomNumber(final long max, final long min) {
        return Math.round(min + (float)Math.random() * (max - min));
    }
}
