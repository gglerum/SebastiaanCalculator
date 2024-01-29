package nl.kuma.calculator.calculator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NumPad {

  private final PropertyChangeSupport pcs =
      new PropertyChangeSupport(this);

  /**
   * Input is het getal wat op de rekenmachine zichtbaar is en momenteel aangevuld kan worden met
   * button inputs.
   */
  private String input = "";
  /**
   * currentValue is het getal wat de rekenmachine onthoudt nadat er een operator
   * knop is ingedrukt en waarop de berekening toepassing gaat hebben.
   */
  private String currentValue = "";
  /**
   * currentOperator wordt ingevuld wanneer er op de rekenmachine op de +, -, *, of / knop
   * wordt gedrukt.
   */
  private String currentOperator = "";

  /**
   * addPropertyChangeListener is een methode die wordt aangeroepen wanneer er een
   * PropertyChangeListener wordt toegevoegd aan de rekenmachine. De listener wordt
   * aangeroepen wanneer één van de properties van de rekenmachine verandert.
   *
   * @param listener
   */
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    pcs.addPropertyChangeListener(listener);
  }

  public String getInput() {
    return input;
  }

  public String getCurrentValue() {
    return currentValue;
  }

  public String getCurrentOperator() {
    return currentOperator;
  }

  public void setInput(String input) {
    pcs.firePropertyChange("input", this.input, input);
    this.input = input;
  }

  public void setCurrentValue(String currentValue) {
    pcs.firePropertyChange("value", this.currentValue, currentValue);
    this.currentValue = currentValue;
  }

  public void setCurrentOperator(String currentOperator) {
    this.currentOperator = currentOperator;
  }

  /**
   * inputDigit is de method die wordt aangeroepen wanneer er een knop op de rekenmachine wordt
   * ingedrukt met een getal of de komma erop.
   *
   * @param digit
   */
  public void inputDigit(String digit) {
    if (!digit.equals(".") || (digit.equals(".") && !input.contains("."))) {
      String newInput = input.concat(digit);
      pcs.firePropertyChange("input", input, newInput);
      input = newInput;
    }
  }

  /**
   * Backspace verwijdert de laatste digit in input wanneer de backspace knop op de rekenmachine
   * wordt ingedrukt
   */
  public void backspace() {
    if (input.isEmpty()) {

    } else {
      String newInput = input.substring(0, input.length() - 1);
      pcs.firePropertyChange("input", input, newInput);
      input = newInput;
    }
  }

}
