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
SUMMARY = "Adds script to start up streams"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = " \
    file://start_bird_stream.sh \
"

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# Specify compilation commands here
	:
}

do_install () {
    install -d ${D}/${sbindir}
    install -m 0755 ${WORKDIR}/start_bird_stream.sh ${D}/${sbindir}/start_bird_stream
}

