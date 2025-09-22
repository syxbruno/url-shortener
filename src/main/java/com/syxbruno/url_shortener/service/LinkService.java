package com.syxbruno.url_shortener.service;

import com.syxbruno.url_shortener.dto.UrlRequest;
import com.syxbruno.url_shortener.model.Link;
import com.syxbruno.url_shortener.reposiory.LinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkService {

  private final CodeGeneratorService codeGenerator;
  private final LinkRepository repository;

  public String findShortenUrl(UrlRequest data) {

    Link url = repository.findByUrl(data.url())
        .orElseThrow();

    return url.getShortUrl();
  }
}
