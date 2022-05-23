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
@Autonomous(name = "Anton", group = "Hand of Quandale")
public class AutoBotMode extends LinearOpMode
{

    DeviceMap map = new DeviceMap();

    private final ElapsedTime runtime = new ElapsedTime();

    public static final double FORWARD_SPEED = 0.6, TURN_SPEED = 0.5;

    @Override
    public void runOpMode()
    {
        map.init(hardwareMap);

        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        waitForStart();

        map.getLeftBack().setPower(FORWARD_SPEED);
        map.getRightBack().setPower(FORWARD_SPEED);
        runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 3.0))
        {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        map.getLeftBack().setPower(TURN_SPEED);
        map.getRightBack().setPower(-TURN_SPEED);
        runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 1.3))
        {
            telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        map.leftBack.setPower(-FORWARD_SPEED);
        map.rightBack.setPower(-FORWARD_SPEED);
        runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        map.leftBack.setPower(0);
        map.rightBack.setPower(0);

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }

}
