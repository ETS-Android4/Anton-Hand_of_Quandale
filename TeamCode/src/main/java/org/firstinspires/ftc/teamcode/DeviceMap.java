package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Summary:
 * What is the device map?
 *
 * The Device Map stores all of the physical
 * devices within the physical robot, and defines
 * them as code. This device map can then be used
 * as a dictionary/backpack, that you can open
 * and use the devices inside of it.
 * -----------------------------------------------
 * The Devices themselves:
 * How are the physical devices actually mapped
 * (defined, put, created) inside of the device map?
 * All devices, are types of objects. And all objects
 * are just classes that can be declared and instantiated.
 *
 * When defining and creating an object in Java,
 * there are 2 different steps:
 * 1) Declaration - declaring an object is the process
 *    of stating that an object will exists, and what type
 *    of object it is. You can think of it as the blueprints
 *    of what the object is going to be, since declaring
 *    it doesn't mean you are creating it.
 *
 *    Ex: public DcMotor motor.
 *    Within the example stated above, there are
 *    three key terms- "public", "DcMotor", "motor".
 *
 *    The first term (public) is optional. It simply
 *    states whether the object you are declaring is
 *    accessible from outside of the class it resides
 *    in. It can be replaced with "private", in which
 *    case it would be inaccessible from outside the
 *    class.
 *
 *    The second term (DcMotor) is the object type.
 *    This states what the object you are creating
 *    actually is. In this case, the DcMotor is
 *    representing a physical Dc Motor. If it were
 *    representing a Servo, we would replace "DcMotor"
 *    with the word "Servo".
 *
 *    The third term (motor) is the name. The name
 *    must not contain any spaces, and it is the
 *    name that we will use to reference/use the
 *    object. If we want to modify the object, we
 *    will refer to it as "motor", not "DcMotor".
 *    However, the name can be whatever you prefer.
 *    The only constraint is that it must not contain
 *    spaces, or special symbols such as "%" or "$".
 *
 * 2) Instantiation - instantiating an object is
 *    when we actually create the object. It's called
 *    instantiation, because we are creating an instance
 *    of the object. The instance, is the object
 *    that we can manipulate, and use.
 *
 * In a nutshell, we map devices within the device
 * map by first declaring, and then instantiating.
 */
public class DeviceMap
{

    // Declarations

    // wheels
    public DcMotor leftBack = null;
    public DcMotor rightBack = null;

    public DcMotor linearSlide = null;
    public DcMotor carouselWheel = null;

    // misc
    public CRServo intake = null;
    public DistanceSensor distanceSensor;

    /**
     * This is a constructor. A constructor
     * is made by saying: public ClassName() {}
     * The "DeviceMap" part in the constructor
     * must mach the class name.
     *
     * Code would normally be inside of the two
     * brackets ({}), but in this case there is none.
     * This means that the constructor doesn't actually
     * do anything.
     *
     * The constructor itself is a method that is called
     * when the class is first instantiated.
     */
    public DeviceMap() {}

    /**
     * Init is short for initialization. This method
     * is invoked (called) from the {@link AntonOpMode}.
     *
     * Tip: if you want to see where a method is called from
     * in the code, hold command (MacOS0) or control (Windows)
     * and then left click the name of the method.
     *
     * Other info: a method is when it's a "void".
     *
     * @param map passes in the hardware map, that
     *            is used to index all of the declared
     *            devices into the robot.
     */
    public void init(HardwareMap map)
    {
        leftBack = map.get(DcMotor.class, "left_back");
        rightBack = map.get(DcMotor.class, "right_back");
        linearSlide = map.get(DcMotor.class, "linear_slide");
        carouselWheel = map.get(DcMotor.class, "carousel_wheel");

        leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        linearSlide.setDirection(DcMotorSimple.Direction.FORWARD);
        carouselWheel.setDirection(DcMotorSimple.Direction.FORWARD);


        leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        linearSlide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        carouselWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        intake = map.get(CRServo.class, "intake");
    }

    // Getters

    public DcMotor getLeftBack()
    {
        return leftBack;
    }

    public DcMotor getRightBack()
    {
        return rightBack;
    }

    public DcMotor getLinearSlide()
    {
        return linearSlide;
    }

    public CRServo getIntake()
    {
        return intake;
    }

}
