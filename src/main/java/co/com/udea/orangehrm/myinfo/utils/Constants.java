package co.com.udea.orangehrm.myinfo.utils;

import java.time.Duration;

public class Constants {

    // URLs
    public static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/";

    // Credenciales
    public static final String USERNAME = "Admin";
    public static final String PASSWORD = "admin123";

    // Configuración de tiempos de espera para Toast
    public static final int TOAST_MAX_ATTEMPTS = 50;
    public static final Duration TOAST_WAIT_BETWEEN_ATTEMPTS = Duration.ofMillis(100);
    public static final Duration TOAST_TOTAL_TIMEOUT = Duration.ofSeconds(5);

    // Claves de memoria del actor
    public static final String TOAST_FOUND_KEY = "toastFound";

    // ==================== NUEVAS CONSTANTES PARA VALIDACIONES ====================

    // Textos de prueba
    public static final String VALID_30_CHARS = "AbcdefghijklmnopqrstuvwxyzABCD"; // Exactamente 30 caracteres
    public static final String INVALID_31_CHARS = "AbcdefghijklmnopqrstuvwxyzABCDE"; // Exactamente 31 caracteres
}