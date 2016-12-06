java_binary(
    name = "server",
    main_class = "example.Server",
    srcs = glob(["*.java"]),
    deps = [
        "//src/main/java/com/google/devtools/common/options",
    ],
    args = [
        "--host", "localhost",
        "--port", "8081",
        "--dir", "www/",
        "--dir", "resources/",
    ],
    visibility = ["//visibility:public"]
)
