package nl.kuma.calculator.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import nl.kuma.calculator.calculator.Controller;

public final class CalculatorButton extends JButton {
  public CalculatorButton(String text) {
    super(text);

    setFont(new Font("Sans Serif", Font.PLAIN, 30));
    setFocusable(false);
  }
}
