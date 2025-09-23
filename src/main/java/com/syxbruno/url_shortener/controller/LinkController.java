package com.syxbruno.url_shortener.controller;

import com.syxbruno.url_shortener.dto.UrlRequest;
import com.syxbruno.url_shortener.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class LinkController {

  private final LinkService service;

  @PostMapping("/shorten")
  public ResponseEntity<String> shortenUrl(@RequestBody UrlRequest data) {

    String shortUrl = service.createShortenUrl(data);
    String urlResponse = "http://localhost:8080/" + shortUrl;

    return ResponseEntity.ok(urlResponse);
  }

  @GetMapping("/{code}")
  public String redirectOriginUrl(@PathVariable String code) {

    return service.findShortenUrl(code);
  }
}
