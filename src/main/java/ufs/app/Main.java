package ufs.app;

import ufs.module.api.ModuleApi;
import ufs.module.impl.ModuleImpl;
import ufs.sup.api.SupApi;
import ufs.sup.impl.SupImpl;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        SupApi sup = new SupImpl();
        sup.setContextProvider(
                ()-> new HashMap<String, String>() {{
                    put("subsystem", "MySystem");
                    put("channel", "MY_CHANNEL");
        }});
        ModuleApi module = new ModuleImpl();
        module.setConfigProvider(sup::getValueSupplier);

        module.doSomething();
    }
}
