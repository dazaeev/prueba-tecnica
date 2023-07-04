package mx.com.boot.springframework.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Nazario Dazaeev
 * Clase para envolver las respuestas de los servicios web.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class WebResponse {
    /**
     * C&oacute;digo de error.
     */
    private int code;

    /**
     * Mensaje sobre el error o el payload.
     */
    private String message;

    /**
     * Response.
     */
    private Object payload;
}
