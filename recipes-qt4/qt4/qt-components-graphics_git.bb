DESCRIPTION = "Theme required by the Qt Quick Components project"
AUTHOR = "Nokia Corporation and/or its subsidiary(-ies)"
HOMEPAGE = "http://qt.nokia.com/"
SECTION = "qt4"

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=9bddd653c11e4620e98b7c15dce0f89c"

PV = "0.1.91+gitr${SRCPV}"
PR = "r0"

SRC_URI = "git://gitorious.org/fremantle-qt-components/qt-components-graphics.git;protocol=git;branch=master"
S = "${WORKDIR}/git"
SRCREV = "3e69c6969a4c87b0394c6a3497d09a6d9abe7eab"

do_install() {
  mkdir -p ${D}/${datadir}/themes
  cp -r ${S}/base ${D}/${datadir}/themes
}

PACKAGES = "${PN}"
FILES_${PN} = "${datadir}/themes"
