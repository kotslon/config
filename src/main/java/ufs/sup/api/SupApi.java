package ufs.sup.api;

import java.util.Map;
import java.util.function.Supplier;

public interface SupApi {
    void setContextProvider(Supplier<Map<String, String>> contextProvider);
    <T> Supplier<T> getValueSupplier(String parameterName);
}
