package org.firstinspires.ftc.teamcode.IntoTheDeep.Autos;
import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.InstantAction;
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
import org.firstinspires.ftc.teamcode.Mechanisms.slideUp;
import org.firstinspires.ftc.teamcode.tuning.MecanumDrive;
import org.firstinspires.ftc.teamcode.Mechanisms.grabberL;
import org.firstinspires.ftc.teamcode.Mechanisms.RotatorH;
import org.firstinspires.ftc.teamcode.Mechanisms.RotatorL;
import org.firstinspires.ftc.teamcode.Mechanisms.grabberH;
import org.firstinspires.ftc.teamcode.Mechanisms.LfrontSlide;

@Config
@Autonomous(name = "DONOTRUN!", group = "Autonomous")
public class BlueBoxV2 extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d initialPose = new Pose2d(-36, 65, Math.toRadians(270));
        Pose2d stage2 = new Pose2d(-50, 56, Math.toRadians(315));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        slideUp slideup = new slideUp(hardwareMap);
        LfrontSlide lfrontSlide = new LfrontSlide(hardwareMap);
        RotatorH rotatorH = new RotatorH(hardwareMap);
        RotatorL rotatorL = new RotatorL(hardwareMap);
        grabberH GrabberH = new grabberH(hardwareMap);
        grabberL GrabberL = new grabberL(hardwareMap);

        telemetry.addData("Starting Position", 1);
        telemetry.update();
        Actions.runBlocking(
                new ParallelAction(
                        GrabberH.closeH(),
                        GrabberL.closeL(),
                        rotatorH.Dogh(),
                        rotatorL.Lome(),
                        lfrontSlide.HoL()
                )
        );
        waitForStart();

        if (isStopRequested()) return;

        /*Actions.runBlocking(
                drive.actionBuilder(initialPose)
                        .afterTime(1, slideup.HighBox())
                        .build()
        ); */
        Actions.runBlocking(
                new ParallelAction(drive.actionBuilder(initialPose)
                        .strafeToSplineHeading(new Vector2d(-50, 56), Math.toRadians(315))
                        .build(),
                        new SequentialAction(
                                slideup.HighBox()

                        )
                )

        );
        Actions.runBlocking(
                new SleepAction(2)
        );
        Actions.runBlocking(
                new SequentialAction(
                        slideup.HighBox(),
                        rotatorH.Hup()
                ));
        Actions.runBlocking(
                new SleepAction(1)
                );
        Actions.runBlocking(
                new SequentialAction(
                        GrabberH.openH()
                ));
        Actions.runBlocking(
                new SleepAction(1)
                );
        Actions.runBlocking(
                new SequentialAction(
                        rotatorH.Dogh()
                ));
        Actions.runBlocking(
                new SleepAction(1)
        );

        Actions.runBlocking(
                new SequentialAction(
                        rotatorH.Dogh(),
                        slideup.Home()
                )
        );
        Actions.runBlocking(
                new ParallelAction(drive.actionBuilder(stage2)
                        .strafeToSplineHeading(new Vector2d(-50,48), Math.toRadians(280))
                        .build()
                )
        );
        // Mr.lanny's code
        /*Actions.runBlocking(
                drive.actionBuilder(initialPose)
                        .strafeToSplineHeading(new Vector2d(-9,46), Math.toRadians(-90))
                        .strafeToSplineHeading(new Vector2d(-36,35), Math.toRadians(-90))
                        //.splineTo(new Vector2d(-35, 0), Math.PI / 2)
                        .strafeToSplineHeading(new Vector2d(-36,12),Math.toRadians(-90))
                        .strafeToSplineHeading(new Vector2d(-46,0),Math.toRadians(-90))
                        .strafeToSplineHeading(new Vector2d(-46,65),Math.toRadians(-90))
                        .strafeToSplineHeading(new Vector2d(-46,0),Math.toRadians(-90))
                        .strafeTo(new Vector2d(-54,0))
                        .strafeToSplineHeading(new Vector2d(-54,65),Math.toRadians(-90))
                        .strafeTo(new Vector2d(-54, 0))
                        .strafeToSplineHeading(new Vector2d(-65, 0), Math.toRadians(-90))
                        .strafeToSplineHeading(new Vector2d(-65, 65), Math.toRadians(-90))
                        .build()); */
    }
}
