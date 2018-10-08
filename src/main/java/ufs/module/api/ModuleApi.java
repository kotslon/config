package ufs.module.api;

import java.util.function.Function;
import java.util.function.Supplier;

public interface ModuleApi {
    void setConfigProvider(Function<String, Supplier<? extends Object>> configProvider);
    void doSomething();
}
