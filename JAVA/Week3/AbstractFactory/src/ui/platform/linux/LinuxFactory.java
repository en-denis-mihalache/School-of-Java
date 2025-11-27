package ui.platform.linux;
import ui.api.Button;
import ui.api.Checkbox;
import ui.api.GUIFactory;

public class LinuxFactory implements GUIFactory {
    public Button createButton()   { return new LinuxButton(); }
    public Checkbox createCheckbox() { return new LinuxCheckbox(); }
}
