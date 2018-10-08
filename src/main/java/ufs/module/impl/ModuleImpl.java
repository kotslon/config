package ufs.module.impl;

import ufs.module.api.ModuleApi;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModuleImpl implements ModuleApi {

    private Function<String, Supplier<? extends Object>> configProvider;

    @Override
    public void setConfigProvider(Function<String, Supplier<? extends Object>> configProvider) {
        this.configProvider = configProvider;
    }

    @Override
    public void doSomething() {
        Supplier<String> param1 = (Supplier<String>) configProvider.apply("my.param1.name");
        Supplier<Integer> param2 = (Supplier<Integer>) configProvider.apply("my.param2.name");
        System.out.println("Got param1:" + param1.get());
        System.out.println("Got param2:" + param2.get());
        // something useful
    }
}
