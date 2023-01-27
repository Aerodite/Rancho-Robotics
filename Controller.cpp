//
// Created by Anthony Garcia Roman on 26/1/2023.
//
#include "Controller.h"
#include <units.h>
using namespace units::literals;

frc::PWMVictorSPX m_leftMotor{Constants::kLeftMotorPort};
frc::PWMVictorSPX m_rightMotor{Constants::kRightMotorPort};
frc::DifferentialDrive m_robotDrive{m_leftMotor, m_rightMotor};
frc::GenericHID m_stick{Constants::kJoystickPort};

m_robotDrive.ArcadeDrive(-m_stick.GetRawAxis(0), m_stick.GetRawAxis(1));