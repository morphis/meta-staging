DESCRIPTION = "The MeeGo Touch Theme"
AUTHOR = "Nokia Corporation and/or its subsidiary(-ies)"
HOMEPAGE = "http://qt.nokia.com/"
SECTION = "meego/ui"

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=9bddd653c11e4620e98b7c15dce0f89c"

PV = "0.25.1-1+gitr${SRCPV}"
PR = "r0"

SRC_URI = "git://gitorious.org/meegotouch/meegotouch-theme.git"
S = "${WORKDIR}/git"
SRCREV = "67c6d661843a3376764a9b69cc7a0b73e23e9a46"

do_install() {
  install -d ${D}/${datadir}/themes
  cp -r ${S}/base ${D}/${datadir}/themes
}

PACKAGES = "${PN}"
FILES_${PN} = "${datadir}/themes"
