# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://github.com/jdollar/rpi-i2s-audio.git;protocol=https"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "8835a3f3191278c53719537d550f70e9b5e33605"

S = "${WORKDIR}/git"
DEPENDS = "bc-native bison-native"

inherit module

PI_ZERO_MACRO = "PI_ZERO"
PI_2_MACRO = "PI_2"
PI_3_MACRO = "PI_3"

EXTRA_OEMAKE_append_task-compile_raspberrypi0-wifi = " BOARD_MACRO=${PI_ZERO_MACRO} "
EXTRA_OEMAKE_append_task-compile_raspberrypi0 = " BOARD_MACRO=${PI_ZERO_MACRO} "
EXTRA_OEMAKE_append_task-compile_raspberrypi2 = " BOARD_MACRO=${PI_2_MACRO} "
EXTRA_OEMAKE_append_task-compile_raspberrypi3 = " BOARD_MACRO=${PI_3_MACRO} "
EXTRA_OEMAKE_append_task-compile_raspberrypi3-64 = " BOARD_MACRO=${PI_3_MACRO} "

EXTRA_OEMAKE_append_task-install = " -C ${STAGING_KERNEL_DIR} M=${S} "
KERNEL_MODULE_AUTOLOAD += "my_loader"
