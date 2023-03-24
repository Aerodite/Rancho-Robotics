package experimental;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

@SuppressWarnings("deprecation")

public class movement extends Robot
{
    DifferentialDrive   robotDrive;
    Talon               motorLeft, motorRight;
    Joystick            stick;

    /**
     * Constructor. Called once when this class is created.
     */
    public movement()
    {
        System.out.println("Robot.constructor()");
    }

    /**
     * Called once after class load complete.
     * Use to perform any needed initializations.
     * Very similar to the constructor.
     */
    public void movementInit()
    {
        System.out.println("Movement.movementInit()");

        // Create two PWM Talon motor controller objects for left & right motors on PWM ports 0 & 1.
        // Assumes robot has two motors controlled by Talon controllers connected via PWM.
        // Add them to a drive controller class that can do tank and arcade driving based on
        // joystick input.

        motorLeft = new Talon(0);
        motorRight = new Talon(1);

        robotDrive = new DifferentialDrive(motorLeft, motorRight);

        robotDrive.setExpiration(0.1);   // need to see motor input at least every
        // 10th of a second or stop motors.

        // One side has motors reversed so the wheels turn in the same direction.
        robotDrive.setRightSideInverted(false);

        stick = new Joystick(0);         // joystick on usb port 0.
    }

    /**
     * Executes a simple autonomous program.
     * Called by the driver station or field control system at the
     * start of the autonomous period.
     */
    public void autonomous()
    {
        System.out.println("Robot.autonomous()");

        robotDrive.setSafetyEnabled(false);     // motor safety off due to the fact
        // we want the motor to run 2 sec
        // with no other input.

        robotDrive.tankDrive(0.5, 0.5);         // drive forwards half speed
        Timer.delay(2.0);                       //    for 2 seconds.
        robotDrive.tankDrive(0.0, 0.0);         // stop motors.
    }

    /**
     * Runs the motors with arcade steering, input from joystick.
     * Called by the driver station or field control system at the
     * start of the operator control (teleop) period. Runs in a loop
     * until robot is disabled.
     */
    public void operatorControl()
    {
        System.out.println("Robot.operatorControl()");

        robotDrive.setSafetyEnabled(true);   // motor safety back on.

        while (isOperatorControl() && isEnabled())
        {
            robotDrive.arcadeDrive(stick.getX(), stick.getY());   // drive with arcade style.

            Timer.delay(0.020);             // wait for a joystick update.
        }
    }

    /**
     * Called whenever the robot is disabled by the DS or field control.
     * Use to perform any needed resets or changes when switching between modes.
     */
    public void disabled()
    {
        System.out.println("Robot.disabled()");
    }

    /**
     * Runs during test mode
     */
    public void test()
    {
        System.out.println("Robot.test()");
    }
}