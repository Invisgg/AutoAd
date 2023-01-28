package net.fabricmc.example;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import net.fabricmc.api.ModInitializer;

public class ExampleMod implements ModInitializer
{
    public static final Logger LOGGER;
    
    public void onInitialize() {
    }
    
    static {
        LOGGER = LoggerFactory.getLogger("modid");
    }
}
