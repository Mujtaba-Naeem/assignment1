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


// Task 4 :-------------------------------------------------------------------

    // TASK 4: SANITY CHECKS

    // 1. Gas and brake accept only values between 0 and 1

    private static void gasAndBreak() {
        Volvo240 gasCar = new Volvo240();
        gasCar.startEngine();
        double oldSpeed = gasCar.getCurrentSpeed();
        gasCar.gas(-0.5);
        boolean negativeGas = gasCar.getCurrentSpeed() == oldSpeed;
        gasCar.gas(1.5);
        boolean highGas = gasCar.getCurrentSpeed() == oldSpeed;

        Volvo240 brakeCar = new Volvo240();
        brakeCar.startEngine();
        oldSpeed = brakeCar.getCurrentSpeed();
        brakeCar.brake(-0.5);
        boolean negativeBrake = brakeCar.getCurrentSpeed() == oldSpeed;
        brakeCar.brake(1.5);
        boolean highBrake = brakeCar.getCurrentSpeed() == oldSpeed;
        boolean result = negativeGas && highGas && negativeBrake && highBrake;
        reportResult("Gas and brake reject invalid values", result);
    }


    // 2. Current speed stays between 0 and enginePower

    private static void speedLimit() {
        Volvo240 myVolvo = new Volvo240();
        myVolvo.startEngine();
        for (int i = 0; i < 200; i++) {
            myVolvo.gas(1);
        }
        boolean maxSpeed = myVolvo.getCurrentSpeed()
                <= myVolvo.getEnginePower();
        for (int i = 0; i < 200; i++) {
            myVolvo.brake(1);
        }
        boolean minSpeed = myVolvo.getCurrentSpeed() >= 0;
        reportResult("Speed stays within limits", maxSpeed && minSpeed);
    }


    // 3. Gas cannot decrease speed

    private static void gasNotDecreaseSpeed() {
        Volvo240 myVolvo = new Volvo240();
        myVolvo.startEngine();
        double oldSpeed = myVolvo.getCurrentSpeed();
        myVolvo.gas(1);
        boolean result = myVolvo.getCurrentSpeed() >= oldSpeed;
        reportResult("Gas cannot decrease speed", result);
    }


    // 4. Brake cannot increase speed

    private static void brakeNotIncreaseSpeed() {
        Volvo240 myVolvo = new Volvo240();
        myVolvo.startEngine();
        myVolvo.gas(1);
        double oldSpeed = myVolvo.getCurrentSpeed();
        myVolvo.brake(1);
        boolean result = myVolvo.getCurrentSpeed() <= oldSpeed;
        reportResult("Brake cannot increase speed", result);
    }


    static void main() {
        testMoveNorth();
        testBrake();
        testGas();
        testStopEngine();
        testStopEngine();
        testTurbo();
        testEngine();

        // Task 4:
        gasAndBreak();
        speedLimit();
        gasNotDecreaseSpeed();
        brakeNotIncreaseSpeed();
        //TODO: add and run more tests
    }
}
