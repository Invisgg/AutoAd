package net.fabricmc.example;

import net.minecraft.class_2561;
import net.minecraft.class_310;

public enum ExampleModInstance
{
    INSTANCE;
    
    private long delay;
    private String message;
    private boolean enabled;
    
    public void toggle() {
        if (this.message == null || this.message.isEmpty()) {
            class_310.method_1551().field_1705.method_1743().method_1812((class_2561)class_2561.method_43470("Ad message is empty!!!"));
            return;
        }
        this.enabled = !this.enabled;
        if (this.enabled && this.delay == 0L) {
            this.delay = 10000L;
        }
    }
    
    public long getDelay() {
        return this.delay;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public boolean isEnabled() {
        return this.enabled;
    }
    
    public void setDelay(final long delay) {
        this.delay = delay;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    private static /* synthetic */ ExampleModInstance[] $values() {
        return new ExampleModInstance[] { ExampleModInstance.INSTANCE };
    }
    
    static {
        $VALUES = $values();
    }
}
