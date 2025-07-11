package co.com.udea.orangehrm.myinfo.utils;

import java.time.Duration;

public class Constants {

    // URLs
    public static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/";

    // Credenciales
    public static final String USERNAME = "Admin";
    public static final String PASSWORD = "admin123";

    // Datos de prueba
    public static final String TEST_FIRST_NAME = "Juan";
    public static final String TEST_LAST_NAME = "Perez";
    public static final String TEST_EMAIL = "juan.perez@udea.edu.co";

    // Mensajes esperados
    public static final String SUCCESS_MESSAGE = "Successfully Updated";
    public static final String DASHBOARD_TITLE = "Dashboard";
    public static final String REQUIRED_MESSAGE = "Required";
    public static final String SUCCESS_TITLE = "Success";

    // Configuración de tiempos de espera para Toast
    public static final int TOAST_MAX_ATTEMPTS = 50;
    public static final Duration TOAST_WAIT_BETWEEN_ATTEMPTS = Duration.ofMillis(100);
    public static final Duration TOAST_TOTAL_TIMEOUT = Duration.ofSeconds(5);

    // Claves de memoria del actor
    public static final String TOAST_FOUND_KEY = "toastFound";
}