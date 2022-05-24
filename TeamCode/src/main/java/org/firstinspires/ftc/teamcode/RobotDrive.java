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
        double left = opMode.gamepad1.right_stick_y;
        double right = opMode.gamepad1.left_stick_y;
        double carouselWheel = 0;
        double linearSlide = 0;
        double intake = 0;

        if (opMode.gamepad1.left_bumper) linearSlide = -1;
        else if (opMode.gamepad1.left_trigger > 0) linearSlide = 1;

        if (opMode.gamepad1.right_bumper) intake = 1;
        else if (opMode.gamepad1.right_trigger > 0) intake = -1;

        if (opMode.gamepad1.a) carouselWheel = 1;
        if (opMode.gamepad1.b) carouselWheel = -1;


        move(map, left, right, linearSlide, intake, carouselWheel);
    }

    /**
     * Moves the robot according to the joysticks on the controller.
     *
     * @param left joystick controls left wheel
     * @param right joystick controls right wheel
     * @param map is used to reference the motors
     */
    public void move(DeviceMap map, double left, double right, double linearSlide, double intake, double carouselWheel)
    {
        map.getLeftBack().setPower(right * 1.5);
        map.getRightBack().setPower(left * 1.5);

        map.getLinearSlide().setPower(linearSlide);
        map.getCarouselWheel().setPower(carouselWheel);

        map.getIntake().setPower(intake);

        //

        map.getLeftBack().setPower(0);
        map.getRightBack().setPower(0);

        map.getLinearSlide().setPower(0);
        map.getCarouselWheel().setPower(0);
    }

}
