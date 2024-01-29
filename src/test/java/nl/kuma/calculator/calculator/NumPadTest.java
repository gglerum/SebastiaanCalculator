package nl.kuma.calculator.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumPadTest {

  @Test
  void testDigitInput() {
    // test object maken
    NumPad testNumPad = new NumPad();

    // toepassen van de inputDigit methode om te testen
    testNumPad.inputDigit("1");
    testNumPad.inputDigit("2");
    testNumPad.inputDigit("3");

    // output van de methode vergelijken met verwachte resultaat
    Assertions.assertEquals("123", testNumPad.getInput());
  }

  @Test
  void testBackspace() {
    // test object maken
    NumPad testNumPad = new NumPad();

    // Maak eerst een input met inputDigit en pas daarna backspace method toe om te testen
    testNumPad.inputDigit("1");
    testNumPad.inputDigit("2");
    testNumPad.inputDigit("3");
    testNumPad.inputDigit("4");
    testNumPad.inputDigit("5");

    testNumPad.backspace();
    testNumPad.backspace();

    // output van methods vergelijken met verwachte resultaat
    Assertions.assertEquals("123", testNumPad.getInput());
  }

  @Test
  void testDecimal() {
    NumPad testNumPad = new NumPad();

    testNumPad.inputDigit("1");
    testNumPad.inputDigit("2");
    testNumPad.inputDigit("3");
    testNumPad.inputDigit(".");
    testNumPad.inputDigit("5");
    testNumPad.inputDigit(".");
    testNumPad.inputDigit("5");

    Assertions.assertEquals("123.55", testNumPad.getInput());
  }

}
