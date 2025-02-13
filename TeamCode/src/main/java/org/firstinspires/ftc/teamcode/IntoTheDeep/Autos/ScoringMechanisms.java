package org.firstinspires.ftc.teamcode.IntoTheDeep.Autos;
import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;

@Config
@Autonomous(name = "BlueBox", group = "Autonomous")
public abstract class ScoringMechanisms extends LinearOpMode {
    // slideUp class
    private DcMotorEx slideUp;
    public class Slide {


        public Slide(HardwareMap hardwareMap) {
            slideUp = hardwareMap.get(DcMotorEx.class, "liftMotor");
            slideUp.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            slideUp.setDirection(DcMotorSimple.Direction.FORWARD);
        }
    }

    // claw class
    public class Claw {
        private Servo claw;

        public Claw(HardwareMap hardwareMap) {
            claw = hardwareMap.get(Servo.class, "claw");
        }
    }
    public class LiftUp implements Action {
        // checks if the slideUp motor has been powered on
        private boolean initialized = false;

        // actions are formatted via telemetry packets as below
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            // powers on motor, if it is not on
            if (!initialized) {
                slideUp.setPower(0.8);
                initialized = true;
            }

            // checks slideUp's current position
            double pos = slideUp.getCurrentPosition();
            packet.put("liftPos", pos);
            if (pos < 3000.0) {
                // true causes the action to rerun
                return true;
            } else {
                // false stops action rerun
                slideUp.setPower(0);
                return false;
            }
            // overall, the action powers the slideUp until it surpasses
            // 3000 encoder ticks, then powers it off
        }
    }
    public Action liftUp() {
        return new LiftUp();
    }

    void SequentialAction(

    );


}