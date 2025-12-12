package ui.platform.windows;
import ui.api.Button;
import ui.api.Checkbox;
import ui.api.GUIFactory;

public class WindowsFactory implements GUIFactory {
    public Button createButton()   { return new WindowsButton(); }
    public Checkbox createCheckbox(){ return new WindowsCheckbox(); }
}
