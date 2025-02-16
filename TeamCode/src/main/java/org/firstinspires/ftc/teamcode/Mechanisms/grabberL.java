package org.firstinspires.ftc.teamcode.Mechanisms;
import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class grabberL {
    private Servo grabberL;

    public grabberL(HardwareMap hardwareMap) {
        grabberL = hardwareMap.get(Servo.class, "grabberL");
    }

//close Low Grabber
    public class closeL implements Action {
       // private boolean initialized = false;
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
//            if (!initialized) {
//                grabberL.setPosition(0);
//                initialized = true;
//            }
            grabberL.setPosition(0);
            return false;
        }
    }

    public Action closeL() {
        return new closeL();
    }

//open Low Grabber
    public class openL implements Action {
      //  private boolean initialized = false;
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
//            if (!initialized) {
//                grabberL.setPosition(0.5);
//                initialized = true;
//            }
            grabberL.setPosition(0.5);
            return false;
        }
    }

    public Action openL() {
        return new openL();
    }
}