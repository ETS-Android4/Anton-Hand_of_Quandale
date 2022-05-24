package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * The AutoBotMode is the autonomous class of Vegan Free.
 *
 * Extends to LinearOpMode.class which is a different version
 * of OpMode.class
 */
@Autonomous(name = "AutoAntonBlue", group = "Hand of Quandale")
public class AutoBotModeB extends LinearOpMode
{

    DeviceMap map = new DeviceMap();

    private final ElapsedTime runtime = new ElapsedTime();

    public static final double FORWARD_SPEED = -1, TURN_SPEED = 0.35;

    @Override
    public void runOpMode()
    {
        map.init(hardwareMap);

        map.getLinearSlide().setPower(0);

        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        waitForStart();

        map.getLeftBack().setPower(FORWARD_SPEED);
        map.getRightBack().setPower(FORWARD_SPEED);
        runtime.reset();
//forward .t red is right blue is left for turning IMPORTANT
        while (opModeIsActive() && (runtime.seconds() < 1))
        {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        map.getLeftBack().setPower(0);
        map.getRightBack().setPower(0);

        map.getLinearSlide().setPower(-.9);
        runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 0.35))
        {
            telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        map.getLinearSlide().setPower(-.05);

        map.getIntake().setPower(1);
        runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 4.3)) {
            telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        map.getIntake().setPower(0);
        map.getLeftBack().setPower(-FORWARD_SPEED);
        map.getRightBack().setPower(-FORWARD_SPEED);
        runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 0.3))
        {
            telemetry.addData("Path", "Leg: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        map.getLeftBack().setPower(0);
        map.getRightBack().setPower(0);

        map.getLeftBack().setPower(TURN_SPEED);
        map.getRightBack().setPower(-TURN_SPEED);
        runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 1.3))
        {
            telemetry.addData("Path", "Leg: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        map.getLeftBack().setPower(0);
        map.getRightBack().setPower(0);

        map.getLeftBack().setPower(FORWARD_SPEED);
        map.getRightBack().setPower(FORWARD_SPEED);

        while (opModeIsActive() && (runtime.seconds() < 2.83))
        {
            telemetry.addData("Path", "Leg: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        map.leftBack.setPower(0);
        map.rightBack.setPower(0);
        map.getLinearSlide().setPower(0);
        map.getIntake().setPower(0);

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }

}
