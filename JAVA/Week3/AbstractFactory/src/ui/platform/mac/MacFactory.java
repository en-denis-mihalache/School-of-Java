package ui.platform.mac;
import ui.api.Button;
import ui.api.Checkbox;
import ui.api.GUIFactory;

public class MacFactory implements GUIFactory 
{
    public Button createButton()   { return new MacButton(); }
    public Checkbox createCheckbox(){ return new MacCheckbox(); }
}


