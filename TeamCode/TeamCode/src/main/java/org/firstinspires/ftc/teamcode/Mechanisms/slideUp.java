package org.firstinspires.ftc.teamcode.Mechanisms;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class slideUp {
    private DcMotor slideUp;
    private boolean intialized = false;

    public slideUp(HardwareMap hardwareMap) {
        slideUp = hardwareMap.get(DcMotor.class, "slideUp");
        slideUp.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public class upToHighBox implements Action {

        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            if (!intialized) {
                slideUp.setPower(1);
                intialized = true;
            }
            int currentSlidePosition = slideUp.getCurrentPosition();
            slideUp.setTargetPosition(currentSlidePosition + 3415); // Adjust the step size as needed);
            slideUp.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            if (slideUp.getCurrentPosition() < 3415)
                slideUp.setPower(1);
            return false;
        }
    }
    public Action upToHighBox() {
        return new upToHighBox();
    }

    public class upToLowBox implements Action {

        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            if (!intialized) {
                slideUp.setPower(1);
                intialized = true;
            }
            int currentSlidePosition = slideUp.getCurrentPosition();
            slideUp.setTargetPosition(currentSlidePosition + 1585); // Adjust the step size as needed);
            slideUp.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            if (slideUp.getCurrentPosition() < 3415);
            return false;
        }
    }

    public class home implements Action {

        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            if (!intialized) {
                slideUp.setPower(-1);
                intialized = true;
            }
            int currentSlidePosition = slideUp.getCurrentPosition();
            slideUp.setTargetPosition(0);
            slideUp.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            return false;
        }
    }

}