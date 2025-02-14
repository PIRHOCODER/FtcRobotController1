/*package org.firstinspires.ftc.teamcode;
import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.AutoAttachments.Claw;
import org.firstinspires.ftc.teamcode.AutoAttachments.Elbow;
import org.firstinspires.ftc.teamcode.AutoAttachments.Lift;
import org.firstinspires.ftc.teamcode.AutoAttachments.Wrist;

@Config
@Autonomous(name = "Blue Right", group = "Autonomous")
public class BlueRightAuto extends LinearOpMode {


    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(-12, 62, Math.toRadians(-90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        Claw claw = new Claw(hardwareMap);
        Wrist wrist = new Wrist(hardwareMap);
        Elbow elbow = new Elbow(hardwareMap);

        telemetry.addData("Starting Position", 1);
        telemetry.update();
        waitForStart();

        if (isStopRequested()) return;

        Actions.runBlocking(
                new ParallelAction(drive.actionBuilder(initialPose)
                        //.splineTo(new Vector2d(-35, 0), Math.PI / 2)
                        .strafeTo(new Vector2d(7 , 42))
                        .build(),
                        new SequentialAction(
                                wrist.wristPreScore(),
                                elbow.elbowScore()

                        )

                )
        );
        Actions.runBlocking((
                new SequentialAction()
        ));
        Actions.runBlocking(
                new SleepAction(2));
    }
}
*/
