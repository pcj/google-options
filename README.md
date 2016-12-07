# google-options [![Build Status](https://travis-ci.org/pcj/google-options.svg?branch=master)](https://travis-ci.org/pcj/google-options) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.pcj/google-options/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.pcj/google-options) [![JavaDoc](https://img.shields.io/badge/apidoc-1.0.0-orange.svg)](https://pcj.github.io/google-options/)

<table><tr>
<td><img src="https://avatars0.githubusercontent.com/u/1342004?v=3&s=200" width="120"/></td>
<td><img src="http://icons.iconarchive.com/icons/cornmanthe3rd/plex/128/System-settings-icon.png" width="120"/></td>
</tr><tr>
<td>Google</td>
<td>Options</td>
</tr></table>

This is the command-line arguments parser from the
[Bazel Project](http://bazel.build).  The
`com.google.devtools.common.options` package has been split out into a
separate jar for general utility.

# Installation

### Bazel

```python
maven_jar(
    name = "com_github_pcj_google_options",
    artifact = "com.github.pcj:google-options:jar:1.0.0",
    sha1 = "85d54fe6771e5ff0d54827b0a3315c3e12fdd0c7",
)
```

### Gradle

```groovy
dependencies {
  compile 'com.github.pcj:google-options:1.0.0'
}
```

### Maven

```xml
<dependency>
  <groupId>com.github.pcj</groupId>
  <artifactId>google-options</artifactId>
  <version>1.0.0</version>
</dependency>
```

# Usage

Create a class that extends `OptionsBase` and defines your `@Option`(s).

```java
package example;

import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;

import java.util.List;

/**
 * Command-line options definition for example server.
 */
public class ServerOptions extends OptionsBase {

  @Option(
      name = "help",
      abbrev = 'h',
      help = "Prints usage info.",
      defaultValue = "true"
    )
  public boolean help;

  @Option(
      name = "host",
      abbrev = 'o',
      help = "The server host.",
      category = "startup",
      defaultValue = ""
  )
  public String host;

  @Option(
    name = "port",
    abbrev = 'p',
    help = "The server port.",
    category = "startup",
    defaultValue = "8080"
    )
    public int port;

  @Option(
    name = "dir",
    abbrev = 'd',
    help = "Name of directory to serve static files.",
    category = "startup",
    allowMultiple = true,
    defaultValue = ""
    )
    public List<String> dirs;

}
```

Parse the arguments and use them.

```java
package example;

import com.google.devtools.common.options.OptionsParser;
import java.util.Collections;

public class Server {

  public static void main(String[] args) {
    OptionsParser parser = OptionsParser.newOptionsParser(ServerOptions.class);
    parser.parseAndExitUponError(args);
    ServerOptions options = parser.getOptions(ServerOptions.class);
    if (options.host.isEmpty() || options.port < 0 || options.dirs.isEmpty()) {
      printUsage(parser);
      return;
    }

    System.out.format("Starting server at %s:%d...\n", options.host, options.port);
    for (String dirname : options.dirs) {
      System.out.format("\\--> Serving static files at <%s>\n", dirname);
    }
  }

  private static void printUsage(OptionsParser parser) {
    System.out.println("Usage: java -jar server.jar OPTIONS");
    System.out.println(parser.describeOptions(Collections.<String, String>emptyMap(),
                                              OptionsParser.HelpVerbosity.LONG));
  }

}
```

Please consult the
[tests](src/test/java/com/google/devtools/common/options/) and
[source code](src/main/java/com/google/devtools/common/options/) for
more detailed information.

[JavaDoc API documentation](https://pcj.github.io/google-options/) is housed in the gh-pages branch.
