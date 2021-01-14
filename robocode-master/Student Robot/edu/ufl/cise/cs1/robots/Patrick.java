package edu.ufl.cise.cs1.robots;

import robocode.*;

import java.awt.*;

public class Patrick extends TeamRobot
{

    public void run()
    {
        setBodyColor(Color.pink);
        setGunColor(Color.pink);
        setScanColor(Color.pink);
        setRadarColor(Color.blue);
        setBulletColor(Color.blue);

        setAdjustGunForRobotTurn(true);

        while (true)//robot dodges bullets while shooting
        {
            scan();
            setTurnGunRight(getHeading() + getHeading());
            setMaxVelocity(100);
            setBack(200);
            setTurnRight(120);
//            setTurnLeft(180);
            setAhead(20);
            setBack(200);
            //circular motion while moving
        }
    }

    public void onScannedRobot(ScannedRobotEvent e)
    {
        if(!(this.isTeammate(e.getName())))//if scanned robot is not a teammate
        {
            //robot turns gun and body toward scanned robot
            setTurnGunRight(getHeading() - getGunHeading() + e.getBearing());
            setTurnRight(getHeading() - getGunHeading() + e.getBearing());
            fire(3);
            setTurnLeft(120);
            setBack(200);
        }

        else//if robot is a teammate, return
            return;
    }

    public void onHitWall(HitWallEvent e)//when robot hits wall
    {
        scan();//scan for robots, maintain shooting accuracy after hitting a wal
        setTurnGunRight(90);
        setTurnLeft(90);
//        setTurnLeft(125);
        ahead(20);
        fire(3);
        back(200);
    }

    public void onHitByBullet(HitByBulletEvent e)//after robot is hit by bullet
    {
        //robot turns gun and body toward robot
        setTurnGunRight(getHeading() - getGunHeading() + e.getBearing());
        setTurnRight(getHeading() - getGunHeading() + e.getBearing());
        setBack(200);
        fire(3);
    }
}

/*
Author: Robocode Wiki
Date: October 29, 2013
Title: Head-On Targeting
Web Address: http://robowiki.net/wiki/Head-On_Targeting
*/