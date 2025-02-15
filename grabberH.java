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

public class grabberH {
    private Servo grabberH;

    public grabberH(HardwareMap hardwareMap) {
        grabberH = hardwareMap.get(Servo.class, "grabberH");
    }

//close High Grabber
    public class closeH implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            grabberH.setPosition(0.002);
            return false;
        }
    }

    public Action closeH() {
        return new closeH();
    }

//open High Grabber
    public class openH implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            grabberH.setPosition(0.5);
            return false;
        }
    }
    public Action openH() {
        return new openH();
    }
}