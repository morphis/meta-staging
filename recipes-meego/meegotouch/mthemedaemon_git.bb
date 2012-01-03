DESCRIPTION = "The MeeGo Theme daemon (part of the Meego Touch Library)"
AUTHOR = "Nokia Corporation and/or its subsidiary(-ies)"
HOMEPAGE = "http://qt.nokia.com/"
SECTION = "meego/ui"

DEPENDS = "icu gconf libmeegotouch-native"

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=7635eef25dff78f483059bf21a20686d"

PV = "0.25.3-1+gitr${SRCPV}"
PR = "r0"

SRC_URI = " \
  git://gitorious.org/meegotouch/libmeegotouch.git;protocol=git;branch=master \
  file://evaluate-qmake-bin.patch \
  file://remove-const-specifier.patch \
  file://include-necessary-sources.patch"
S = "${WORKDIR}/git"
SRCREV = "d2f0f942d58f01615d60607a4ca9b0547f16fe50"

inherit qt4x11

do_configure() {
  QMAKE_BIN=${STAGING_BINDIR_NATIVE}/qmake2 ./configure \
    -no-libmlocale -no-meegographicssystem \
    -dbus -gconf -no-icu -prefix ${prefix}
}

do_compile() {
  cd ${S}/${PN} && qmake && make
}

do_install() {
  install -d ${D}/${bindir}
  install -m 0755 ${S}/${PN}/mthemedaemon ${D}/${bindir}
}
