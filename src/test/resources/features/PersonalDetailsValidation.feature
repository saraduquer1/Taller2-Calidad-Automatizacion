Feature: Validaciones en Personal Details
  Como empleado del sistema
  Quiero gestionar y validar mi información personal
  Para mantener mis datos actualizados y correctos

  Background:
    Given el usuario se autentica en el sistema
    And navega a la sección My Info

  # ========== FUNCIONALIDAD BÁSICA ==========

  Scenario: Guardar información existente sin cambios
    When guarda los datos actuales sin modificar
    Then ve un mensaje de actualización exitosa

  Scenario: Actualizar nombre completo exitosamente
    When actualiza el nombre completo con First Name "Sara", Middle Name "Lorena" y Last Name "Duque"
    And guarda los cambios
    Then ve un mensaje de actualización exitosa

  Scenario: Validar que First Name es obligatorio
    When borra completamente el campo First Name
    And intenta guardar los cambios
    Then ve que el campo First Name muestra error de campo requerido

  # ========== VALIDACIONES DE LONGITUD ==========

  Scenario: Validar texto con longitud inválida en First Name
    When ingresa texto de 31 caracteres en el campo "FirstName"
    Then debe ver mensaje de error de longitud en "FirstName"

  Scenario: Validar longitud máxima en Middle Name
    When ingresa texto de 31 caracteres en el campo "MiddleName"
    Then debe ver mensaje de error de longitud en "MiddleName"

  Scenario: Validar longitud máxima en Last Name
    When ingresa texto de 31 caracteres en el campo "LastName"
    Then debe ver mensaje de error de longitud en "LastName"