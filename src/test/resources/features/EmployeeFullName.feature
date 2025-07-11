Feature: Gestión de Employee Full Name en Personal Details
  Como empleado del sistema
  Quiero gestionar mi nombre completo
  Para mantener mi información personal actualizada

  Background:
    Given el usuario se autentica en el sistema
    And navega a la sección My Info

  Scenario: Guardar información existente sin cambios
    When guarda los datos actuales sin modificar
    Then ve un mensaje de actualización exitosa

  Scenario: Actualizar nombre completo exitosamente
    When borra el contenido actual del First Name
    And actualiza su First Name a "Carlos"
    And borra el contenido actual del Last Name
    And actualiza su Last Name a "Rodriguez"
    And borra el contenido actual del Middle Name
    And actualiza su Middle Name a "Alberto"
    And guarda los cambios
    Then ve un mensaje de actualización exitosa

  Scenario: Validar que First Name es obligatorio
    When borra completamente el campo First Name
    And intenta guardar los cambios
    Then ve que el campo First Name muestra error de campo requerido