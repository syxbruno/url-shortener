package com.syxbruno.url_shortener.reposiory;

import com.syxbruno.url_shortener.model.Link;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {

  Optional<Link> findByUrl(String url);
  Optional<Link> findByShortUrl(String shortUrl);
  boolean existsByShortUrl(String code);
  List<Link> findByExpiryBefore(LocalDateTime now);
}
