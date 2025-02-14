package org.firstinspires.ftc.teamcode.IntoTheDeep.Autos;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

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
       /* TrajectoryActionBuilder tab = drive.actionBuilder(initialPose)
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
*/
        // actions that need to happen on init
        Actions.runBlocking(grabberH.closeH());
        Actions.runBlocking(grabberL.closeL());
        Actions.runBlocking(RotatorH.Dogh());
        Actions.runBlocking(RotatorL.Lown());
        Actions.runBlocking(LfrontSlide.inL());

        waitForStart();

        if (isStopRequested()) return;

       // Action trajectoryAction = null;
      //  Actions.runBlocking(trajectoryAction);

      //  trajectoryAction = tab.build();
        Actions.runBlocking(
                new SequentialAction(
                        slideUp.HighBox(),
                        new SleepAction(1),
                        RotatorH.Hup(),
                        new SleepAction(1),
                        grabberH.openH(),
                        new SleepAction(1),
                        RotatorH.Dogh(),
                        new SleepAction(1),
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