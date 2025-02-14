package org.firstinspires.ftc.teamcode.IntoTheDeep.Autos;
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
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.MecanumDrive;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
@Autonomous(name = "Blue_Box", group = "Autonomous")
public class BlueBox extends LinearOpMode {
   
    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(0, 0, Math.toRadians(90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        grabberH grabberH = new grabberH(hardwareMap);
        grabberL grabberL = new grabberL(hardwareMap);
        RotatorH RotatorH = new RotatorH(hardwareMap);
        RotatorL RotatorL = new RotatorL(hardwareMap);
        LfrontSlide LfrontSlide = new LfrontSlide(hardwareMap);
        slideUp slideUp = new slideUp(hardwareMap);

        // vision here that outputs position
        //int visionOutputPosition = 1;

//what the robot will do to move around the field
        TrajectoryActionBuilder tab = drive.actionBuilder(initialPose)
                .lineToYSplineHeading(33, Math.toRadians(0))
                .waitSeconds(2)
                .setTangent(Math.toRadians(90))
                .lineToY(48)
                .setTangent(Math.toRadians(0))
                .lineToX(32)
                .strafeTo(new Vector2d(44.5, 30))
                .turn(Math.toRadians(180))
                .lineToX(47.5)
                .waitSeconds(3);
        Action trajectoryActionCloseOut = tab.endTrajectory().fresh()
                .strafeTo(new Vector2d(48, 12))
                .build();

        // actions that need to happen on init
        Actions.runBlocking(grabberH.closeH());
        Actions.runBlocking(grabberL.closeL());
        Actions.runBlocking(RotatorH.Dogh());
        Actions.runBlocking(RotatorL.Lown());
        Actions.runBlocking(LfrontSlide.inL());

        waitForStart();

        if (isStopRequested()) return;
 
        Actions.runBlocking(trajectoryAction);
        
        Action trajectoryAction = tab.build();
        Actions.runBlocking(
                new SequentialAction(
                        trajectoryActionCloseOut,
                        LfrontSlide.outL(),
                        grabberH.openH(),
                        grabberL.openL(),
                        RotatorH.Hup(),
                        RotatorL.Lup(),
                )
        );
/*
        while (!isStopRequested() && !opModeIsActive()) {
            int position = visionOutputPosition;
            telemetry.addData("Position during Init", position);
            telemetry.update();
        }
        int startPosition = visionOutputPosition;
        telemetry.addData("Starting Position", startPosition);
        telemetry.update();
        waitForStart();

        if (isStopRequested()) return;

        Action trajectoryActionChosen;
        if (startPosition == 1) {
            trajectoryActionChosen = tab1.build();
        } else if (startPosition == 2) {
            trajectoryActionChosen = tab2.build();
        } else {
            trajectoryActionChosen = tab3.build();
        }

        Actions.runBlocking(
                new SequentialAction(
                        trajectoryActionChosen,
                        lift.liftUp(),
                        claw.openClaw(),
                        lift.liftDown(),
                        trajectoryActionCloseOut
                )
        ); */
    }
}