package com.syxbruno.url_shortener.service;

import com.syxbruno.url_shortener.dto.UrlRequest;
import com.syxbruno.url_shortener.model.Link;
import com.syxbruno.url_shortener.reposiory.LinkRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class LinkService {

  private final LinkRepository repository;
  private final CodeGeneratorService codeGenerator;

  public String createShortenUrl(UrlRequest data) {

    Optional<Link> link = repository.findByUrl(data.url());

    if (link.isPresent()) {

      return link.get().getShortUrl();
    }

    String shortUrl = codeGenerator.generateUniqueCode();
    LocalDateTime expiry = LocalDateTime.now().plusMonths(2);

    repository.save(new Link(data.url(), shortUrl, expiry));

    return shortUrl;
  }

  public String findShortenUrl(String shortUrl) {

    return repository.findByShortUrl(shortUrl)
        .map(url -> "redirect:" + url.getUrl())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Short url not found"));
  }

  @Scheduled(cron = "0 0 12 * * *")
  public void verifyExpiry() {

    List<Link> expired = repository.findByExpiryBefore(LocalDateTime.now());

    if (!expired.isEmpty()) {

      repository.deleteAll(expired);
    }
  }
}
