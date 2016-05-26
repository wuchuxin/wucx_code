package com.mvn_pro.project.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderUtils
{
  private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(4);
  
  public static String encode(CharSequence rawStr)
  {
    return passwordEncoder.encode(rawStr);
  }
  
  public static boolean match(CharSequence rawStr, String encodedStr)
  {
    return passwordEncoder.matches(rawStr, encodedStr);
  }
}
