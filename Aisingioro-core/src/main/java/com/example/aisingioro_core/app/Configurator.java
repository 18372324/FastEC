package com.example.aisingioro_core.app;

import java.util.WeakHashMap;

/**
 * 存储和访问配置文件
 */
public class Configurator {
    private static final WeakHashMap<String, Object> AISINGIORO_CONFIGS = new WeakHashMap<>();

    private Configurator(){
        AISINGIORO_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }


    public final void configure(){
        AISINGIORO_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    //线程安全 + 懒汉模式
    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    final WeakHashMap<String, Object> getAisingioroConfigs(){
        return AISINGIORO_CONFIGS;
    }

    public final Configurator withApiHost(String host){
        AISINGIORO_CONFIGS.put(ConfigType.API_HOST.name(), host);
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
