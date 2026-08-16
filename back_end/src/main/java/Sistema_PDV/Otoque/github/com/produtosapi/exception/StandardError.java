package Sistema_PDV.Otoque.github.com.produtosapi.exception;

import java.time.Instant;

public record StandardError(
    Instant timestamp,
    Integer status,
    String error,
    String message,
    String path
) {}
