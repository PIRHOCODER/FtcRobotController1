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

public class RotatorH {
    private Servo RotatorH;

    public RotatorH(HardwareMap hardwareMap) {
        RotatorH = hardwareMap.get(Servo.class, "RotatorH");
    }

//High Rotator rotate up
    public class Hup implements Action {
        //private boolean initialized = false;
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
//            if (!initialized) {
//                RotatorH.setPosition(0.7);
//                initialized = true;
//            }
            RotatorH.setPosition(0.7);
            return false;
        }
    }
    public Action Hup() {
        return new Hup();
    }

//High Rotator rotate down
    public class Dogh implements Action {
       // private boolean initialized = false;
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
//            if (!initialized) {
//                RotatorH.setPosition(0);
//                initialized = true;
//            }
            RotatorH.setPosition(0);
            return false;
        }
    }

    public Action Dogh() {
        return new Dogh();
    }

    //High Rotator rotates up for specimen on wall
    /*public class SpecH implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            RotatorH.setPosition(0.75);
            return false;
        }
    }

    public Action SpecH() {
        return new SpecH();
    }*/
}