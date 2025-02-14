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

public class LfrontSlide {
    private final Servo LfrontSlide;

    public LfrontSlide(HardwareMap hardwareMap) {
        LfrontSlide = hardwareMap.get(Servo.class, "LfrontSlide");
    }

//out Low Slide
    public class outL implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            LfrontSlide.setPosition(0.3);
            return false;
        }
    }

    public Action outL() {
        return new outL();
    }

//in Low Slide
    public class inL implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            LfrontSlide.setPosition(0);
            return false;
        }
    }

    public Action inL() {
        return new inL();
    }
}