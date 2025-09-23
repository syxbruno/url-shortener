package com.syxbruno.url_shortener.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "link")
public class Link {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique = true)
  private String url;
  @Column(unique = true)
  private String shortUrl;
  private LocalDateTime expiry;

  public Link(String url, String shortUrl, LocalDateTime expiry) {

    this.url = url;
    this.shortUrl = shortUrl;
    this.expiry = expiry;
  }
}
