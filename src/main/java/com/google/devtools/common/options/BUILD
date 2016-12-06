# Description:
#   A devtools-common options parser.
#   Open-sourced as part of Bazel.


load("@org_pubref_rules_apidoc//java:rules.bzl", "javadoc")

javadoc(
    name = "api",
    srcs = glob(["*.java"]),
    deps = [
        ":options",
        "@com_google_guava_guava//jar",
        "@com_google_code_findbugs_jsr305//jar",
    ]
)

java_library(
    name = "options",
    srcs = glob(["*.java"]),
    deps = [
        "@com_google_guava_guava//jar",
        "@com_google_code_findbugs_jsr305//jar",
    ],
    exports = [
        "@com_google_guava_guava//jar",
        "@com_google_code_findbugs_jsr305//jar",
    ],
    visibility = ["//visibility:public"]
)
