package com.syxbruno.url_shortener.dto;

import jakarta.validation.constraints.NotBlank;

public record UrlRequest(@NotBlank String url) {

}
