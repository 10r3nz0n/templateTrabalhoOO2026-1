package temadogrupo.utilitarios;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class GeradorIdentificadorUnico {

    private static final AtomicInteger CONTADOR_INT = new AtomicInteger(0);
    private static final AtomicLong CONTADOR_LONG = new AtomicLong(0);

    private GeradorIdentificadorUnico() {
    }

    public static String gerarIDUnicoString() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static int gerarIDUnicoInt() {
        return CONTADOR_INT.incrementAndGet();
    }

    public static long gerarIDUnicoLong() {
        return CONTADOR_LONG.incrementAndGet();
    }
}
