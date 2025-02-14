package org.firstinspires.ftc.teamcode.IntoTheDeep;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="IntoTheDeepTeleopV2", group="TeleOp")
public class IntoTheDeepTeleopV2 extends OpMode {

    // Drive motors for the GoBilda Straffer Chassis (Mecanum Drive)
    private DcMotor leftFront, leftRear, rightFront, rightRear;

    // Motor for the vertical slides
    private DcMotorEx slideUp;

    // Servos to control the axle rotating both grabbers and grabbing
    private Servo grabberH, grabberL, rotatorH, rotatorL;

    private Servo LfrontSlide;
    //private Servo RfrontSlide;

    //SlideUp Booleans
    boolean slideUpExtend = false;
    boolean slideUpRetract = false;

    //Positions for buckets
    private int highBucket = 2000;
    private int lowBucket = 1000;

    //FrontSlidePosition boolean
    boolean frontSlidePosition = false;

    private ElapsedTime runTime1 = new ElapsedTime();
    private boolean waiting1 = false;
    private double waitStartTime1 = 0;
    private ElapsedTime runTime2 = new ElapsedTime();
    private boolean waiting2 = false;
    private double waitStartTime2 = 0;
    private boolean servoStarted = false;

    @Override
    public void init() {
        // Initialize the drive motors for the GoBilda Straffer Chassis
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftRear = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightRear = hardwareMap.get(DcMotor.class, "rightBack");

        //Intialize the front slide servos
        LfrontSlide = hardwareMap.get(Servo.class, "LfrontSlide");

        // Initialize the vertical slide motors
        slideUp = hardwareMap.get(DcMotorEx.class, "slideUp");

        // Initialize the grabber servo
        grabberH = hardwareMap.get(Servo.class, "grabberH");
        grabberL = hardwareMap.get(Servo.class, "grabberL");
        // Initialize the rotator servo
        rotatorL = hardwareMap.get(Servo.class, "RotatorL");
        rotatorH = hardwareMap.get(Servo.class, "RotatorH");

        //Reset Motor Encoders
        slideUp.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slideUp.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Set motor directions (ensure motors are driving in correct direction)
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftRear.setDirection(DcMotor.Direction.REVERSE);

        slideUp.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Initial servo position (grabbers close by default and rotator in the middle)
        grabberH.setPosition(0.002);
        grabberL.setPosition(-0.45);
        rotatorH.setPosition(0);
        rotatorL.setPosition(0);

        //Initial front slide position
        LfrontSlide.setPosition(0);
        //RfrontSlide.setPosition(1);
    }
    @Override
    public void loop() {
        // Mecanum Drive control (for strafing, forward, backward, and rotation)
        double drive = gamepad1.left_stick_y;  // Forward and backward movement
        double strafe = gamepad1.left_stick_x;  // Strafe left and right
        double rotate = gamepad1.right_stick_x; // Rotation control

        // Calculate power for each motor using mecanum kinematics
        double leftFrontPower = drive + strafe + rotate;
        double leftRearPower = drive - strafe + rotate;
        double rightFrontPower = drive - strafe - rotate;
        double rightRearPower = drive + strafe - rotate;

        //Front slide is not extended
        double startTime = runTime1.seconds();

        // Apply powers to the motors
        leftFront.setPower(leftFrontPower);
        leftRear.setPower(leftRearPower);
        rightFront.setPower(rightFrontPower);
        rightRear.setPower(rightRearPower);

        // Vertical slide control using the triggers
       /* boolean currentSlidePos = gamepad1.right_trigger > 0.1;
        if (currentSlidePos && slideUpRetract) {
            slideUpExtend = !slideUpExtend;

            if (slideUpExtend) {
                int currentSlidePosition = slideUp.getCurrentPosition();
                slideUp.setTargetPosition(currentSlidePosition + lowBucket); // Adjust the step size as needed)
                if (slideUp.getCurrentPosition() < 3415);
                slideUp.setPower(1);
            } else slideUp.setPower(0.0025);
            slideUpRetract = currentSlidePos;
        }
        */

        /*if (gamepad1.right_trigger > 0.1 && slideUp.getCurrentPosition() > 100) {
             int currentSlidePosition = slideUp.getCurrentPosition();
            slideUp.setTargetPosition(currentSlidePosition + highBucket); // Adjust the step size as needed)
             if (slideUp.getCurrentPosition() < 3415);
             slideUp.setPower(1);
         } else slideUp.setPower(0.0025); */

            /*if (gamepad1.right_trigger > 0.1 && slideUp.getCurrentPosition() < 50) {
                int currentSlidePosition = slideUp.getCurrentPosition();
                slideUp.setTargetPosition(currentSlidePosition + 3415); // Adjust the step size as needed)
                if (slideUp.getCurrentPosition() < -10) ;
                slideUp.setPower(-1);
            } else slideUp.setPower(0.0005);
*/
       /* if (gamepad1.right_trigger > 0.1 && slideUp.getCurrentPosition() < 50) {
            int currentSlidePosition = slideUp.getCurrentPosition();
            slideUp.setTargetPosition(currentSlidePosition + 3415);
            if (slideUp.getCurrentPosition() > 3415)
                slideUp.setPower(0);
        } else slideUp.setPower(0.0005);
*/

       /* if (gamepad1.right_trigger < 0.1){
            slideUp.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            slideUp.setPower(1);
        }

        if (gamepad1.left_trigger < 0.1){
            slideUp.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            slideUp.setPower(-1);
        }
*/
           if (gamepad1.right_trigger > 0.1) {
           slideUp.setPower(1);
            int currentSlidePosition = slideUp.getCurrentPosition();
            slideUp.setTargetPosition(currentSlidePosition + 3415); // Adjust the step size as needed);
            slideUp.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            if (slideUp.getCurrentPosition() < 3415)
                slideUp.setPower(1);
        } else if (gamepad1.left_trigger > 0.1) {
           slideUp.setPower(-1);
            int currentSlidePosition = slideUp.getCurrentPosition();
            slideUp.setTargetPosition(currentSlidePosition - 3415); // Adjust the step size as needed);
            slideUp.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            if (slideUp.getCurrentPosition() > -10)
                slideUp.setPower(-1);
        } else slideUp.setPower(0.0005);


            // Lower part of robot
            if (gamepad1.right_bumper) {
                // Close grabberL
                grabberL.setPosition(0);
            } else if (gamepad1.left_bumper) {
                // Open grabberL
                grabberL.setPosition(0.5);
            }
            // Rotate grabbers to a specific angle (middle position)

              if (gamepad1.cross){
                  //RfrontSlide.setPosition(0.5);
                  LfrontSlide.setPosition(0.30);
                  rotatorL.setPosition(0.67);
              }

        if (gamepad1.circle && !waiting1 && !waiting2) {
            rotatorL.setPosition(0.30);
            waiting2 = true;
            waitStartTime2 = runTime2.seconds();
        }
        if (waiting2 && (runTime2.seconds() - waitStartTime2 >= 0.25)) {
            LfrontSlide.setPosition(0.03);
            //RfrontSlide.setPosition(0.95);
            grabberH.setPosition(0.5);
            waiting2 = false;
            waiting1 = true;
            waitStartTime1 = runTime1.seconds();
        }
        if (waiting1 && (runTime1.seconds() - waitStartTime1 >= 1.5)) {
            grabberH.setPosition(0);
            grabberL.setPosition(0.5);
            waiting1 = false;
        }
           /* if (gamepad1.circle) {
                LfrontSlide.setPosition(LfrontSlide.getPosition() - 0.8);
                rotatorL.setPosition(0.6);
                //rotatorL.setDirection(REVERSE);
                //rotatorL.setPosition(0.2);

                LfrontSlide.setPosition(0.5);
            }
*/
            //Specimen Stuffs
            if(gamepad1.square){
                rotatorH.setPosition(0.75);
            }

            // Grabber High
            if (gamepad1.triangle) {
                // open grabberH
                grabberH.setPosition(0.5);
            /*else if (gamepad1.square) {
                // close grabbers
                grabberH.setPosition(0);
            }*/
            }else if (gamepad1.right_stick_button) {
                // go back to init
                rotatorH.setPosition(0);
            } else if (gamepad1.left_stick_button) {
                // rotate up
                rotatorH.setPosition(0.7);
            }


            // Display telemetry data
            telemetry.addData("slideUp Position", slideUp.getCurrentPosition());
            telemetry.addData("Drive Power", "LF: " + leftFrontPower + " RF: " + rightFrontPower);
            telemetry.addData("Slide Power", "Slide Up: " + slideUp.getPower());
            telemetry.addData("Grabber Position", grabberH.getPosition());
            telemetry.update();
        }

        @Override
        public void stop () {
            // Stop all motors when the opmode is stopped
            leftFront.setPower(0);
            leftRear.setPower(0);
            rightFront.setPower(0);
            rightRear.setPower(0);

            slideUp.setPower(0);

            grabberH.setPosition(0); // Default grabber position
            rotatorH.setPosition(0);

            // Default front slide position
            //RfrontSlide.setPosition(1);
            LfrontSlide.setPosition(0);
        }
    }


