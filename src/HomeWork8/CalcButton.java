package HomeWork8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CalcButton extends JButton {
    private String name;

    @Override
    public String getName() {
        return name;
    }

    CalcButton(String s) {
        super(s);
        this.name = s;
        setFont(new Font("Arial", Font.BOLD, 20));
        this.setBackground(new Color(0xFBFBFD));
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("=") || s.equals("C") || s.equals("÷")) {
            this.setBackground(new Color(0xB1E7E7));
        }

    }

}
