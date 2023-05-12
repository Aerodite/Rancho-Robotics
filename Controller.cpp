//
// Created by Anthony Garcia Roman on 26/1/2023.
//
#include "Controller.h"
#include <units.h>
#include <frc>
using namespace units::literals;
using namespace frc;

frc::PWMVictorSPX m_leftMotor{units::constants::kLeftMotorPort};
frc::PWMVictorSPX m_rightMotor{units::constants::kRightMotorPort};
frc::DifferentialDrive m_robotDrive{m_leftMotor, m_rightMotor};
frc::GenericHID m_stick{units::constants::kJoystickPort};

m_robotDrive.ArcadeDrive(-m_stick.GetRawAxis(0), m_stick.GetRawAxis(1));