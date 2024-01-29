package nl.kuma.calculator.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ControllerTest {

  @Test
  void testEquals() {
    // test objecten maken
    Controller controller = Controller.getControllerInstance();

    // test waarden vaststellen en te testen method uitvoeren
    controller.getNumPad().setCurrentValue("22");
    controller.getNumPad().setCurrentOperator("+");
    controller.getNumPad().setInput("7");
    controller.equals();

    Assertions.assertEquals("29.0", controller.getNumPad().getCurrentValue());
    controller.cReset();

    controller.getNumPad().setCurrentValue("22");
    controller.getNumPad().setCurrentOperator("-");
    controller.getNumPad().setInput("7");
    controller.equals();

    Assertions.assertEquals("15.0", controller.getNumPad().getCurrentValue());
    controller.cReset();

    controller.getNumPad().setCurrentValue("22");
    controller.getNumPad().setCurrentOperator("*");
    controller.getNumPad().setInput("7");
    controller.equals();

    Assertions.assertEquals("154.0", controller.getNumPad().getCurrentValue());
    controller.cReset();

    controller.getNumPad().setCurrentValue("22");
    controller.getNumPad().setCurrentOperator("/");
    controller.getNumPad().setInput("2");
    controller.equals();

    Assertions.assertEquals("11.0", controller.getNumPad().getCurrentValue());
    controller.cReset();

    controller.getNumPad().setCurrentValue("22");
    controller.getNumPad().setInput("7");
    controller.equals();

    Assertions.assertEquals("7.0", controller.getNumPad().getCurrentValue());

  }

  @Test
  void testOperatorScenario1() {
    // In deze eerste test gaan we kijken wat er gebeurt als je herhaaldelijk op een operator knop
    // blijft drukken zonder extra input te geven
    Controller controller = Controller.getControllerInstance();

    controller.getNumPad().setInput("14");

    controller.selectOperator("+");
    controller.selectOperator("+");
    controller.selectOperator("+");
    controller.selectOperator("*");
    controller.selectOperator("-");

    // Omdat de selectOperator de input omzet naar currentValue als die leeg is verwachten we hier
    // een currentValue van 14
    Assertions.assertEquals("14", controller.getNumPad().getCurrentValue());
  }

  @Test
  void testOperatorScenario2() {
    // In deze test kijken we of je correct door kan rekenen met nieuwe input waardes zonder
    // tussendoor op '=' te hoeven drukken.
    Controller controller = Controller.getControllerInstance();

    controller.getNumPad().setInput("14");
    controller.selectOperator("+");
    controller.getNumPad().setInput("7");
    controller.selectOperator("+");
    controller.selectOperator("+");

    controller.selectOperator("+");
    controller.getNumPad().setInput("7");
    controller.selectOperator("+");
    controller.selectOperator("+");

    // Omdat we bij twee berekeningen een input van 7 meegeven en de rekenmachine de andere +
    // inputs zou moeten negeren verwachten we hier een antwoord van 28
    Assertions.assertEquals("28.0", controller.getNumPad().getCurrentValue());
  }

  @Test
  void testOperatorScenario3() {
    // Hier testen we of de equals methode de ingevoerde input en operator onthoudt en je zoals
    // in moderne calculator apps op '=' kan blijven drukken om de vorige berekening te blijven
    // herhalen
    Controller controller = Controller.getControllerInstance();

    controller.getNumPad().setInput("14");
    controller.selectOperator("+");
    controller.getNumPad().setInput("7");

    controller.equals();
    controller.equals();
    controller.equals();

    // Omdat we de berekening drie keer uitvoeren verwachten we hier een resultaat van 35
    Assertions.assertEquals("35.0", controller.getNumPad().getCurrentValue());
  }

  @Test
  void testCReset() {
    // test object maken
    Controller testController = Controller.getControllerInstance();

    // waardes aanmaken om cReset mee te testen
    testController.getNumPad().setInput("12345");
    testController.getNumPad().setCurrentValue("6789");
    testController.getNumPad().setCurrentOperator("+");

    // test cReset
    testController.cReset();

    // output van method vergelijken met verwachte resultaten
    Assertions.assertEquals("", testController.getNumPad().getInput());
    Assertions.assertEquals("", testController.getNumPad().getCurrentValue());
    Assertions.assertEquals("", testController.getNumPad().getCurrentOperator());
  }

}
