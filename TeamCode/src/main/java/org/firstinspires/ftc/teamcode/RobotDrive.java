package org.firstinspires.ftc.teamcode;

public class RobotDrive
{

    /**
     * Method dedicated to moving the robot according to the controller input.
     *
     * @param opMode inherits the controller objects, used to receive input.
     * @param map of all the devices required by the move method.
     */
    public void updateControllerDrive(AntonOpMode opMode, DeviceMap map)
    {
        double right = opMode.gamepad1.right_stick_y;
        double left = opMode.gamepad1.left_stick_y;
        double linearSlide = opMode.gamepad2.left_stick_y;
        double intake = opMode.gamepad2.right_stick_y;

        move(map, left, right, linearSlide, intake);
    }

    /**
     * Moves the robot according to the joysticks on the controller.
     *
     * @param left joystick controls left wheel
     * @param right joystick controls right wheel
     * @param map is used to reference the motors
     */
    public void move(DeviceMap map, double left, double right, double linearSlide, double intake)
    {
        map.getLeftBack().setPower(-right * 1.5);
        map.getRightBack().setPower(-left * 1.5);

        map.getLinearSlide().setPower(linearSlide * 2);

        map.getIntake().setPower(intake);

        map.getLeftBack().setPower(0);
        map.getRightBack().setPower(0);

        map.getLinearSlide().setPower(0);
    }

}
