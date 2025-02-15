package org.firstinspires.ftc.teamcode.IntoTheDeep.Autos;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.InstantAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.tuning.MecanumDrive;
import org.firstinspires.ftc.teamcode.Mechanisms.LfrontSlide;
import org.firstinspires.ftc.teamcode.Mechanisms.RotatorH;
import org.firstinspires.ftc.teamcode.Mechanisms.RotatorL;
import org.firstinspires.ftc.teamcode.Mechanisms.grabberH;
import org.firstinspires.ftc.teamcode.Mechanisms.grabberL;
import org.firstinspires.ftc.teamcode.Mechanisms.slideUp;

@Config
@Autonomous(name = "Blue_Box", group = "Autonomous")
public class BlueBox extends LinearOpMode {
   
    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(-36, 65, Math.toRadians(270 ));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        grabberH grabberH = new grabberH(hardwareMap);
        grabberL grabberL = new grabberL(hardwareMap);
        RotatorH RotatorH = new RotatorH(hardwareMap);
        RotatorL RotatorL = new RotatorL(hardwareMap);
        LfrontSlide LfrontSlide = new LfrontSlide(hardwareMap);
        slideUp slideUp = new slideUp(hardwareMap);

        // actions that need to happen on init
        Actions.runBlocking(grabberH.closeH());
        Actions.runBlocking(grabberL.closeL());
        Actions.runBlocking(RotatorH.Dogh());
        Actions.runBlocking(RotatorL.Lome());
        Actions.runBlocking(LfrontSlide.inL());

        waitForStart();

        if (isStopRequested()) return;

       //ElapsedTime time = new ElapsedTime();
       //telemetry.addData("Time", time.seconds());

        Actions.runBlocking(drive.actionBuilder(initialPose)
                .strafeToSplineHeading(new Vector2d(-50, 56), Math.toRadians(315))
                .build());

        Actions.runBlocking(
                new SequentialAction(
                        slideUp.HighBox(),
                        RotatorH.Hup(),
                        grabberH.openH(),
                        RotatorH.Dogh(),
                        slideUp.Home()
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