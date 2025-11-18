private void updateMapLocation(String address, float direction) {

    if (googleMap == null) return;

    //Crear coordenadas actuales
    LatLng point = new LatLng(
            Double.parseDouble(latitude),
            Double.parseDouble(longitude)
    );

    //Eliminar marcador previo
    if (currentMarker != null) {
        currentMarker.remove();
    }

    //InfoWindow personalizado
    googleMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(this));

    // Ícono único para todos los marcadores
    int markerIcon = R.drawable.marker_default;

    //Mostrar coordenadas con formato
    String coordsText = String.format(
            Locale.getDefault(),
            "%.6f, %.6f",
            point.latitude,
            point.longitude
    );

    //Configurar marcador
    MarkerOptions markerOptions = new MarkerOptions()
            .position(point)
            .title("Coordinates: " + coordsText)
            .snippet("Address: " + address)
            .icon(BitmapDescriptorFactory.fromResource(markerIcon))
            .anchor(0.5f, 0.5f)
            .infoWindowAnchor(0.5f, 0f)
            .rotation(direction);

    //Agregar marcador al mapa
    currentMarker = googleMap.addMarker(markerOptions);

    //Dibujar trayectoria
    if (lastPosition != null) {
        googleMap.addPolyline(new PolylineOptions()
                .add(lastPosition, point)
                .color(Color.BLUE)
        );
    }

    //Mover cámara al punto actual
    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 16f));

    //Actualizar última posición
    lastPosition = point;

    //Ajustar cámara al mostrar el InfoWindow
    googleMap.setOnMarkerClickListener(clicked -> {
        if (clicked.equals(currentMarker)) {
            LatLng adjusted = new LatLng(
                    clicked.getPosition().latitude + 0.0015,
                    clicked.getPosition().longitude
            );
            googleMap.animateCamera(CameraUpdateFactory.newLatLng(adjusted));
            clicked.showInfoWindow();
            return true;
        }
        return false;
    });

}
