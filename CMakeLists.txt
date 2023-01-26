cmake_minimum_required(VERSION 3.24)
project(Rancho_Robotics)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(Rancho_Robotics
        Controller.cpp
        Controller.h units.h)
