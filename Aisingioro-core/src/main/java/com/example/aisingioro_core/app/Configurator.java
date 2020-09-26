package com.example.aisingioro_core.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 存储和访问配置文件
 */
public class Configurator {
    private static final HashMap<String, Object> AISINGIORO_CONFIGS = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private Configurator(){
        AISINGIORO_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    private void initIcons(){
        if (ICONS.size() > 0){
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final void configure(){
        initIcons();
        AISINGIORO_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    //线程安全 + 懒汉模式
    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    final HashMap<String, Object> getAisingioroConfigs(){
        return AISINGIORO_CONFIGS;
    }

    public final Configurator withApiHost(String host){
        AISINGIORO_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    public final Configurator withIcon(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
        return this;
    }

    private void checkConfiguration(){
        final boolean isReady = (boolean) AISINGIORO_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if(!isReady){
            throw new RuntimeException("Configuration is not ready, call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key){
        checkConfiguration();
        return (T) AISINGIORO_CONFIGS.get(key);
    }

}
