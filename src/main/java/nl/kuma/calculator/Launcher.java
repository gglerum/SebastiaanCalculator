package nl.kuma.calculator;

import javax.swing.SwingUtilities;
import nl.kuma.calculator.gui.CalculatorWindow;

public class Launcher {

  public static void main(String[] args) {

    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        CalculatorWindow main = new CalculatorWindow();
      }
    });

  }

}
