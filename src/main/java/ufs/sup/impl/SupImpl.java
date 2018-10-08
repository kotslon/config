package ufs.sup.impl;

import ufs.sup.api.SupApi;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SupImpl implements SupApi {

    private Supplier<Map<String, String>> contextProvider;

    private HashMap<String, Object> source = new HashMap<String, Object>() {{
        put("channel=MY_CHANNEL|subsystem=MySystem|my.param1.name", "StringValue");
        put("channel=MY_CHANNEL|subsystem=MySystem|my.param2.name", 42);
    }};

    @Override
    public void setContextProvider(Supplier<Map<String, String>> contextProvider) {
        this.contextProvider = contextProvider;
    }

    @Override
    public <T> Supplier<T> getValueSupplier(String parameterName) {
        Supplier<T> result = null;
        System.out.println("Looking for " + parameterName + " in context " + contextProvider.get());
        String key = contextProvider.get().entrySet().stream()
                                    .map(e -> e.getKey() + "=" + e.getValue())
                                    .collect(Collectors.joining("|"))
                + "|" + parameterName;
        return ()-> (T) source.get(key);
    }
}
