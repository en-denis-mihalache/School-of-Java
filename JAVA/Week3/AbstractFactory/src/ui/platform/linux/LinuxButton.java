package ui.platform.linux;
import ui.api.Button;

public class LinuxButton implements Button {
    @Override
    public void paint() { System.out.println("Linux button..."); }
}
