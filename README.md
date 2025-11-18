GPS Tracking App – Android (Java)

Aplicación Android desarrollada en Java + Google Maps para monitoreo satelital en tiempo real.
La app muestra la ubicación del vehículo, rota el ícono según el rumbo, dibuja la polilínea del recorrido y actualiza velocidad y posición de manera fluida.

--- Resumen

Nombre: GPS Tracking App (GPS)

Plataforma: Android (Android Studio)

Lenguaje: Java

Función: Monitoreo satelital de vehículos en tiempo real sobre Google Maps

--- Características principales

Actualización en tiempo real de coordenadas

Rotación del ícono del vehículo según el rumbo

Polilínea que dibuja todo el recorrido

Visualización de velocidad y timestamp

--- Arquitectura del Backend

El sistema obtiene la información de ubicación del vehículo mediante un servicio WCF conectado a SQL Server.

Los GPS envían datos al servidor y SQL Server almacena cada posición, velocidad, fecha/hora y rumbo.

El servicio WCF consulta la base de datos y expone los datos mediante métodos seguros (SOAP/HTTP).

La app Android consume este servicio para:

Actualizar la posición del vehículo en el mapa

Rotar el ícono según el rumbo

Dibujar la polilínea del recorrido

Mostrar velocidad y timestamp

Funciones clave del WCF:

Consultas eficientes a SQL Server (última posición, polilínea, historial).

Gestión de múltiples dispositivos simultáneamente.

Serialización de datos para consumo desde Android.

Preparación para comunicación en tiempo real mediante intervalos o eventos.

<video width="320" height="240" controls>
  <source src="./media/rastreo_tiempo_real.mp4" type="video/mp4">
  Tu navegador no soporta el video.
</video>
