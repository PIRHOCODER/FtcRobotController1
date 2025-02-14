package org.firstinspires.ftc.teamcode.IntoTheDeep.Autos;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Pose2dDual;
import com.acmerobotics.roadrunner.ProfileParams;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.TrajectoryBuilder;
import com.acmerobotics.roadrunner.TrajectoryBuilderParams;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous(name = "AutoTest")
public class AutoTest extends LinearOpMode {

    private DcMotor slideUp;

        @Override
        public void runOpMode() {
            waitForStart();

            if (isStopRequested()) return;

            // instantiate your MecanumDrive at a particular pose.
            Pose2d initialPose = new Pose2d(-36, 65, Math.toRadians(270));
            MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
            Actions.runBlocking(drive.actionBuilder(initialPose)
                            .strafeToSplineHeading(new Vector2d(-50, 56), Math.toRadians(315))
                    .build());
        }
}
