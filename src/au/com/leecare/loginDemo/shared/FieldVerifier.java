package au.com.leecare.loginDemo.shared;

// There is a strange error 'The import java.util.regex cannot be resolved' - So I have to drop
// Regex for now
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

/**
 * Validator Utility including validate: UserName - Not null, no special character. Password - at
 * least 6 digit; no special character; at least one upper case character; at least one digit.
 */
public class FieldVerifier {

  private static int ASCII_0 = 48;
  private static int ASCII_9 = 57;
  private static int ASCII_A = 65;
  private static int ASCII_Z = 90;
  private static int ASCII_a = 97;
  private static int ASCII_z = 122;

  /** Return true if username is not null and not cantains special character; false otherwise */
  public static boolean isValidName(String name) {
    if (name == null || name.length() < 6) {
      return false;
    }

    return noSpecialCharacter(name);
  }

  // Will use Apache String Util to replace the function here
  /**
   * Return true is password: at least 6 digit long; no special character; contains at least one
   * upper case character; contains at least one digit.
   */
  public static boolean isValidPassword(String password) {
    if (password == null || password.trim().isEmpty()) return false;
    /*

    Pattern regex = Pattern.compile("[^A-Za-z0-9]");

    Matcher matcher = regex.matcher(password);

    matcher.find();*/

    if (noSpecialCharacter(password)) return false;

    if (!containsUpperCase(password)) return false;

    if (!containsDigit(password)) return false;

    return true;
  }

  // Usually should use Apache StringUtil
  private static boolean noSpecialCharacter(String input) {
    for (int current : input.toCharArray()) {
      if ((current >= ASCII_0 && current <= ASCII_9)
          || (current >= ASCII_A && current <= ASCII_Z)
          || (current >= ASCII_a && current <= ASCII_z)) {
        continue;
      } else {
        return false;
      }
    }

    return true;
  }

  // Usually should use Apache StringUtil
  private static boolean containsUpperCase(String input) {
    for (int current : input.toCharArray()) {
      if (current >= ASCII_A && current <= ASCII_Z) {
        return true;
      }
    }

    return false;
  }

  // Usually should use Apache StringUtil
  private static boolean containsDigit(String input) {
    for (int current : input.toCharArray()) {
      if (current >= ASCII_0 && current <= ASCII_9) {
        return true;
      }
    }
    return false;
  }
}
