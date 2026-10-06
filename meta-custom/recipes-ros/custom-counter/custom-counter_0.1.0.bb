SUMMARY = "ROS 2 counter publisher and subscriber"
DESCRIPTION = "Counter publisher and subscriber; the subscriber starts and stops the counter through a service"
HOMEPAGE = "https://github.com/borhi/ros2-custom-counter"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c47ee90e680529d69abd5e89b8e5dc15"

inherit ros_distro_jazzy
inherit ros_component

# Sources come from the git submodule files/ros2-custom-counter, so the image
# always contains the commit the submodule points to. BitBake checksums every
# file in the directory, so any change there triggers a rebuild.
SRC_URI = "file://ros2-custom-counter"
S = "${WORKDIR}/ros2-custom-counter"

# Dependencies from package.xml
ROS_BUILD_DEPENDS = " \
    rclcpp \
    std-msgs \
    std-srvs \
"
ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"
ROS_EXEC_DEPENDS = " \
    rclcpp \
    std-msgs \
    std-srvs \
    launch \
    launch-ros \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}
