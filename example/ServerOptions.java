package example;

import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;

import java.util.List;

/**
 * Command-line options for example server.
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
