package org.firstinspires.ftc.teamcode;
import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.MecanumDrive;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
@Autonomous(name = "IntoTheDeep", group = "Autonomous")
public class Auto extends LinearOpMode {

    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(0, 0, Math.toRadians(90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);

        // vision here that outputs position

        TrajectoryActionBuilder tab1 = drive.actionBuilder(initialPose)
                .lineToY(10)
                .waitSeconds(3);


/*
        Action trajectoryActionCloseOut = tab1.fresh()
                .strafeTo(new Vector2d(48, 12))
                .build();
*/


        waitForStart();
        if (isStopRequested()) return;

        Action trajectoryActionChosen;


        trajectoryActionChosen = tab1.build();


        Actions.runBlocking(
                new SequentialAction(
                        trajectoryActionChosen
                )
        );
    }
}