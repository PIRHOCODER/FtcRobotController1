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

public class RotatorL {
    private Servo RotatorL;

    public RotatorL(HardwareMap hardwareMap) {
        RotatorL = hardwareMap.get(Servo.class, "RotatorL");
    }

//Low Rotator rotate up
    public class Lup implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            RotatorL.setPosition(0.3);
            return false;
        }
    }

    //public Action Lup() {
     //   return new Lup();
    //}

//Low Rotator rotate down
    public class Lown implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            RotatorL.setPosition(0.67);
            return false;
        }
    }

    public Action Lown() {
        return new Lown();
    }

    public class Lome implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            RotatorL.setPosition(0);
            return false;
        }
    }

    public Action Lome() {
        return new Lome();
    }
}