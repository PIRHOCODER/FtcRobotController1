package org.firstinspires.ftc.teamcode.Mechanisms;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class slideUp {
    private DcMotor slideUp;

    public slideUp(HardwareMap hardwareMap) {
        slideUp = hardwareMap.get(DcMotor.class, "slideUp");
        slideUp.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public class up implements Action {

        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            return false;
        }
    }
