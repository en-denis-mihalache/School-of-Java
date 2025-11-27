package ui.app;

import ui.api.GUIFactory;
import ui.platform.windows.WindowsFactory;
import ui.platform.mac.MacFactory;
import ui.platform.linux.LinuxFactory;

public class Demo {

    private static GUIFactory configureFactory(String os) {
        switch (os.toLowerCase()) {
            case "windows":
                return new WindowsFactory();
            case "mac":
                return new MacFactory();
            case "linux":
                return new LinuxFactory();
            default:
                throw new IllegalArgumentException("Platforma necunoscută: " + os);
        }
    }

    public static void main(String[] args) {
        GUIFactory factory = configureFactory("linux"); 
        Application app = new Application(factory);
        app.render();
    }
}
