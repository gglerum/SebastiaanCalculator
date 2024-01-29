package nl.kuma.calculator.gui;

import java.awt.Font;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextField;

public final class CalculatorTextField extends JTextField {
  public CalculatorTextField() {
    setBounds(40, 25, 300, 50);
    setFont(new Font("Sans Serif", Font.PLAIN, 30));
    setEditable(false);
  }
  public void updateField(PropertyChangeEvent propertyChangeEvent) {
    setText((String) propertyChangeEvent.getNewValue());
  }
}
