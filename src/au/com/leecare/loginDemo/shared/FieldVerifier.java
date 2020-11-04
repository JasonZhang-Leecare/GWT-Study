package au.com.leecare.loginDemo.shared;

// There is a strange error 'The import java.util.regex cannot be resolved' - So I have to drop
// Regex for now
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

/**
 * Validator Utility
 *
 * @auther Jason Zhang
 */
public class FieldVerifier {

  private static final int ASCII_0 = 48;
  private static final int ASCII_9 = 57;
  private static final int ASCII_A = 65;
  private static final int ASCII_Z = 90;
  private static final int ASCII_a = 97;
  private static final int ASCII_z = 122;
  private static final int MIN_LENGTH_USER_NAME = 6;

  /**
   * Validate a User Name
   *
   * @param aUserName UserName to validate
   * @return  true if username is not null and not cantains special character; false otherwise
   * */
  public static boolean isValidName(String aUserName) {
    if (aUserName == null || aUserName.length() < MIN_LENGTH_USER_NAME) {
      return false;
    }

    return notContainSpecialCharacter(aUserName);
  }

  // Will use Apache String Util to replace the function here
  /**
   * Validate Passowrd
   *
   * @param aPassword password to validate
   * @return true if password:
   *  is not blank;
   *  contains at least one upper case character;
   *  contains at least special character.
   */
  public static boolean isValidPassword(String aPassword) {

    if (aPassword == null || aPassword.trim().isEmpty()) return false;

    boolean containsSpecialCharacter = false;
    boolean containsUpperCaseCharacter = false;
    
    for (char current : aPassword.toCharArray()) {

      if (!isNormalCharacter(current)) {
        containsSpecialCharacter = true;
      }

      if(isUpperCase(current)) {
        containsUpperCaseCharacter = true;
      }

      if (containsSpecialCharacter && containsUpperCaseCharacter) break;
    }

    return containsSpecialCharacter && containsUpperCaseCharacter;
  }

  // Usually should use Apache StringUtil
  private static boolean notContainSpecialCharacter(String aInput) {
    for (char current : aInput.toCharArray()) {
      if (isNormalCharacter(current)) {
        continue;
      } else {
        return false;
      }
    }

    return true;
  }

  private static boolean isNormalCharacter(char aChar) {
    return (aChar >= ASCII_0 && aChar <= ASCII_9)
            || (aChar >= ASCII_A && aChar <= ASCII_Z)
            || (aChar >= ASCII_a && aChar <= ASCII_z);
  }

  private static boolean isUpperCase(char aChar) {
    return aChar >= ASCII_A && aChar <= ASCII_Z;
  }
}
