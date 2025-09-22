package com.syxbruno.url_shortener.service;

import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class CodeGeneratorService {

  private static final int codeSize = 6;
  private static final Random random = new Random();
  private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

  public String generateShortUrl() {

    StringBuilder sb = new StringBuilder(codeSize);

    for (int i = 0; i < codeSize; i++) {

      int index = random.nextInt(characters.length());
      sb.append(characters.charAt(index));
    }

    return sb.toString();
  }
}
