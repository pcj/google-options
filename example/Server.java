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
