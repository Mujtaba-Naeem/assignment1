public class CarTest {
    private static void reportResult(String testName, boolean success) {
        IO.println((success ? "SUCCESS: " : "FAILURE: ") + testName);
    }

    /** Tests whether a Saab95 with turbo enabled
     *  gains more speed than one without.
     */
    private static void testTurbo() {
        Saab95 slowSaab = new Saab95();
        Saab95 fastSaab = new Saab95();
        fastSaab.setTurboOn();
        slowSaab.setTurboOff();
        fastSaab.gas(0.5);
        slowSaab.gas(0.5);
        boolean result = slowSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();
        reportResult("Turbo yields more speed", result);
    }

    //Test 2 : Engine starts
    private static void testEngine() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        boolean result = volvo.getCurrentSpeed() == 0.1;
        reportResult("Engine starts correctly", result);
    }

    //Test 3 : Testing if Engine stops correctly
    private static void testStopEngine() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.stopEngine();
        boolean result = volvo.getCurrentSpeed() == 0;
        reportResult("Engine stops correctly", result);

    }

    // Test 4 : Testing if Gas increases speed
    private static void testGas() {
        Volvo240 volvo = new Volvo240();
        volvo.gas(0.5);
        boolean result = volvo.getCurrentSpeed() > 0 ;
        reportResult("Gas increases speed", result);
    }

    // Test 5 : Testing if break decreases speed
    private static void testBrake() {
        Volvo240 volvo = new Volvo240();
        volvo.gas(0.5);
        double previousSpeed = volvo.getCurrentSpeed();
        volvo.brake(0.2);
        boolean result = volvo.getCurrentSpeed() < previousSpeed;
        reportResult("Brake decreases speed", result);
    }

    // Test 6 : Movement
    private static void testMoveNorth() {
        Saab95 saab = new Saab95();
        saab.startEngine();
        saab.move();
        boolean result = saab.getY() > 0 && saab.getX() == 0;
        reportResult("Saab moves north correctly", result);
    }

    static void main() {
        testMoveNorth();
        testBrake();
        testGas();
        testStopEngine();
        testStopEngine();
        testTurbo();
        testEngine();

        //TODO: add and run more tests
    }
}
