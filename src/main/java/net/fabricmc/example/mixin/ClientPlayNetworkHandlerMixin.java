package net.fabricmc.example.mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import net.fabricmc.example.ExampleModInstance;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.class_634;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({ class_634.class })
public class ClientPlayNetworkHandlerMixin
{
    @Inject(method = { "sendChatMessage" }, at = { @At("HEAD") }, cancellable = true)
    public void sendChatMessage(final String context, final CallbackInfo info) {
        if (context.startsWith("-delay")) {
            final String[] args = context.split(" ");
            info.cancel();
            if (args.length == 0) {
                return;
            }
            final long delay = Long.parseLong(args[1]);
            class_310.method_1551().field_1705.method_1743().method_1812((class_2561)class_2561.method_43470(invokedynamic(makeConcatWithConstants:(J)Ljava/lang/String;, delay)));
            ExampleModInstance.INSTANCE.setDelay(delay);
        }
        else if (context.equals("-toggle")) {
            info.cancel();
            ExampleModInstance.INSTANCE.toggle();
        }
        else if (context.startsWith("-set")) {
            info.cancel();
            final String[] args = context.split(" ");
            final String[] newArgs = context.substring(args[0].length()).trim().split(" ");
            if (newArgs.length == 0) {
                return;
            }
            final StringBuilder message = new StringBuilder();
            for (final String msg : newArgs) {
                message.append(msg).append(" ");
            }
            class_310.method_1551().field_1705.method_1743().method_1812((class_2561)class_2561.method_43470(invokedynamic(makeConcatWithConstants:(Ljava/lang/StringBuilder;)Ljava/lang/String;, message)));
            ExampleModInstance.INSTANCE.setMessage(message.toString());
        }
    }
    
    private String[] removeFirstArgument(final String[] args) {
        final String[] newArgs = new String[args.length - 1];
        System.arraycopy(args, 1, newArgs, 0, args.length - 1);
        return newArgs;
    }
}
