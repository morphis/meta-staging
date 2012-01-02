DESCRIPTION = "Qt Quick Components project"
AUTHOR = "Nokia Corporation and/or its subsidiary(-ies)"
HOMEPAGE = "http://qt.nokia.com/"
SECTION = "qt4"

DEPENDS = "qt-components-graphics"

LICENSE = "BSD & GFDL-1.3"
LIC_FILES_CHKSUM = " \
  file://header.BSD;md5=6127ef7232170f61b7c5f4da50768c27 \
  file://LICENSE.FDL;md5=6d9f2a9af4c8b8c3c769f6cc1b6aaf7e"

PV = "1.2+gitr${SRCPV}"
PR = "r0"

SRC_URI = " \
  git://gitorious.org/qt-components/qt-components.git;protocol=git;branch=master \
  file://configure-qmake-exec.patch \
  file://compilation-mlocalewrapper.patch"
S = "${WORKDIR}/git"
SRCREV = "3ebb2b652a444790d32d4fecd02ae3267a8ec8b0"

inherit qt4x11

QT_COMPONENTS_DIR := "qt4"
QT_COMPONENTS_IMPORTS := "${libdir}/${QT_COMPONENTS_DIR}/imports"
QT_COMPONENTS_MKSPECS := "${libdir}/${QT_COMPONENTS_DIR}/mkspecs"

do_configure() {
  sed -e 's@...QT_INSTALL_IMPORTS.@${QT_COMPONENTS_IMPORTS}@' -i ${S}/qml.pri
  sed -e 's@...QMAKE_MKSPECS.@${QT_COMPONENTS_MKSPECS}@' -i ${S}/qt-components.pro
  ./configure -prefix ${prefix} -meego -nomake tests -no-mobility -qmake-exec ${STAGING_BINDIR_NATIVE}/qmake2
}

do_install() {
  oe_runmake install INSTALL_ROOT=${D}
}

FILES_${PN}-dbg += " \
  ${libdir}/${QT_COMPONENTS_DIR}/imports/Qt/labs/components/.debug \
  ${libdir}/${QT_COMPONENTS_DIR}/imports/Qt/labs/components/native/.debug \
  ${libdir}/${QT_COMPONENTS_DIR}/imports/com/nokia/meego/.debug \
  ${libdir}/${QT_COMPONENTS_DIR}/imports/com/nokia/extras/.debug \
  ${libdir}/${QT_COMPONENTS_DIR}/imports/com/meego/.debug \
  ${libdir}/${QT_COMPONENTS_DIR}/imports/com/meego/extras/.debug"
FILES_${PN}-dev += "${libdir}/${QT_COMPONENTS_DIR}/mkspecs"
FILES_${PN} += "${libdir}/${QT_COMPONENTS_DIR}/imports"

